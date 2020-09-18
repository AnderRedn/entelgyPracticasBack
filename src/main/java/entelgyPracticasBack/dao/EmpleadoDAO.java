package entelgyPracticasBack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entelgyPracticasBack.exception.UserNotExistException;
import entelgyPracticasBack.model.Empleado;

@Component
public class EmpleadoDAO implements IEmpleadoDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private String ruteMapper = "mybatis.mapper.EmpleadoMapper";

	private static final Logger logger = LogManager.getLogger(EmpleadoDAO.class);

	public List<Empleado> selectAllEmp() {
		logger.info("selectAllEmp");
		return this.sqlSession.selectList(ruteMapper + ".selectAllEmp");
	}

	public List<Empleado> selectEmpCargo(String cargo) {
		logger.info("selectEmpCargo");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpCargo", cargo);
	}

	public List<Empleado> selectEmpNomSal() {
		logger.info("selectEmpNomSal");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpNomSal");
	}

	public List<Empleado> selectVendShortByName() {
		logger.info("selectVendShortByName");
		return this.sqlSession.selectList(ruteMapper + ".selectVendShortByName");
	}

	public List<Empleado> selectEmpNomCargoShortBySal() {
		logger.info("selectEmpNomCargoShortBySal");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpNomCargoShortBySal");
	}

	public List<Empleado> selectEmpSalComiFromDpt2000ShortByComi() {
		logger.info("selectEmpSalComiFromDpt2000ShortByComi");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpSalComiFromDpt2000ShortByComi");
	}

	public List<Empleado> selectEmpComi() {
		logger.info("selectEmpComi");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpComi");
	}

	public List<Empleado> selectEmpSum() {
		logger.info("selectEmpSum");
		return this.sqlSession.selectList(ruteMapper + ".selectEmpSum");
	}

	public Empleado selectEmpById(String id) throws UserNotExistException {
		logger.info("selectEmpById");
		Empleado emp = this.sqlSession.selectOne(ruteMapper + ".selectEmpById", id);
		if (emp == null) {
			throw new UserNotExistException();
		}
		return emp;
	}

}
