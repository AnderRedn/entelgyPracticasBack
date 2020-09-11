package entelgyPracticasBack.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.dao.DepartamentoDAO;
import entelgyPracticasBack.model.Departamento;

@RestController
@RequestMapping("/rest/empresa")
public class DepartamentoController {
	private final DepartamentoDAO deptDao;

	private static final Logger logger = LogManager.getLogger(DepartamentoController.class);

	public DepartamentoController(DepartamentoDAO deptDao) {
		this.deptDao = deptDao;
	}

	@GetMapping("/selectAllDept")
	public List<Departamento> selectAllDept() {
		logger.info("Select all departments.");
		return this.deptDao.selectAllDept();
	}

	@GetMapping("/selectDeptNomb")
	public List<Departamento> selectDeptNomb() {
		logger.info("List the name of the departments.");
		return this.deptDao.selectDeptNomb();
	}

}
