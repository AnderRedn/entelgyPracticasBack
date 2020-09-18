package entelgyPracticasBack.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import entelgyPracticasBack.model.WeatherEmp;

public interface IWeatherService {
	ResponseEntity<InputStreamResource> selectAllWeather();

	List<WeatherEmp> selectAllWeatherEmp();

	void insertWeatherBio();

	void sendEmailWeather();
}
