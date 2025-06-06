package soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class A2SoapApplication {
	public static void main(String[] args) {
		SpringApplication.run(A2SoapApplication.class, args);
	}
}
