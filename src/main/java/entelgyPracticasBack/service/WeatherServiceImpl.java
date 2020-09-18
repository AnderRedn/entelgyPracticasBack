package entelgyPracticasBack.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import entelgyPracticasBack.dao.IEmpleadoDAO;
import entelgyPracticasBack.dao.IWeatherDAO;
import entelgyPracticasBack.model.Weather;
import entelgyPracticasBack.model.WeatherEmp;
import entelgyPracticasBack.model.WeatherSelect;
import entelgyPracticasBack.util.WeatherExcelWriter;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private IWeatherDAO weathDao;

	@Autowired
	private IEmpleadoDAO empDao;

	@Autowired
	private EmailService emailService;

	private static final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);
	private final String ACCESS_KEY = "194a049cedbc41295ac29d7559f9d0c1";
	private final String QUERYB = "BILBAO";
	private String url = "http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=";

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Mapping for /bilbao that returns .xlsx file with the weather of Bilbao every
	 * day at 8am.
	 */
	public ResponseEntity<InputStreamResource> selectAllWeather() {
		logger.info("Select all weathers.");
		ByteArrayInputStream in = null;
		List<WeatherSelect> weatherList = this.weathDao.selectAllWeather();
		try {
			in = WeatherExcelWriter.createWeatherExcel(weatherList);
		} catch (InvalidFormatException e) {
			logger.info("InvalidFormatException in selectAllWeather.");
		} catch (IOException e) {
			logger.info("IOException in selectAllWeather.");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=weather_bilbao.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}

	public List<WeatherEmp> selectAllWeatherEmp() {
		logger.info("Select all employees' weather.");
		return this.weathDao.selectAllWeatherEmp();
	}

	/**
	 * Scheduled method that saves the weather of locations every hour.
	 */
	@Scheduled(fixedRate = 3600000)
	public void insertWeatherBio() {
		logger.info("The time is now {}", dateFormat.format(new Date()));
		RestTemplate restTemplate = new RestTemplate();
		Weather weather = restTemplate.getForObject(url + QUERYB, Weather.class);
		logger.info("Tiempo a guardar: " + weather.toString());
		weathDao.insertWeather(weather);
//		
//		List<Empleado> empleadosList = empDao.selectAllEmp();
//		for (Empleado empleado : empleadosList) {
//			weather = restTemplate.getForObject(url+empleado.getLocalidad(), Weather.class);
//			WeatherEmp wEmp = new WeatherEmp(weather);
//			wEmp.setnDIEmp(empleado.getnDIEmp());
//			logger.info("Tiempo a guardar: "+weather.toString()+ " para empleado "+ empleado.getnDIEmp());
//			weathDao.insertWeatherQuery(wEmp);
//		}
	}

	/**
	 * Scheduled method that sends email with .xlsx file with the weather of Bilbao
	 * every day at 8am.
	 */
	@Scheduled(cron = "0 0 8 * * ?")
	public void sendEmailWeather() {
		logger.info("Sending email with weather info.");
		List<WeatherSelect> weatherList = this.weathDao.selectAllWeather();
		try {
			WeatherExcelWriter.createWeatherFileExcel(weatherList);
		} catch (InvalidFormatException e) {
			logger.info("InvalidFormatException in sendEmailWeather.");
		} catch (IOException e) {
			logger.info("IOException in sendEmailWeather.");
		}

		emailService.sendMailWithAttachment(".\\weather_bilbao.xlsx");
		logger.info("Email with weather info sent.");
	}
}
