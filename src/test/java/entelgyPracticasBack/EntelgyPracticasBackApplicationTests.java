package entelgyPracticasBack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entelgyPracticasBack.model.Departamento;
import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.model.WeatherEmp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EntelgyPracticasBackApplicationTests {
	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mvc;

	private static final Logger LOGGER = LogManager.getLogger(EntelgyPracticasBackApplicationTests.class);

	private final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwMDAwMDAwMDExMTEiLCJpYXQiOjE2MDA3NzQ2NDgsImV4cCI6MTYwMDg2MTA0OH0.WSPMt-oU3lSNhObUFcG9jRl3DqCb0grSaSukdzbo6Uc";

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void testLogin() throws Exception {
		ResponseEntity<String> res = restTemplate.withBasicAuth("000000001111", "1234").postForEntity("/login", null,
				String.class);

//		MvcResult ress = mvc.perform(post("/login").with(httpBasic("000000001111", "1234"))).andExpect(status().isOk())
//				.andReturn();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		LOGGER.info(res.getBody());
		assertThat(res.getBody() != null);
	}

	@Test
	public void testWeatherBilbao() throws Exception {
		MvcResult res = mvc.perform(MockMvcRequestBuilders.get("/rest/tiempo/bilbao").header("Authorization", TOKEN))
				.andExpect(status().isOk()).andReturn();
		assertThat(
				res.getResponse().getHeader("Content-Disposition").equals("attachment; filename=weather_bilbao.xlsx"));
	}

	@Test
	public void testWeatherEmployees_expect200andJson() throws Exception {
		String uri = "/rest/tiempo/weatherEmp";
		MvcResult res = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = res.getResponse().getContentAsString();
		WeatherEmp[] weathlist = mapFromJson(content, WeatherEmp[].class);
		assertTrue(weathlist.length > 0);
	}

	@Test
	public void testSelectAllDept_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectAllDept";
		MvcResult res = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = res.getResponse().getContentAsString();
		Departamento[] deptlist = mapFromJson(content, Departamento[].class);
		assertTrue(deptlist.length > 0);
	}

	@Test
	public void testlistNameDepts_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectDeptNomb";
		MvcResult res = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		LOGGER.info("pepe" + res.getResponse().getContentAsString());
		String content = res.getResponse().getContentAsString();
		Departamento[] deptlist = mapFromJson(content, Departamento[].class);
		assertTrue(deptlist.length > 0);
	}

	@Test
	public void testSelectAllEmpl_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectAllEmp";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
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
		Empleado[] emplist = mapFromJson(content, Empleado[].class);
		assertTrue(emplist.length > 0);
	}
}
