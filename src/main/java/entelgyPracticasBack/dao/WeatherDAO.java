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

	private static final Logger logger = LogManager.getLogger(WeatherDAO.class);

	public List<WeatherSelect> selectAllWeather() {
		logger.info("selectAllWeather");
		return sqlSession.selectList(ruteMapper + ".selectAllWeather");
	}

	public List<WeatherEmp> selectAllWeatherEmp() {
		logger.info("selectAllWeatherEmp");
		return sqlSession.selectList(ruteMapper + ".selectAllWeatherEmp");
	}

	public int insertWeather(Weather weather) {
		logger.info("insertWeather");
		return sqlSession.insert(ruteMapper + ".insertWeather", weather);
	}

	public int insertWeatherQuery(WeatherEmp weatherEmp) {
		logger.info("insertWeatherQuery");
		return sqlSession.insert(ruteMapper + ".insertWeatherQuery", weatherEmp);
	}
}
