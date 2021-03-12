package it.sirfin.contocorrentebancarioserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"it.sirfin.contocorrentebancarioserver"})

public class ContoCorrenteBancarioServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContoCorrenteBancarioServerApplication.class, args);
	}

}
