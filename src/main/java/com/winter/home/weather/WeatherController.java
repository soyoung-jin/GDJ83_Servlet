package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {

	private WeatherService ws;

	public WeatherController() {
		ws = new WeatherService();
	}

	public Action start(HttpServletRequest request) {
		// /weather/***
		// list
		// add
		// delete
		// detail

		// /weather/list
		String uri = request.getRequestURI();

		uri = uri.substring(uri.lastIndexOf("/") + 1);

		System.out.println(uri);

		Action action = new Action();
		action.setFlag(true);

		// 메서드 형식반환
		String method = request.getMethod().toUpperCase();

		if (uri.equals("list")) {
			//
			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (uri.equals("add")) {
			if (method.equals("POST")) {
				// 입력한 데이터 = 파일에 저장할 데이터 = 파라미터 데이터를 service로 보내줘서
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				int humidity = Integer.parseInt(request.getParameter("humidity"));
				String status = request.getParameter("status");

				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setHumidity(humidity);
				weatherDTO.setStatus(status);

				try {
					ws.getAdd(weatherDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				action.setPath("/weather/list");
				// 상대경로 (./ 생략가능) list
				action.setFlag(false); // false로 바꿔서 리턴해줘야 frontcontroller에서 if의 else문을 감

			} else {

				action.setPath("/WEB-INF/views/weather/add.jsp");
			}

		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {
			// 파라미터 꺼내기
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = ws.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO); // (키,밸류)
				action.setPath("/WEB-INF/views/weather/detail.jsp");

			} else {
				request.setAttribute("message", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}

		} else {

		}

		return action;

	}

}