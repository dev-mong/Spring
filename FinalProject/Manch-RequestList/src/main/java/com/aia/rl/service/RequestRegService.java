package com.aia.rl.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.ReqeustRegReq;
import com.aia.rl.model.RequestReg;


//등록 서비스
@Service
public class RequestRegService {

	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int requestReg(ReqeustRegReq requestRegReq, HttpServletRequest request) {

		dao=template.getMapper(RequestDao.class);
		
		
		RequestReg requestReg = requestRegReq.toRequestReg();
		
		System.out.println(requestReg);
		
		
		int result =0;
		try {
			
			
			MultipartFile file = requestRegReq.getReqImg();			
			
			// 사진이 있다면 사진 파일을 물리적으로 저장하고, 없다면 기본 이미지 파일의 경로를 저장한다.
			if(file != null && !file.isEmpty() && file.getSize() > 0) {
				
				// 서버 내부의 경로
				//String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");
				String uri = "/upload";
				
				
				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장 완료 : " + newFileName);
				 
				// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경로
				requestReg.setReqImg(newFileName);

			} else {
				requestReg.setReqImg("defalult.png");
			}
			
		//	System.out.println(requestReg);
			result = dao.insertRequest(requestReg);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return result;
		
	}
	
	
	
	
}
