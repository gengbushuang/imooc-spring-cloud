package weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import weather.vo.City;
import weather.vo.WeatherResponse;

import java.util.List;

/**
 * Created by gbs on 19/4/29.
 */
@FeignClient(name = "weather-eureka-client-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
