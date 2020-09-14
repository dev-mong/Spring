package com.aia.rl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;

@Service
public class RequestListMapService {
	
	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;


	public List<RequestReg> requestMap(String mLat, String mLon, int mRadius) {
		
		
		dao=template.getMapper(RequestDao.class);
		
		// 출력 할 리스트
		List<RequestReg> result = null;
		
		// 회원 위도 경도 정보
		Map<String, Object> map = new HashMap<String, Object>();
		if (mLat != null && !mLat.isEmpty()) {
			map.put("mLat", mLat);
		}
		if (mLon != null && !mLon.isEmpty()) {
			map.put("mLon", mLon);
		}
		map.put("mRadius", mRadius);
		
		result = dao.selectAllMap(map);
		
		for(int i=0;i<result.size();i++) {
			double distance = result.get(i).getDistance();
			double roundDis = Math.round(distance*100);
			int calDistance = (int)(roundDis) * 10;
			result.get(i).setCalDistance(calDistance);
		}
		
		return result;
	}
	
	

}
