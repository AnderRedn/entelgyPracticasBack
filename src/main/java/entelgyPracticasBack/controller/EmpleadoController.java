package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.service.EmpleadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/empresa")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empServ;

	@GetMapping(value = "/selectAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select all employees", notes = "Return all of the employees in a list")
	public List<Empleado> selectAllEmp() {
		return empServ.selectAllEmp();
	}

	@GetMapping(value = "/selectEmpCargo/{cargo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select employees by position", notes = "Return employees of a given position in a list")
	public List<Empleado> selectEmpCargo(@PathVariable String cargo) {
		return empServ.selectEmpCargo(cargo);
	}

	@GetMapping(value = "/selectEmpNomSal", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select employees name and salary", notes = "Return all of the employees name and salary in a list")
	public List<Empleado> selectEmpNomSal() {
		return empServ.selectEmpNomSal();
	}

	@GetMapping(value = "/selectVendShortByName", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select salesman ordered by name", notes = "Return all of the salesman ordered by name in a list")
	public List<Empleado> selectVendShortByName() {
		return empServ.selectVendShortByName();
	}

	@GetMapping(value = "/selectEmpNomCargoShortBySal", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select employees name and position ordered by salary", notes = "Return employees name and position ordered by salary in a list")
	public List<Empleado> selectEmpNomCargoShortBySal() {
		return empServ.selectEmpNomCargoShortBySal();
	}

	@GetMapping(value = "/selectEmpSalComiFromDpt2000ShortByComi", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select employees' salary and commissions of dpt 2000 ordered by commission", notes = "Return employees' salary and commissions of dpt 2000 ordered by commission in a list")
	public List<Empleado> selectEmpSalComiFromDpt2000ShortByComi() {
		return empServ.selectEmpSalComiFromDpt2000ShortByComi();
	}

	@GetMapping(value = "/selectEmpComi", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select all commissions", notes = "Return the employees' commissions in a list")
	public List<Empleado> selectEmpComi() {
		return empServ.selectEmpComi();
	}

	@GetMapping(value = "/selectEmpSum", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Salary to pay employees of dpt 3000 after summing 500 ordered by name.", notes = "Return the employees list of dpt 3000 after summing 500 to their salary ordered by name")
	public List<Empleado> selectEmpSum() {
		return empServ.selectEmpSum();
	}

}
