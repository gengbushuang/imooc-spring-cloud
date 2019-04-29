package weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.service.DataClient;
import weather.service.WeatherReportService;
import weather.vo.Weather;
import weather.vo.WeatherResponse;


/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
//	@Autowired
//	WeatherDataClient weatherDataClient;

	@Autowired
	DataClient dataClient;
	
	@Override
	public Weather getDataByCityId(String cityId) {

//		WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
		WeatherResponse resp = dataClient.getDataByCityId(cityId);
		if(resp==null){
			return null;
		}
		return resp.getData();
	}

}
