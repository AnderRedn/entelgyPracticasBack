package entelgyPracticasBack.dao;

import java.util.List;

import entelgyPracticasBack.model.Weather;
import entelgyPracticasBack.model.WeatherEmp;
import entelgyPracticasBack.model.WeatherSelect;

public interface IWeatherDAO {
	List<WeatherSelect> selectAllWeather();

	List<WeatherEmp> selectAllWeatherEmp();

	int insertWeather(Weather weather);

	int insertWeatherQuery(WeatherEmp weatherEmp);
}
