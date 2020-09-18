package entelgyPracticasBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.model.Departamento;
import entelgyPracticasBack.service.DepartamentoService;

@RestController
@RequestMapping("/rest/empresa")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService deptServ;

	@GetMapping("/selectAllDept")
	public List<Departamento> selectAllDept() {
		return deptServ.selectAllDept();
	}

	@GetMapping("/selectDeptNomb")
	public List<Departamento> selectDeptNomb() {
		return deptServ.selectDeptNomb();
	}

}
