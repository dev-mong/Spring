package com.aia.rl.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;

@Service
public class ReqeustDeleteService {

	RequestDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int reqeustDelete(int idx, HttpServletRequest request) {
		
		dao=template.getMapper(RequestDao.class);
		
		int result = 0;
		
		RequestReg reg = dao.selectIdx(idx);
		
		
		if(reg.getReqImg() !=null && !reg.getReqImg().isEmpty() && reg.getReqImg().length() > 0 && !reg.getReqImg().equals("defalult.png")) {
			
			String uri = "/upload";
			
			String realPath = request.getSession().getServletContext().getRealPath(uri);
			
			String deletePath = realPath+"/"+reg.getReqImg();
			
			
			File deleteImg = new File(deletePath);
			
			//사진이 있으면 사진 삭제
			if(deleteImg.exists()) {
				deleteImg.delete(); 
				System.out.println("파일 삭제 완료");
			}
		}
		
		result = dao.deleteRequest(idx);
		
		
		return result;
	}

}
