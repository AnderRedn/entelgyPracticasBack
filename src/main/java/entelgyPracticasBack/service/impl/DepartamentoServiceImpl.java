package entelgyPracticasBack.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entelgyPracticasBack.dao.IDepartamentoDAO;
import entelgyPracticasBack.model.Departamento;
import entelgyPracticasBack.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private IDepartamentoDAO deptDao;

	private static final Logger LOGGER = LogManager.getLogger(DepartamentoServiceImpl.class);

	public List<Departamento> selectAllDept() {
		LOGGER.info("Select all departments.");
		return deptDao.selectAllDept();
	}

	public List<Departamento> selectDeptNomb() {
		LOGGER.info("List the name of the departments.");
		return deptDao.selectDeptNomb();
	}

}
