package com.edto.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.edto.cursomc.domain.BoletoPayment;
import com.edto.cursomc.domain.CardPayment;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(CardPayment.class);
				objectMapper.registerSubtypes(BoletoPayment.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}

/*
 * Classe de configuração --> É uma classe que contem que contem um método ou qlqr informação que vai está disponivel no sistema e vai ser configurada no inicio da execuçao da aplicação, basta usar o @Congirugation e @Bean. 
 * 
 * É um codigo padrao, exigencia da biblioteca Jackson;
 * 
 * A unica mudança de projeto diferentes são as subClasse que devemos configurar;
 * */
 