package entelgyPracticasBack.controller;

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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entelgyPracticasBack.dao.WeatherDAO;
import entelgyPracticasBack.model.Weather;
import entelgyPracticasBack.model.WeatherSelect;
import entelgyPracticasBack.service.EmailService;
import entelgyPracticasBack.util.WeatherExcelWriter;

@RestController
@RequestMapping("/rest/tiempo")
@Component
public class WeatherRestController {
	@Autowired
	private WeatherDAO weathDao;

	@Autowired
	private EmailService emailService;

	private static final Logger logger = LogManager.getLogger(WeatherRestController.class);
	private final String ACCESS_KEY = "194a049cedbc41295ac29d7559f9d0c1";
	private final String QUERY = "BILBAO";
	private String url = "http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=" + QUERY;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Mapping for /bilbao that returns .xlsx file with the weather of Bilbao every
	 * day at 8am.
	 */
	@GetMapping("/bilbao")
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

	/**
	 * Scheduled method that saves the weather of Bilbao every hour.
	 */
	@Scheduled(fixedRate = 3600000)
	public void insertWeatherBio() {
		logger.info("The time is now {}", dateFormat.format(new Date()));
		RestTemplate restTemplate = new RestTemplate();
		Weather weather = restTemplate.getForObject(url, Weather.class);
		logger.info(weather.toString());
		weathDao.insertWeather(weather);
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
