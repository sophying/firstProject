package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/MariaDB");

		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
			return;
		}

	}

	// MemberJoinAction.me
	public boolean joinMember(MemberBean member) {
		String sql = "INSERT INTO MEMBER_INFO VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMEMBER_ID());
			pstmt.setString(2, member.getMEMBER_PW());
			pstmt.setString(3, member.getMEMBER_NAME());
			pstmt.setString(4, member.getMEMBER_BIRTH());
			pstmt.setString(5, member.getMEMBER_GENDER());
			pstmt.setString(6, member.getMEMBER_EMAIL());
			pstmt.setString(7, member.getMEMBER_ADDR());
			pstmt.setString(8, member.getMEMBER_GENRE());

			result = pstmt.executeUpdate();

			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("joinMember 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// MemberLoginAction.me
	public int isMember(MemberBean memberdata) {
		String sql = "SELECT MEMBER_PW FROM MEMBER_INFO WHERE MEMBER_ID=?";
		// 아이디는 유일하기 때문에 rs.next를 if문으로 처리
		// 여러 개였다면 while문으로 처리
		int result = -1;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberdata.getMEMBER_ID());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("MEMBER_PW").equals(memberdata.getMEMBER_PW())) {
					result = 1; // 일치
				} else {
					result = 0; // 불일치
				}
			} else {
				result = -1; // 아이디 존재하지 않음
			}
		} catch (Exception ex) {
			System.out.println("isMember 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return result;
	}
}
