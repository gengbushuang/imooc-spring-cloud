package weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.service.CityDataService;
import weather.vo.City;

import java.util.Collections;
import java.util.List;

/**
 * Created by gbs on 19/4/29.
 */

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() {
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cities == null) {
            cities = Collections.emptyList();
        }
        return cities;
    }
}
