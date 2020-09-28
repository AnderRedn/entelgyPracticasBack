package entelgyPracticasBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.service.LoginService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginServ;

	@PostMapping(value = "/login")
	@ApiOperation(value = "Login operation", notes = "Return a token to use in the api given a basic auth.")
	public ResponseEntity<String> login(@RequestHeader(value = "Authorization") String authorization) {
		return loginServ.login(authorization);
	}

}
