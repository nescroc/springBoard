package tommy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"tommy.spring","tommy.framework"})
public class Ch01Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Ch01Application.class);
		application.run(args);
		
	}

}
