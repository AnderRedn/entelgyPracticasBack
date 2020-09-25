package entelgyPracticasBack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoginServiceTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testLogin() throws Exception {
//		ResponseEntity<String> res = restTemplate.withBasicAuth("000000001111", "1234").postForEntity("/login", null,
//				String.class);

		MvcResult ress = mvc.perform(post("/login").with(httpBasic("000000001111", "1234"))).andExpect(status().isOk())
				.andReturn();
		assertEquals(200, ress.getResponse().getStatus());
		assertFalse(ress.getResponse().getContentAsString().isEmpty());
	}
}