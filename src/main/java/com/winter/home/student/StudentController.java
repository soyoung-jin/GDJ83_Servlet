package com.winter.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class StudentController {
	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public Action start(HttpServletRequest request) {

		// /student/???
		// list -> 학생 정보 전체 출력
		// add -> 학생 한명 정보 추가
		// delete -> 학생 한명 삭제
		// detail -> 학생 한명 정보 출력

		// ??? 저 물음표가 뭔지 봐야함. 이 정보는 uri에서 꺼냄 uri는 request에서 꺼냄
		// 잘라서 프린트물 써고 list 넣으면 list출력
		String uri = request.getRequestURI();

		uri = uri.substring(uri.lastIndexOf("/") + 1);

		Action action = new Action();
		action.setFlag(true);

		String method = request.getMethod();

		if (uri.equals("list")) {
			List<StudentDTO> ar = studentService.getStudent();
			request.setAttribute("list", ar);
			// jsp의 경로를 담아야 하며, 절대경로로 적는다.
			action.setPath("/WEB-INF/views/student/list.jsp");
		} else if (uri.equals("add")) {
			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터를 꺼내야 함");
				StudentDTO student = new StudentDTO();
				String name = request.getParameter("name");
				System.out.println(name);
				student.setName(name);
				student.setNum(Integer.parseInt(request.getParameter("num")));
				student.setAvg(Double.parseDouble(request.getParameter("avg")));

				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));
				String[] check = request.getParameterValues("check");
				for (String c : check) {
					System.out.println(c);
				}

				action.setFlag(false);
				action.setPath("./list");

			} else {
				action.setPath("/WEB-INF/views/student/add.jsp");

			}

		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {

			String num = request.getParameter("num");
			StudentDTO studentDTO = new StudentDTO();

			studentDTO.setNum(Integer.parseInt(num));
			studentDTO = studentService.getDetail(studentDTO);

			if (studentDTO != null) {
				request.setAttribute("student", studentDTO); // jsp까지 보내주기 위해 지역변수로 소멸되지 않는 request사용
				action.setPath("/WEB-INF/views/student/detail.jsp");

			} else {
				request.setAttribute("message", "정보를 찾을 수 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}

		} else {

		}
		return action;
	}

}
