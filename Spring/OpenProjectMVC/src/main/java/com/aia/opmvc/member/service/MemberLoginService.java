package com.aia.opmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.aia.opmvc.jdbc.ConnectionProvider;
import com.aia.opmvc.member.dao.MemberDao;
import com.aia.opmvc.member.model.LoginInfo;
import com.aia.opmvc.member.model.LoginRequest;
import com.aia.opmvc.util.CookieBox;

@Service
public class MemberLoginService {


	@Autowired
	MemberDao dao;
	
	public String login(LoginRequest loginRequest, HttpSession session,HttpServletResponse response,String header) {
		
		Connection conn=null;
		LoginInfo login=null;
		String message="";
		
		try {
			conn=ConnectionProvider.getConnection();
			
			String uid=loginRequest.getUid();
			String upw=loginRequest.getUpw();
			
			//입력한 정보 디비 확인
			login=dao.selectByIdPw(conn,uid,upw);		
			
			if(login !=null) {
				
				//sessino 객체 저장
				session.setAttribute("loginInfo", login);
				
				//cookie에 저장 -> 아이디 기억
				if(loginRequest.getCheck().equals("checked")) {
					
					message="로그인 성공";
					response.addCookie(CookieBox.createCookie("uid",login.getUid(),header,60 * 60 * 24 * 365));
				}
				
			}else {
				message = "로그인 실패";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return message;
		
		
	}

}
