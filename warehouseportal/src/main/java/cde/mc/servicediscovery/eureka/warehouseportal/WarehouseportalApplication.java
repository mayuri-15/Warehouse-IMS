package cde.mc.servicediscovery.eureka.warehouseportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WarehouseportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseportalApplication.class, args);
	}

}
