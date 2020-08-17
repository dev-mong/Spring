package com.aia.rl.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestEdit;
import com.aia.rl.model.RequestReg;

@Service
public class ReqeustEditService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public int requestEdit(RequestEdit edit, HttpServletRequest request) {
		
		
		dao = template.getMapper(RequestDao.class);

		int result = 0;

		RequestReg reg = edit.toRequestReg();
		
		System.out.println(reg);

		MultipartFile file = edit.getReqImg();
		
		try {
			if (file != null && !file.isEmpty() && file.getSize() > 0) {

				// String uri =
				// request.getSession().getServletContext().getInitParameter("memberUploadPath");
				String uri = "/upload";
				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				
				System.out.println(realPath);
				
				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장 완료 : " + newFileName);

				reg.setReqImg(newFileName);

				// 이전 페이지를 지운다.
				// 이전 파일의 File 객체
				File oldFile = new File(realPath, edit.getOldImg());

				// 파일이 존재하면
				if (oldFile.exists()) {
					// 파일을 삭제
					oldFile.delete();
				}
			
			}
			result = dao.editRequest(reg);
			
			System.out.println(result);
			
		}catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		return result;
	}

}
