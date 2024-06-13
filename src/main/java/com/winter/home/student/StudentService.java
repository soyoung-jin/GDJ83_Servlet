package com.winter.home.student;

import java.util.List;

public class StudentService {

	public StudentDAO studentDAO;

	public StudentService() {// StudentService 클래스의 객체를 사용할때, dao객체도 생성되게 하여 DAO의 메서드를 사용할 수 있게 하는 것임.
		studentDAO = new StudentDAO();
	}

	public List<StudentDTO> getStudent() {
		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
//	public List<StudentDTO> getStudents() {
//		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
//		Random random = new Random();
//
//		for (int i = 0; i < 5; i++) {
//			StudentDTO st = new StudentDTO();
//			st.setNum(i + 1);
//			st.setName("학생" + (i + 1));
//			st.setAvg(random.nextInt(100) + random.nextDouble());
//
//			ar.add(st);
//
//		}
//		return ar;
//
//	}

//	public StudentDTO makeStudent() {
//		StudentDTO student = new StudentDTO();
//		student.setNum(1);
//		student.setName("Winter");
//		student.setAvg(56.35);
//
//		return student;
//
//		// DB에서 꺼내올 데이터
//	}

	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		return studentDTO;
	}
}
