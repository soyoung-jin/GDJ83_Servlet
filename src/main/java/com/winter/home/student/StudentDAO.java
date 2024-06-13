package com.winter.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public List<StudentDTO> getStudent() throws Exception {
		File file = new File("C:\\Study\\student.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			StudentDTO sdto = new StudentDTO();

			String[] ar = s.split("-");

			sdto.setNum(Integer.parseInt(ar[0].trim()));
			sdto.setName(ar[1].trim());
			sdto.setKor(Integer.parseInt(ar[2].trim()));
			sdto.setEng(Integer.parseInt(ar[3].trim()));
			sdto.setMath(Integer.parseInt(ar[4].trim()));
			sdto.setTotal(Integer.parseInt(ar[5].trim()));
			sdto.setAvg(Double.parseDouble(ar[6].trim()));

			list.add(sdto);
		}
		br.close();
		fr.close();// 자원 종료

		return list;
	}

	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {

		List<StudentDTO> ar = this.getStudent();

		StudentDTO result = null;
		for (StudentDTO s : ar) {
			if (s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}
		}
		return result;
	}
}
