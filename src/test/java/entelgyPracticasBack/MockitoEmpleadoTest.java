package entelgyPracticasBack;

import static org.junit.jupiter.api.Assertions.fail;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entelgyPracticasBack.dao.IEmpleadoDAO;
import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.service.impl.EmpleadoServiceImpl;
import entelgyPracticasBack.util.MockUtils;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MockitoEmpleadoTest {

	@Mock
	private IEmpleadoDAO empDAO;

	@InjectMocks
	private EmpleadoServiceImpl empServ;

	private ObjectMapper mapper = new ObjectMapper();
	private MockUtils mockUtils = new MockUtils();

	private static final String MOCK_TEST_BASE = "mocks/EmpleadoTest/";
	private static final String LISTA_EMPLEADOS_POSITION_MOCKS = "empleadoMock.json";

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private List<Empleado> initEmpleadoServiceMockJson() {
		List<Empleado> mockEmpleadoModeloRes = new ArrayList<Empleado>();
		try {
			mockEmpleadoModeloRes = mapper.readValue(
					mockUtils.getStringFromFile(MOCK_TEST_BASE + LISTA_EMPLEADOS_POSITION_MOCKS),
					new TypeReference<List<Empleado>>() {
					});

		} catch (Exception e) {
			System.out.println(" Error e:" + e);
		}
		return mockEmpleadoModeloRes;
	}

	@Test
	public void getEmployeeByPosition() throws JsonProcessingException, URISyntaxException {
		List<Empleado> mockEmpleadoModeloRes = initEmpleadoServiceMockJson();
		Mockito.when(empDAO.selectEmpCargo(Mockito.any())).thenReturn(mockEmpleadoModeloRes);
		List<Empleado> resEmpleados = empServ.selectEmpCargo(Mockito.any());
		// assertThat(resEmpleados.size() + "",
		// IsEqualIgnoringCase.equalToIgnoringCase("3"));
		if (CollectionUtils.isEmpty(resEmpleados)) {
			fail("No existen los empleados");
		}
	}

}
