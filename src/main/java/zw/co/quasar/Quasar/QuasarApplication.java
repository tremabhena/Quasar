package zw.co.quasar.Quasar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuasarApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuasarApplication.class, args);
	}
}
