package entelgyPracticasBack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EntelgyPracticasBackApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(EntelgyPracticasBackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EntelgyPracticasBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Entering application. Creating tables");
	}

}
