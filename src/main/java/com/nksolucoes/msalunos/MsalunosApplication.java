package com.nksolucoes.msalunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsalunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsalunosApplication.class, args);
	}

}
