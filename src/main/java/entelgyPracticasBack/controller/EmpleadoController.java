package entelgyPracticasBack.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.dao.EmpleadoDAO;
import entelgyPracticasBack.model.Empleado;

@RestController
@RequestMapping("/rest/empresa")
public class EmpleadoController {
	private final EmpleadoDAO empDao;

	private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

	public EmpleadoController(EmpleadoDAO empDao) {
		this.empDao = empDao;
	}

	@GetMapping("/selectAllEmp")
	public List<Empleado> selectAllEmp() {
		logger.info("Select all employees.");
		return this.empDao.selectAllEmp();
	}

	@GetMapping("/selectEmpCargo/{cargo}")
	public List<Empleado> selectEmpCargo(@PathVariable String cargo) {
		logger.info("Select employees by position.");
		return this.empDao.selectEmpCargo(cargo);
	}

	@GetMapping("/selectEmpNomSal")
	public List<Empleado> selectEmpNomSal() {
		logger.info("Select employees name and salary.");
		return this.empDao.selectEmpNomSal();
	}

	@GetMapping("/selectVendShortByName")
	public List<Empleado> selectVendShortByName() {
		logger.info("Select salesman ordered by name.");
		return this.empDao.selectVendShortByName();
	}

	@GetMapping("/selectEmpNomCargoShortBySal")
	public List<Empleado> selectEmpNomCargoShortBySal() {
		logger.info("Select employees name and position ordered by salary.");
		return this.empDao.selectEmpNomCargoShortBySal();
	}

	@GetMapping("/selectEmpSalComiFromDpt2000ShortByComi")
	public List<Empleado> selectEmpSalComiFromDpt2000ShortByComi() {
		logger.info("Select employees' salary and commissions of dpt 2000 ordered by commission.");
		return this.empDao.selectEmpSalComiFromDpt2000ShortByComi();
	}

	@GetMapping("/selectEmpComi")
	public List<Empleado> selectEmpComi() {
		logger.info("Select all commissions.");
		return this.empDao.selectEmpComi();
	}

	@GetMapping("/selectEmpSum")
	public List<Empleado> selectEmpSum() {
		logger.info("Salary to pay employees of dpt 3000 after summing 500 ordered by name.");
		return this.empDao.selectEmpSum();
	}

}
