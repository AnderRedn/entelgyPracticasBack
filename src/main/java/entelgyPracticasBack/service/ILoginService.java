package entelgyPracticasBack.service;

import org.springframework.http.ResponseEntity;

public interface ILoginService {
	ResponseEntity<String> login(String authorization);
}
