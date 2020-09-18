package entelgyPracticasBack.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {
	ResponseEntity<String> login(String authorization);
}
