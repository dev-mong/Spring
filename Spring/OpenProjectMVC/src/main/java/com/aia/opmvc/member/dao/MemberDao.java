package com.aia.opmvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
