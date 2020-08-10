package com.aia.opmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.aia.opmvc.jdbc.ConnectionProvider;
import com.aia.opmvc.member.dao.MemberDao;
import com.aia.opmvc.member.dao.MemberMybatisDao;
import com.aia.opmvc.member.model.LoginInfo;
import com.aia.opmvc.member.model.LoginRequest;
import com.aia.opmvc.util.CookieBox;

@Service
public class MemberLoginService {

//	@Autowired
//	MemberDao dao;

	MemberMybatisDao dao;

	@Autowired
	SqlSessionTemplate tempalte;

	public String login(LoginRequest loginRequest, HttpSession session, HttpServletResponse response, String header) {

		
		dao=tempalte.getMapper(MemberMybatisDao.class);
		
		LoginInfo login = null;
		String message = "";


		// 입력한 정보 디비 확인
		login = dao.selectByIdPw(loginRequest);

		if (login != null) {

			System.out.println(login);
			// session 객체 저장
			session.setAttribute("loginInfo", login);
		}

		return message;

	}

}
