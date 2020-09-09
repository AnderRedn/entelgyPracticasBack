package entelgyPracticasBack.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import entelgyPracticasBack.EntelgyPracticasBackApplication;
import entelgyPracticasBack.datos.IEmpleadoDAO;
import entelgyPracticasBack.model.Empleado;

@Repository
public class JDBCEmpleadoDAO extends JdbcDaoSupport implements IEmpleadoDAO {
	
	private static final Logger logger = LogManager.getLogger(JDBCEmpleadoDAO.class);
	private DataSource ds;

	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
		setDataSource(ds);
	}

	@Override
	public List<Empleado> getEmpleados() {
		List<Empleado> emps = null;
		logger.trace("Getting empleados");
		try {
			String resource = "ConfiguracionIBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			emps = sqlMap.queryForList("getEmpleados", null);
		} catch (IOException e) {
			logger.error("JDBCEmpleadoDAO: File not found. " + e.getMessage());
		} catch (SQLException e) {
			logger.error("JDBCEmpleadoDAO: SQLException. " + e.getMessage());
		}
		return emps;
	}

}
