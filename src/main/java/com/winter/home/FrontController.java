package com.winter.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.home.student.StudentController;
import com.winter.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/FrontController") // Controller의 역할: 어떤 경로로 갈지 컨트롤해줌
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	String a = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UFT-8");
		response.setCharacterEncoding("UFT-8");
		System.out.println("실행됨");

		Action action = new Action();
		String uri = request.getRequestURI();
		String method = request.getMethod();

		System.out.println(uri);
		System.out.println(method);
		String[] p = uri.split("/");

		if (uri.equals("/")) {
			action.setFlag(true);
			action.setPath("/WEB-INF/views/index.jsp");

		} else if (p[1].equals("student")) {

			StudentController st = new StudentController();
			action = st.start(request);

		} else if (p[1].equals("weather")) {

			WeatherController wc = new WeatherController();
			action = wc.start(request);

		}
		if (action.isFlag()) {

			RequestDispatcher view = request.getRequestDispatcher(action.getPath());
			view.forward(request, response); // jsp로 이동하자! 는 거임 이 코드는 이 메서드 내에서 한번만 실행되게끔 해야 한다.

		} else {

			response.sendRedirect(action.getPath());

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
