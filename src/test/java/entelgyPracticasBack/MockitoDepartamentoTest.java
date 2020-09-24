package entelgyPracticasBack;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import entelgyPracticasBack.dao.IDepartamentoDAO;
import entelgyPracticasBack.model.Departamento;
import entelgyPracticasBack.service.impl.DepartamentoServiceImpl;
import entelgyPracticasBack.util.MockUtils;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MockitoDepartamentoTest {

	@Mock
	private IDepartamentoDAO deptDAO;

	@InjectMocks
	private DepartamentoServiceImpl deptServ;

	private ObjectMapper mapper = new ObjectMapper();
	private MockUtils mockUtils = new MockUtils();

	private static final String MOCK_TEST_BASE = "mocks/DepartamentoTest/";
	private static final String LISTA_DEPARTAMENTOS_MOCKS = "departamentoMock.json";

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private List<Departamento> initDepartamentoServiceMockJson() {
		List<Departamento> mockDepartamentoModeloRes = new ArrayList<Departamento>();
		try {
			mockDepartamentoModeloRes = mapper.readValue(
					mockUtils.getStringFromFile(MOCK_TEST_BASE + LISTA_DEPARTAMENTOS_MOCKS),
					new TypeReference<List<Departamento>>() {
					});

		} catch (Exception e) {
			System.out.println(" Error e:" + e);
		}
		return mockDepartamentoModeloRes;
	}

	@Test
	public void getAllDepartment() throws JsonProcessingException, URISyntaxException {
		List<Departamento> mockDepartamentoModeloRes = initDepartamentoServiceMockJson();
		Mockito.when(deptDAO.selectAllDept()).thenReturn(mockDepartamentoModeloRes);
		List<Departamento> resDepartamentos = deptServ.selectAllDept();

		assertFalse(resDepartamentos.isEmpty());
		assertEquals(mockDepartamentoModeloRes, resDepartamentos);
	}
}