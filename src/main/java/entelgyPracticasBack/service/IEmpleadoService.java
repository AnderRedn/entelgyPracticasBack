package entelgyPracticasBack.service;

import java.util.List;

import entelgyPracticasBack.model.Empleado;

public interface IEmpleadoService {
	List<Empleado> selectAllEmp();

	List<Empleado> selectEmpCargo(String cargo);

	List<Empleado> selectEmpNomSal();

	List<Empleado> selectVendShortByName();

	List<Empleado> selectEmpNomCargoShortBySal();

	List<Empleado> selectEmpSalComiFromDpt2000ShortByComi();

	List<Empleado> selectEmpComi();

	List<Empleado> selectEmpSum();

}
