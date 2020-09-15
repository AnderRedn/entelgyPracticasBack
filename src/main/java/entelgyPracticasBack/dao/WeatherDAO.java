package entelgyPracticasBack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import entelgyPracticasBack.model.Weather;
import entelgyPracticasBack.model.WeatherSelect;

@Component
public class WeatherDAO {
	private final SqlSession sqlSession;
	private String ruteMapper = "mybatis.mapper.WeatherMapper";
	
	private static final Logger logger = LogManager.getLogger(WeatherDAO.class);

	public WeatherDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<WeatherSelect> selectAllWeather() {
		logger.info("selectAllWeather");
		return this.sqlSession.selectList(ruteMapper+".selectAllWeather");
	}
	
	public int insertWeather(Weather weather) {
		logger.info("insertWeather");
		return this.sqlSession.insert(ruteMapper+".insertWeather", weather);
	}
}
