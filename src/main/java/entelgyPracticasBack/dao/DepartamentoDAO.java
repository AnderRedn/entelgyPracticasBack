package entelgyPracticasBack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entelgyPracticasBack.model.Departamento;

@Component
public class DepartamentoDAO implements IDepartamentoDAO{

	@Autowired
	private SqlSession sqlSession;
	private String ruteMapper = "mybatis.mapper.DepartamentoMapper";

	private static final Logger logger = LogManager.getLogger(DepartamentoDAO.class);

	public List<Departamento> selectAllDept() {
		logger.info("selectAllDept");
		return this.sqlSession.selectList(ruteMapper + ".selectAllDept");
	}

	public List<Departamento> selectDeptNomb() {
		logger.info("selectDeptNomb");
		return this.sqlSession.selectList(ruteMapper + ".selectAllDept");
	}

}
