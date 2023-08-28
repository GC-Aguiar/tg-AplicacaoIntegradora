package taubate.fatec.tg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage( "taubate.fatec.tg.controller" ))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Sistema Integrador de Dados Básicos do Munícipe")
				.description(
				"Documentação da API do Sistema Integrador de Dados Básicos do Munícipe (SIDBM), aqui é apresentada todas as informações necessárias para utilização da API em sua aplicação.")
				.version("1.1.0")
				.build();
	}
}
