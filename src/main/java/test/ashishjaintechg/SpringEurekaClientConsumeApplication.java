package test.ashishjaintechg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@SpringBootApplication
@EnableEurekaClient
@RequestMapping("/wrapper")
public class SpringEurekaClientConsumeApplication {

	@Autowired
    private EurekaClient eurekaClient;
	
	@Bean
	public RestTemplate getRestTemplate() {
	
		return new RestTemplate();
	}
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String greetingsWrapper() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("CLIENT-SERVICE", false);
	    String response = getRestTemplate().getForObject(instance.getHomePageUrl() + "/client/test", String.class);
		return "****"+response+"****";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientConsumeApplication.class, args);
	}

}
