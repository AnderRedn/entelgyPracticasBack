package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.Departamento;
import entelgyPracticasBack.service.DepartamentoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/empresa")
public class DepartamentoController {

	@Autowired
	private DepartamentoService deptServ;

	@GetMapping(value = "/selectAllDept", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select all departments", notes = "Return all of the departments in a list")
	public List<Departamento> selectAllDept() {
		return deptServ.selectAllDept();
	}

	@GetMapping(value = "/selectDeptNomb", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Select names departments", notes = "Return all of the names of the departments in a list")
	public List<Departamento> selectDeptNomb() {
		return deptServ.selectDeptNomb();
	}

}
