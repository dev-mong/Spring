package com.aia.opmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.aia.opmvc.jdbc.ConnectionProvider;
import com.aia.opmvc.member.dao.MemberDao;

public class IdCheckService {
	
	@Autowired
	MemberDao dao;
	
	public String check(String uid) {
		
		
		String result = "N";
		
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			int resultCnt = dao.selectById(conn,uid);
			
			if(resultCnt<1) {
				result = "Y";
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
		
		return result;
	}
	
}
