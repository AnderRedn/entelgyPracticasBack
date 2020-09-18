package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.service.EmpleadoService;

@RestController
@RequestMapping("/rest/empresa")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empServ;

	@GetMapping("/selectAllEmp")
	public List<Empleado> selectAllEmp() {
		return empServ.selectAllEmp();
	}

	@GetMapping("/selectEmpCargo/{cargo}")
	public List<Empleado> selectEmpCargo(@PathVariable String cargo) {
		return empServ.selectEmpCargo(cargo);
	}

	@GetMapping("/selectEmpNomSal")
	public List<Empleado> selectEmpNomSal() {
		return empServ.selectEmpNomSal();
	}

	@GetMapping("/selectVendShortByName")
	public List<Empleado> selectVendShortByName() {
		return empServ.selectVendShortByName();
	}

	@GetMapping("/selectEmpNomCargoShortBySal")
	public List<Empleado> selectEmpNomCargoShortBySal() {
		return empServ.selectEmpNomCargoShortBySal();
	}

	@GetMapping("/selectEmpSalComiFromDpt2000ShortByComi")
	public List<Empleado> selectEmpSalComiFromDpt2000ShortByComi() {
		return empServ.selectEmpSalComiFromDpt2000ShortByComi();
	}

	@GetMapping("/selectEmpComi")
	public List<Empleado> selectEmpComi() {
		return empServ.selectEmpComi();
	}

	@GetMapping("/selectEmpSum")
	public List<Empleado> selectEmpSum() {
		return empServ.selectEmpSum();
	}

}
