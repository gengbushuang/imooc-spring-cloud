package weather.service;

import org.springframework.web.bind.annotation.GetMapping;
import weather.vo.City;

import java.util.List;

/**
 * Created by gbs on 19/4/29.
 */
//@FeignClient("weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity()throws Exception;
}
