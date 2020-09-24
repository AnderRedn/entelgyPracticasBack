package entelgyPracticasBack.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MockUtils {
	
	private static final Log Logger = LogFactory.getLog(MockUtils.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public  Object getMockObjectFromFilePath(String filePath) throws Exception {
		try {
			InputStream in= this.getClass().getClassLoader().getResourceAsStream(filePath);
			if(in!=null) {
				ObjectInputStream  ois = new ObjectInputStream(in);
				return ois .readObject();
			}
			Logger.error("************************* ");
			Logger.info(" getMockFile objeto NULO filepath:"+filePath);
			Logger.error("************************* ");
			return null;
		} catch (Exception e) {
			Logger.error("************************* ");
			Logger.info(" getMockFile objeto NULO filepath:"+filePath);
			Logger.error(" getMockFile e:"+e);
			Logger.error("************************* ");
			throw e;
		}
	}
	
	public  String getStringFromObjec(Object codUsuarioWeb) throws  IOException {
		this.objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(codUsuarioWeb);
	}
	
	public String getStringFromFile(String filePath) throws Exception {
		try {
			if (!StringUtils.isEmpty(filePath)) {
				InputStream in= this.getClass().getClassLoader().getResourceAsStream(filePath);
				if(in!=null) {
					return IOUtils.toString(in, "UTF-8");
				}
			}
			Logger.error("************************* ");
			Logger.info(" getStringFromFile objeto NULO filepath:"+filePath);
			Logger.error("************************* ");
			return null;
		} catch (Exception e) {
			Logger.error("************************* ");
			Logger.info(" getStringFromFile objeto NULO filepath:"+filePath);
			Logger.error(" getMockFile e:"+e);
			Logger.error("************************* ");
			throw  e;
		}
	}
	
	
	
	 	

}
