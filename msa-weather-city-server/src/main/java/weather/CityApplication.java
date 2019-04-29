package weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by gbs on 19/4/28.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class,args);
    }
}
