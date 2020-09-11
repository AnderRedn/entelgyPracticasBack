package entelgyPracticasBack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.type.MappedTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import entelgyPracticasBack.model.Empleado;

@MappedTypes(Empleado.class)
//@MapperScan("entelgyPracticasBack.mapper")
@SpringBootApplication
public class EntelgyPracticasBackApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger logger = LogManager.getLogger(EntelgyPracticasBackApplication.class);

	/*Connection conn = null;
	Statement st = null;
	String url = "jdbc:derby:empresaDB";*/

	public static void main(String[] args) {
		SpringApplication.run(EntelgyPracticasBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Entering application. Creating tables");
		createTables();
	}

	private void createTables() {
		/* FIRST WAY, opening conection manually */

//		try {
//			conn = DriverManager.getConnection(url);
//
//			st = conn.createStatement();
//			st.executeUpdate("DROP TABLE departamentos");
//			st.executeUpdate("CREATE TABLE departamentos (codDepto VARCHAR(4) NOT NULL PRIMARY KEY,"
//					+ "  nombreDpto VARCHAR(20) NOT NULL, ciudad VARCHAR(15), codDirector VARCHAR(12))");
//			//DriverManager.getConnection("jdbc:derby:;shutdown=true");
//		} catch (SQLException e) {
//			logger.error("createTables: Error creating tables. " + e);
//			e.printStackTrace();
//		} finally {
//			try {
//				if (st != null) {
//					st.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				logger.error("createTables: Error closing conection. " + e.getMessage());
//			}
//		}

		/* SECOND WAY, using jdbctemplate */

//		jdbcTemplate.execute("DROP TABLE departamentos");
//		jdbcTemplate.execute("CREATE TABLE departamentos (codDepto VARCHAR(4) NOT NULL PRIMARY KEY,"
//				+ "  nombreDpto VARCHAR(20) NOT NULL, ciudad VARCHAR(15), codDirector VARCHAR(12))");
//
////		jdbcTemplate.update("INSERT INTO departamentos VALUES ('AVRQ', 'DPTO_1', 'ZAMURRIO', 'AASSDED')");
////		System.out.println(jdbcTemplate.queryForObject("select count(*) from departamentos", Integer.class));
//
//		jdbcTemplate.execute("CREATE TABLE empleados (nDIEmp VARCHAR(12) NOT NULL PRIMARY KEY,"
//				+ "  nomEmp VARCHAR(30) NOT NULL, sexEmp CHAR(1) NOT NULL, fecNac DATE NOT NULL,"
//				+ "  fecIncorporacion DATE NOT NULL, salEmp FLOAT NOT NULL, comisionE FLOAT NOT NULL,"
//				+ "  cargoE VARCHAR(15) NOT NULL, jefeID VARCHAR(12), codDepto varchar(4) NOT NULL)");
//
//		jdbcTemplate.execute(
//				"ALTER TABLE departamentos ADD CONSTRAINT FK_DIR FOREIGN KEY (codDirector) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION");
//		jdbcTemplate.execute(
//				"ALTER TABLE empleados ADD CONSTRAINT FK_DPTO FOREIGN KEY (codDepto) REFERENCES departamentos (codDepto) ON DELETE NO ACTION ON UPDATE NO ACTION");
//		jdbcTemplate.execute(
//				"ALTER TABLE empleados ADD CONSTRAINT FK_JEFE_EMP FOREIGN KEY (jefeID) REFERENCES empleados (nDIEmp) ON DELETE NO ACTION ON UPDATE NO ACTION");

		/* THIRD WAY, using EmbeddedDatabaseBuilder + read from scipt */
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).addScript("db/empdbcreate.sql").build();
//		// do stuff against the db (EmbeddedDatabase extends javax.sql.DataSource)
//		// db.shutdown();

		logger.info("Tables departamentos and empleados created.");
	}
}
