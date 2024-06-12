package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {
	private WeatherService weatherService;

	public WeatherController() {
		this.weatherService = new WeatherService();
	}

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public Action start(HttpServletRequest request) {

		// list
		// add
		// delete
		// detail

		String uri = request.getRequestURI();// request에서 uri를 가져옴

		uri = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);

		if (uri.equals("list")) {
			List<Weather> ar = weatherService.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (uri.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {
			Weather weather = this.weatherService.makeWeather();
			request.setAttribute("weather", weather); // jsp까지 보내주기 위해 지역변수로 소멸되지 않는 request사용
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		} else {

		}
		return action;
	}
}
