package com.aia.rl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.LocationDistance;
import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.model.RequestRegView;

@Service
public class RequestListService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public RequestRegView requestList(String mLat, String mLon, int mRadius, String type, int page) {
	//public List<RequestReg> requestList(String mLat, String mLon, int mRadius, String type, int page) {

		dao = template.getMapper(RequestDao.class);

		List<RequestReg> requestAll = dao.selectAllList(); // 전체 리스트

		Map<String, Object> map = new HashMap<String, Object>();
		if (type != null && !type.isEmpty()) {
			map.put("type", type);
		}

		final int REQUEST_COUNT_PAGE = 4; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.boardTotalCount(map); // 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = 0;

		List<RequestReg> result = new ArrayList<RequestReg>();
		List<RequestReg> resultPage = new ArrayList<RequestReg>();
		RequestRegView resultView = null;

		List<RequestReg> login = new ArrayList<RequestReg>(); // 계산된 요청글을 담을 리스트
		List<RequestReg> nonLogin = new ArrayList<RequestReg>(); // 비회원을 담을 리스트

		RequestReg request = null; // 요청글 한개

		for (int i = 0; i < requestAll.size(); i++) {

			request = new RequestReg(requestAll.get(i).getReqIdx(), requestAll.get(i).getReqWriter(),
					requestAll.get(i).getReqTitle(), requestAll.get(i).getReqHelper(),
					requestAll.get(i).getReqDateTime(), requestAll.get(i).getReqAddr(),
					requestAll.get(i).getReqContents(), requestAll.get(i).getReqLatitude(),
					requestAll.get(i).getReqLongitude(), requestAll.get(i).getReqCount(),
					requestAll.get(i).getReqStatus(), requestAll.get(i).getReqImg());

			double reqLot = Double.parseDouble(requestAll.get(i).getReqLatitude());
			double reqLon = Double.parseDouble(requestAll.get(i).getReqLongitude());

			double userLat = Double.parseDouble(mLat);
			double userLon = Double.parseDouble(mLon);

			LocationDistance locDistance = new LocationDistance();

			// 두 거리 계산 결과 meter로 출력
			int distance = locDistance.distance(userLat, userLon, reqLot, reqLon);

			// 사용자가 요청한 거리 만큼
			int userDist = 2000;

			if (distance <= userDist) {
				request.setDistance(distance); // 한개의 요청글에 거리를 담는다
				login.add(request);
				result = login;
			} else { // 비회원일 때
				nonLogin.add(request);
				result = nonLogin;
			}
		}

		// 거리 리스트 내림차순으로 정렬 - 가까운 순으로 출력
		Collections.sort(result, new Comparator<RequestReg>() {

			@Override
			public int compare(RequestReg r1, RequestReg r2) {

				if (r1.getDistance() < r2.getDistance()) {
					return -1;
				} else if (r1.getDistance() > r2.getDistance()) {
					return 1;
				}
				return 0;
			}
		});

		if (listTotalCnt > 0) {
			startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE;
			int endRow = startRow + (REQUEST_COUNT_PAGE-1);

			for (int i = startRow; i <= endRow; i++) {
				resultPage.add(result.get(i));
			}
			
			listTotalCnt = resultPage.size();
			

		} else {
			currentPageNum = 0;
		}

		resultView=new RequestRegView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, resultPage, startRow);
		System.out.println(resultView);

		return resultView;

	}

}
