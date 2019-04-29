package weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weather.service.WeatherDataService;
import weather.vo.WeatherResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gbs on 19/4/28.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);


    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT = 10;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;

        return this.doGetWeahter(uri);
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeahter(uri);
    }


    private WeatherResponse doGetWeahter(String uri) {
        String key = uri;
        String body = null;
        WeatherResponse weatherResponse = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            logger.info("redis is cache");
            operations = redisTemplate.opsForValue();
            body = operations.get(key);

        } else {
            logger.info("redis is not cache");
            throw new RuntimeException("redis is not cache");
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            weatherResponse = mapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }

}
