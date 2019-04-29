package weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import weather.service.CityClient;
import weather.service.DataClient;
import weather.service.WeatherReportService;
import weather.vo.City;
import weather.vo.WeatherResponse;

import java.util.Collections;
import java.util.List;

/**
 * Weather Report Controller.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月24日
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;
//
//    @Autowired
//    CityClient cityClient;

    @Autowired
    DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

        List<City> cityList = null;
        try {
//            cityList = cityClient.listCity();
            cityList = dataClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(cityList==null){
            cityList = Collections.emptyList();
        }

//        WeatherResponse dataByCityId = dataClient.getDataByCityId(cityId);
        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
//        model.addAttribute("report", dataByCityId);
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
