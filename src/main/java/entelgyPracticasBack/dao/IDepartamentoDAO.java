package entelgyPracticasBack.dao;

import java.util.List;

import entelgyPracticasBack.model.Departamento;

public interface IDepartamentoDAO {
	List<Departamento> selectAllDept();

	List<Departamento> selectDeptNomb();
}
