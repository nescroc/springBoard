package tommy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class Ch02Application {
	WebMvcAutoConfiguration wac;
	public static void main(String[] args) {
		SpringApplication.run(Ch02Application.class, args);
	}
}
