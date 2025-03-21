package com.mx.Tienda.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	/*
	 * BEAN DE MANERA SIMPLE ES UN CONTENEDOR (BODEGA) DE INSTANCIAS PARA NO CREAR
	 * UNA A CADA RATO, LAS PODEMOS OCUPAR DENTRO DEL CODIGO CUANDO LAS NECESITEMOS
	 * 
	 * @Bean es una anotación que se utiliza en clases de configuracion
	 * (@configuration) Se utiliza para indicar que un metodo produce un Bean que
	 * sera administrado por el contenedor de instancias de spring
	 * 
	 * Qué es un "BEAN"?: En Spring es un objeto que forma parte del contexto de la
	 * aplicación y además es administrado por el Contenedor de instancias de
	 * Spring. Estos objetos pueden ser inyectados por otras partes del codigo
	 * mediante la "Inyeccion de Dependencias". En resumen, un bean es una única
	 * instancia que se encuentra almacenada en el
	 * "contenedor de instancias de Spring framework". Esto para garantizar que solo
	 * exista una sola instancia de ese objeto
	 */

	@Bean
	RestTemplate restTemplate() { // Rest template permite a tu aplicación enviar y recibir 
									// datos de otros servidores.
		return new RestTemplate();
	}

}
