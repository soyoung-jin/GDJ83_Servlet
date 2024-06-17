package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeatherDAO {

	// DTO : Data Transfer Object
	// DAO : Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 읽어와서 파싱 한 후에 DTO에 담아서 리턴

	// 파일에서 전체를 꺼내오는 메서드
	public List<WeatherDTO> getWeathers() throws Exception {
		File file = new File("C:\\Study\\weather.test.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			WeatherDTO wdto = new WeatherDTO();

			s = s.replace(",", "-");

			String[] ar = s.split("-");
			wdto.setNum(Long.parseLong(ar[0].trim()));
			wdto.setCity(ar[1].trim());
			wdto.setGion(Double.parseDouble(ar[2].trim()));
			wdto.setStatus(ar[3].trim());
			wdto.setHumidity(Integer.parseInt(ar[4].trim()));
			list.add(wdto);
		}

		br.close();
		fr.close();

		return list;
	}

	// detail 하나만 꺼내오는 메서드
	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		// num을 가져오기위해 DTO를 매개변수로 가져옴
		// 서울 누르면 1번에 해당하는 정보를 꺼내오려고 함
		List<WeatherDTO> ar = this.getWeathers();
		// WeatherDTO랑 일치하는 애를 찾음

		WeatherDTO result = null;
		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
				// 찾은 DTO를 JSP로 보내주고 싶으면? w를 request에 담아야 함.
				// request가 controller까지 가야하고 현재는 dao에 있음
				// 그니까 dao에서 service로 service에서 controller로 해서 jsp로 보내줘야함
			}
		}
		return result;
		// null이라면 못찾은거고 찾은거면 result의 w가 들어감. 그래서 return을 null로 함

	}

	// add메서드
	public void add(WeatherDTO weatherDTO) throws Exception {
		/*
		 * 도시명-기온-상태-습도 가 나오는 것을 먼저 테스트 해봄 (Stringbuffer사용)
		 */

		List<WeatherDTO> ar = this.getWeathers();

		StringBuffer sb = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		sb.append(ca.getTimeInMillis()); // 번호 추가
		sb.append("-");
		sb.append(weatherDTO.getCity());
		sb.append("-");
		sb.append(weatherDTO.getGion());
		sb.append("-");
		sb.append(weatherDTO.getStatus());
		sb.append("-");
		sb.append(weatherDTO.getHumidity());

//		File file = new File("C:\\Study", "weather.test.txt");사실 굳이 안만들어도 됨
		File file = new File("C:\\Study\\weather.test.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(sb.toString() + "\r\n");// carriage return
		fw.flush();
		fw.close();

	}

	// 지우는 메서드
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list를 호출 , 지우려하는 num과 일치하는 것을 list에서 삭제
		// list를 파일에 다시 저장
		// 지우고 나서 list로 돌아감 redirect사용

		List<WeatherDTO> list = this.getWeathers();
		for (WeatherDTO w : list) {
			if (w.getNum() == weatherDTO.getNum()) {
				list.remove(w);
				break;

			}
		}

		File file = new File("C:\\Study\\weather.test.txt");
		FileWriter fw = new FileWriter(file, false);

		for (WeatherDTO w : list) {
			StringBuffer sb = new StringBuffer();

			sb.append(w.getNum()); // 번호 추가
			sb.append("-");
			sb.append(weatherDTO.getCity());
			sb.append("-");
			sb.append(weatherDTO.getGion());
			sb.append("-");
			sb.append(weatherDTO.getStatus());
			sb.append("-");
			sb.append(weatherDTO.getHumidity());

			fw.write(sb.toString() + "\r\n");
			fw.flush();
		}

		fw.close();

	}

	public void update(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> list = this.getWeathers();
		for (int i = 0; i < list.size(); i++) {

			if (weatherDTO.getNum() == list.get(i).getNum()) {
				list.get(i).setCity(weatherDTO.getCity());
				list.set(i, weatherDTO);
			}
		}
		File file = new File("C:\\Study\\weather.test.txt");
		FileWriter fw = new FileWriter(file, false);

		for (WeatherDTO w : list) {
			StringBuffer sb = new StringBuffer();

			sb.append(w.getNum()); // 번호 추가
			sb.append("-");
			sb.append(weatherDTO.getCity());
			sb.append("-");
			sb.append(weatherDTO.getGion());
			sb.append("-");
			sb.append(weatherDTO.getStatus());
			sb.append("-");
			sb.append(weatherDTO.getHumidity());

			fw.write(sb.toString() + "\r\n");
			fw.flush();
		}

		fw.close();
	}

}
