package entelgyPracticasBack;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class EntelgyPracticasBackApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(EntelgyPracticasBackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EntelgyPracticasBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Connection conn =DriverManager.getConnection("jdbc:derby:empresaDB");

		logger.trace("Entering application.");
		
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).addScript("db/empdbcreate.sql").build();
		// do stuff against the db (EmbeddedDatabase extends javax.sql.DataSource)
		db.shutdown();

	}

}
