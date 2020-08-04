package com.aia.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class JdbcTemplateMemberDao {

	@Inject
	JdbcTemplate jdbcTempale;
	

	public int selectTotalCount() throws SQLException {
		
//		int resultCnt=0;
//		String sql = "select count(*) from project.member";
//		resultCnt=jdbcTempale.queryForObject(sql,Integer.class);
//		return resultCnt;
		
		return jdbcTempale.queryForObject("select count(*) from project.member", Integer.class);
	
	}
	
	
	

	public List<Member> selectList( int startRow, int count) throws SQLException {
		
//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname limit ?, ?";
//		memberList = jdbcTempale.query(sql, new Object[] {startRow,count}, new MemberRowMapper());
//		return memberList;
		return jdbcTempale.query("select * from project.member order by uname limit ?, ?", new Object[] {startRow,count}, new MemberRowMapper());
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
