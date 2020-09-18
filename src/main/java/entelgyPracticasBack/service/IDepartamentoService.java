package entelgyPracticasBack.service;

import java.util.List;

import entelgyPracticasBack.model.Departamento;

public interface IDepartamentoService {
	List<Departamento> selectAllDept();
	List<Departamento> selectDeptNomb();
}
