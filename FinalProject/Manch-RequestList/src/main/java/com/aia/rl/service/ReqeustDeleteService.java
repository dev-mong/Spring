package com.aia.rl.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class ReqeustDeleteService {

	private RequestDao reqdao;
	
	private ReviewDao reviewDao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int reqeustDelete(int idx, HttpServletRequest request) {
		
		reqdao=template.getMapper(RequestDao.class);
		reviewDao=template.getMapper(ReviewDao.class);
		
		int result = 0;
		
		RequestReg reg = reqdao.selectIdx(idx);
		
		
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
		
		
		//리뷰 작성 여부 확인
		Review review = reviewDao.selectReqIdx(idx);
		if(review !=null) {
			result = 0;
		} else {
			result = reqdao.deleteRequest(idx); //삭제 됨 
		}
		
		
		
		return result;
	}

}
