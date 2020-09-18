package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.WeatherEmp;
import entelgyPracticasBack.service.WeatherService;

@RestController
@RequestMapping("/rest/tiempo")
public class WeatherController {
	@Autowired
	private WeatherService weathServ;

	/**
	 * Mapping for /bilbao that returns .xlsx file with the weather of Bilbao every
	 * day at 8am.
	 */
	@GetMapping("/bilbao")
	public ResponseEntity<InputStreamResource> selectAllWeather() {
		return weathServ.selectAllWeather();

	}

	@GetMapping("/weatherEmp")
	public List<WeatherEmp> selectAllWeatherEmp() {
		return weathServ.selectAllWeatherEmp();
	}
}
