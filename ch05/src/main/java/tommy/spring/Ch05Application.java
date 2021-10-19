package tommy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch05Application {

	public static void main(String[] args) {
		SpringApplication application =
				new SpringApplication(Ch05Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
