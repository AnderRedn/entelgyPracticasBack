package entelgyPracticasBack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import entelgyPracticasBack.model.Empleado;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmpleadoServiceTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private MockMvc mvc;

	private final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwMDAwMDAwMDExMTEiLCJpYXQiOjE2MDA3NzQ2NDgsImV4cCI6MTYwMDg2MTA0OH0.WSPMt-oU3lSNhObUFcG9jRl3DqCb0grSaSukdzbo6Uc";

	@Test
	public void testSelectAllEmpl_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectAllEmp";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpCargo_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpCargo/Secretari@";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpComi_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpComi";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpNomCargoShortBySal_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpNomCargoShortBySal";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpNomSall_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpNomSal";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpSalComiFromDpt2000ShortByComi_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpSalComiFromDpt2000ShortByComi";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectEmpSum_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectEmpSum";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}

	@Test
	public void testSelectVendShortByName_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectVendShortByName";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = super.mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}
}
