package entelgyPracticasBack.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entelgyPracticasBack.dao.DepartamentoDAO;
import entelgyPracticasBack.model.Departamento;

@Service
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	private DepartamentoDAO deptDao;

	private static final Logger logger = LogManager.getLogger(DepartamentoService.class);

	public List<Departamento> selectAllDept() {
		logger.info("Select all departments.");
		return deptDao.selectAllDept();
	}

	public List<Departamento> selectDeptNomb() {
		logger.info("List the name of the departments.");
		return deptDao.selectDeptNomb();
	}

}
