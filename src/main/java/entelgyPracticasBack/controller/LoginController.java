package entelgyPracticasBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entelgyPracticasBack.service.LoginService;

@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginServ;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestHeader(value = "Authorization") String authorization) {
		return loginServ.login(authorization);
	}

}
