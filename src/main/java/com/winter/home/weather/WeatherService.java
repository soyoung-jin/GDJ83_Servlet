package com.winter.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
		// 리스트를 가져오려 하는 메서드
	}

	// detail을 가져오려는 메서드
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		// num을 가져오기 위헤 weatherDTO 매개변수로 받아옴
		// weatherDTO를 dao로 보내줘야함

		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
			// null을 받은 이유는 찾았냐 못찾은지를 구별하기 위해서. 그럼 왜 여기에 null을 넣을까?
			// 최종적으로 controller까지 보내야 하니까 return으로 weatherDTO를 해주기 위함임
			// exception발생 시, 못찾으면 null을 처리하기 위함임
		}
		return weatherDTO;
	}

	// add하는 메서드
	public void getAdd(WeatherDTO weatherDTO) throws Exception { // 입력 받은걸 저장하려면 파일에 저장해주는 DTO에 보내줘야 힘
		weatherDAO = new WeatherDAO();
		weatherDAO.add(weatherDTO);

	}

	// 지우려는 메서드
	public void getdelete(WeatherDTO weatherDTO) throws Exception {

	}
}