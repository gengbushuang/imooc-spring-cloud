package com.geng.spring.cloud.weather.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.geng.spring.cloud.weather.service.CityDataService;
import com.geng.spring.cloud.weather.util.XmlBuilder;
import com.geng.spring.cloud.weather.vo.City;
import com.geng.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


/**
 * City Data Service.
 * 
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while ((line = br.readLine()) !=null) {
			buffer.append(line);
		}
		
		br.close();
		
		// XML转为Java对象
		CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
		return cityList.getCityList();
	}

}
