package entelgyPracticasBack.service;

import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import entelgyPracticasBack.dao.IEmpleadoDAO;
import entelgyPracticasBack.exception.UserNotExistException;
import entelgyPracticasBack.model.Empleado;
import entelgyPracticasBack.util.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private IEmpleadoDAO empDao;

	@Autowired
	private JwtUtil jwtUtil;

	private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);

	@PostMapping("/login")
	public ResponseEntity<String> login(String authorization) {
		logger.info("Checking authorization of login");
		String[] values = null;
		if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
			String base64Credentials = authorization.substring("Basic".length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(credDecoded);
			// credentials = username:password
			values = credentials.split(":", 2);
		}

		Empleado emp = null;
		try {
			emp = empDao.selectEmpById(values[0]);
		} catch (UserNotExistException e) {
			logger.warn("User does not exist in DDBB");
		}

		if (emp != null && emp.getPassword().equals(values[1])) {
			logger.info("Login authorized");
			return new ResponseEntity<String>(jwtUtil.getToken(emp.getnDIEmp()), HttpStatus.OK);
		}
		logger.info("Login unauthorized");
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}

}
