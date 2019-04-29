package weather.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import weather.vo.City;
import weather.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbs on 19/4/29.
 */
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>(2);

        City city1 = new City();
        city1.setCityId("101280601");
        city1.setCityName("深圳");
        cityList.add(city1);

        City city2 = new City();
        city2.setCityId("101280301");
        city2.setCityName("惠州");
        cityList.add(city2);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) {

        return null;
    }
}
