package cde.mc.servicediscovery.eureka.warehouseportal;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WarehouseController {


    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/getvehicleregistration")
    public String getVehicleRegistration(){
        RestTemplate restTemplate =restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("VEHICLEREGISTRATION", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseUrl+"/registration/location",String.class);
    }
    @GetMapping("/getuserlogin")
    public String getUserLogin(){
        RestTemplate restTemplate =restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("VEHICLEREGISTRATION", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseUrl+"/login/location",String.class);
    }
    @GetMapping("/getactivity")
    public String getactivity(){
        RestTemplate restTemplate =restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("MANAGETYPEOFACTIVITY", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseUrl+"/managetypeofactivities/location",String.class);
    }

    @GetMapping("/getreport")
    public String getreport(){
        RestTemplate restTemplate =restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("REPORTGENERATION", false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseUrl+"/generatereport/location",String.class);
    }
}
