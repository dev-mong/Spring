package com.aia.opmvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.aia.opmvc.member.model.LoginInfo;
import com.aia.opmvc.member.model.Member;

@Repository
public class MemberDao {

	// Id check 검색
	public int selectById(Connection conn, String id) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(*) FROM project.member WHERE UID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultCnt = rs.getInt(1); // count(*), 첫번째 컬럼 값을 의미
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt == null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member " + "(uid,upw,uname,uphoto) VALUES (?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUploadPhoto());

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public LoginInfo selectByIdPw(Connection conn, String uid, String upw) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginInfo login= null;

		try {
			String sql = "select * from project.member where uid=? and upw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				login=new LoginInfo();
				login.setUid(rs.getString("uid"));
				login.setUpw(rs.getString("upw"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}


		return login;

	}

}
