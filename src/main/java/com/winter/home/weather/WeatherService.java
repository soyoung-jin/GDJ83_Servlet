package com.winter.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {
	private StringBuffer sb;

	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울 , 29.3 - 맑음 - 60");
		this.sb.append("-부산 , 33.6 - 흐림 - 90");
		this.sb.append("-제주 , 26.5 - 눈 - 30");
		this.sb.append("-광주 , 10.6 - 태풍 - 80");
	}

	public List<Weather> getWeathers() {
		String info = sb.toString();
		info = info.replace(",", "-");

		ArrayList<Weather> ar = new ArrayList<Weather>();
		StringTokenizer st = new StringTokenizer(info, "-");

		while (st.hasMoreTokens()) {
			Weather weather = new Weather();
			weather.setCity(st.nextToken().trim());
			weather.setGion(Double.parseDouble(st.nextToken().trim()));
			weather.setStatus(st.nextToken().trim());
			weather.setHumidity(Integer.parseInt(st.nextToken().trim()));
			ar.add(weather);

		}

		return ar;

	}

	public Weather makeWeather() {
		Weather weather = new Weather();
		weather.setCity("경기");
		weather.setGion(36.5);
		weather.setHumidity(6);
		weather.setStatus("맑음");

		return weather;
	}

}
