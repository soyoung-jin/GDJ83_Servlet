package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

	// DTO : Data Transfer Object
	// DAO : Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 ㅇ읽어와서 파싱 한 후에 DTO에 담아서 리턴

	public List<WeatherDTO> getWeathers() throws Exception {
		File file = new File("C:\\study\\weather.test.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			WeatherDTO weatherDTO = new WeatherDTO();
			s = s.replace(",", "-");
			String[] ar = s.split("-");
			weatherDTO.setNum(Long.parseLong(ar[0].trim()));
			weatherDTO.setCity(ar[1].trim());
			weatherDTO.setGion(Double.parseDouble(ar[2].trim()));
			weatherDTO.setHuminity(Integer.parseInt(ar[4].trim()));
			weatherDTO.setStatus(ar[3].trim());
			list.add(weatherDTO);
		}

		br.close();
		fr.close();

		return list;
	}

}