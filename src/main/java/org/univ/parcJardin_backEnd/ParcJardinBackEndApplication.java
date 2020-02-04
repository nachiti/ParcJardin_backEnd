package org.univ.parcJardin_backEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.univ.parcJardin_backEnd.service.IParcJardinIntService;

@SpringBootApplication
public class ParcJardinBackEndApplication implements CommandLineRunner {

	@Autowired
	IParcJardinIntService iParcJardinIntService;

	public static void main(String[] args) {
		SpringApplication.run(ParcJardinBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		iParcJardinIntService.initServices();
		iParcJardinIntService.initParcJardins();
		//iParcJardinIntService.initUtilisateurs();
		iParcJardinIntService.initCommentaires();
		iParcJardinIntService.initImages();
	}
}
