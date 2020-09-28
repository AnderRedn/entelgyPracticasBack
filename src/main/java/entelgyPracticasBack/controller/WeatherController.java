package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.WeatherEmp;
import entelgyPracticasBack.service.WeatherService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/tiempo")
public class WeatherController {
	@Autowired
	private WeatherService weathServ;

	/**
	 * Mapping for /bilbao that returns .xlsx file with the weather of Bilbao every
	 * day at 8am.
	 */
	@GetMapping(value = "/bilbao")
	@ApiOperation(value = "Select all weather", notes = "Return all the weather data in a .xlsx")
	public ResponseEntity<InputStreamResource> selectAllWeather() {
		return weathServ.selectAllWeather();

	}

	@GetMapping(value = "/weatherEmp", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select all weather of employees", notes = "Return all of the employees weather data in a list")
	public List<WeatherEmp> selectAllWeatherEmp() {
		return weathServ.selectAllWeatherEmp();
	}
}
