package entelgyPracticasBack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entelgyPracticasBack.model.Weather;
import entelgyPracticasBack.model.WeatherEmp;
import entelgyPracticasBack.model.WeatherSelect;

@Component
public class WeatherDAO implements IWeatherDAO{
	@Autowired
	private SqlSession sqlSession;
	private String ruteMapper = "mybatis.mapper.WeatherMapper";

	private static final Logger LOGGER = LogManager.getLogger(WeatherDAO.class);

	public List<WeatherSelect> selectAllWeather() {
		LOGGER.info("selectAllWeather");
		return sqlSession.selectList(ruteMapper + ".selectAllWeather");
	}

	public List<WeatherEmp> selectAllWeatherEmp() {
		LOGGER.info("selectAllWeatherEmp");
		return sqlSession.selectList(ruteMapper + ".selectAllWeatherEmp");
	}

	public int insertWeather(Weather weather) {
		LOGGER.info("insertWeather");
		return sqlSession.insert(ruteMapper + ".insertWeather", weather);
	}

	public int insertWeatherQuery(WeatherEmp weatherEmp) {
		LOGGER.info("insertWeatherQuery");
		return sqlSession.insert(ruteMapper + ".insertWeatherQuery", weatherEmp);
	}
}
