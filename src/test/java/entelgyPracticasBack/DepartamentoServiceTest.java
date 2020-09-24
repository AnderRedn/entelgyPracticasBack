package entelgyPracticasBack;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import entelgyPracticasBack.model.Departamento;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DepartamentoServiceTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	private MockMvc mvc;

	private final String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwMDAwMDAwMDExMTEiLCJpYXQiOjE2MDA3NzQ2NDgsImV4cCI6MTYwMDg2MTA0OH0.WSPMt-oU3lSNhObUFcG9jRl3DqCb0grSaSukdzbo6Uc";

	@Test
	public void testSelectAllDept_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectAllDept";
		MvcResult res = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = res.getResponse().getContentAsString();
		Departamento[] deptlist = super.mapFromJson(content, Departamento[].class);
		assertTrue(deptlist.length > 0);
	}

	@Test
	public void testlistNameDepts_expect200andJson() throws Exception {
		String uri = "/rest/empresa/selectDeptNomb";
		MvcResult res = mvc.perform(
				MockMvcRequestBuilders.get(uri).header("Authorization", TOKEN).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = res.getResponse().getContentAsString();
		Departamento[] deptlist = super.mapFromJson(content, Departamento[].class);
		assertTrue(deptlist.length > 0);
	}

}
