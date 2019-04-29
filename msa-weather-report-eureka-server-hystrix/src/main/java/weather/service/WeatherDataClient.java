package weather.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import weather.vo.WeatherResponse;

/**
 * Created by gbs on 19/4/29.
 */
//@FeignClient("weather-data-server")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
