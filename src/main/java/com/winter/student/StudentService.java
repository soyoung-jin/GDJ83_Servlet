package com.winter.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {

	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			Student st = new Student();
			st.setNum(i + 1);
			st.setName("학생" + (i + 1));
			st.setAvg(random.nextInt(100) + random.nextDouble());

			ar.add(st);

		}
		return ar;

	}

	public Student makeStudent() {
		Student student = new Student();
		student.setNum(1);
		student.setName("Winter");
		student.setAvg(56.35);

		return student;

		// DB에서 꺼내올 데이터
	}
}
