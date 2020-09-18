package entelgyPracticasBack.dao;

import java.util.List;

import entelgyPracticasBack.exception.UserNotExistException;
import entelgyPracticasBack.model.Empleado;

public interface IEmpleadoDAO {
	List<Empleado> selectAllEmp();

	List<Empleado> selectEmpCargo(String cargo);

	List<Empleado> selectEmpNomSal();

	List<Empleado> selectVendShortByName();

	List<Empleado> selectEmpNomCargoShortBySal();

	List<Empleado> selectEmpSalComiFromDpt2000ShortByComi();

	List<Empleado> selectEmpComi();

	List<Empleado> selectEmpSum();

	Empleado selectEmpById(String id) throws UserNotExistException;
}
