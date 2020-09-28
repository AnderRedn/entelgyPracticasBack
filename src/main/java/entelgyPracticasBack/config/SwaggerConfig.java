package entelgyPracticasBack.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("entelgyPracticasBack.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(commonParameters())
				.globalResponseMessage(RequestMethod.POST, responseMessageList())
				.globalResponseMessage(RequestMethod.GET, responseMessageList());
	}
	
	private List<Parameter> commonParameters(){
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("token for authorization")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build());

        return parameters;
    }
	
	private List<ResponseMessage> responseMessageList() {
		 List<ResponseMessage> responses=new ArrayList<ResponseMessage>();
		 responses.add(new ResponseMessageBuilder().code(200).message("Success").build());
		 responses.add(new ResponseMessageBuilder().code(202).message("INFO").build());
		 responses.add(new ResponseMessageBuilder().code(206).message("WARN").build());
		 responses.add(new ResponseMessageBuilder().code(400).message("BAD_REQUEST").build());
		 responses.add(new ResponseMessageBuilder().code(401).message("UNAUTHORIZED").build());
		 responses.add(new ResponseMessageBuilder().code(418).message("TEA_POT").build());
	     return responses;
	 }
	
//	@SuppressWarnings("unchecked")
//	private Predicate<String> permittedPaths() {
//		return or(
//		regex("/rest/*.*")
//		//regex("/*.*")
//		);
//	}
}