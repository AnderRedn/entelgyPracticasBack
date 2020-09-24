package entelgyPracticasBack.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import entelgyPracticasBack.dao.IEmpleadoDAO;
import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private IEmpleadoDAO empDao;

	private static final Logger logger = LogManager.getLogger(EmpleadoServiceImpl.class);

	public List<Empleado> selectAllEmp() {
		logger.info("Select all employees.");
		return this.empDao.selectAllEmp();
	}

	public List<Empleado> selectEmpCargo(@PathVariable String cargo) {
		logger.info("Select employees by position.");
		return this.empDao.selectEmpCargo(cargo);
	}

	public List<Empleado> selectEmpNomSal() {
		logger.info("Select employees name and salary.");
		return this.empDao.selectEmpNomSal();
	}

	public List<Empleado> selectVendShortByName() {
		logger.info("Select salesman ordered by name.");
		return this.empDao.selectVendShortByName();
	}

	public List<Empleado> selectEmpNomCargoShortBySal() {
		logger.info("Select employees name and position ordered by salary.");
		return this.empDao.selectEmpNomCargoShortBySal();
	}

	public List<Empleado> selectEmpSalComiFromDpt2000ShortByComi() {
		logger.info("Select employees' salary and commissions of dpt 2000 ordered by commission.");
		return this.empDao.selectEmpSalComiFromDpt2000ShortByComi();
	}

	public List<Empleado> selectEmpComi() {
		logger.info("Select all commissions.");
		return this.empDao.selectEmpComi();
	}

	public List<Empleado> selectEmpSum() {
		logger.info("Salary to pay employees of dpt 3000 after summing 500 ordered by name.");
		return this.empDao.selectEmpSum();
	}

}
