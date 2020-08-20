package cde.mc.zuulapigateway.zuulapigatewayims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulapigatewayimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulapigatewayimsApplication.class, args);
	}

}
