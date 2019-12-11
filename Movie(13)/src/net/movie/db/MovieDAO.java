package net.movie.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MovieDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public MovieDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/MariaDB");
		}catch(Exception e) {
			System.out.println("DB 연결 실패 : "+e);
			return;
		}
	}

	//MovieAddAction
	public boolean movieInsert(MovieBean moviebean) {
		int num = 0;
		String sql = "";
		
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(movie_num) from movie");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			
			
			sql = "insert into movie(MOVIE_NUM, MOVIE_POSTER, MOVIE_SUBJECT, MOVIE_START, MOVIE_END) values (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, moviebean.getMOVIE_POSTER());
			pstmt.setString(3, moviebean.getMOVIE_SUBJECT());
			pstmt.setString(4, moviebean.getMOVIE_START());
			pstmt.setString(5, moviebean.getMOVIE_END());
			
			result = pstmt.executeUpdate();
			
			if(result==0) return false;
			return true;
		}catch(Exception e) {
			System.out.println("movieInsert 등록 실패 : "+e);
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		return false;
	}

	// MovieListAction.mo
	public List getMovieList() {
		String movie_sql = "select * from movie";
		
		List list = new ArrayList();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(movie_sql);
			rs = pstmt.executeQuery();
			
			String MOVIE_START = rs.getString("MOVIE_START").replaceAll("-", "");
			String MOVIE_END = rs.getString("MOVIE_END").replaceAll("-", "");;
			
			while (rs.next()) {
				MovieBean moviebean = new MovieBean();
				
				moviebean.setMOVIE_NUM(rs.getInt("MOVIE_NUM"));
				moviebean.setMOVIE_POSTER(rs.getString("MOVIE_POSTER"));
				moviebean.setMOVIE_SUBJECT(rs.getString("MOVIE_SUBJECT"));
				moviebean.STARTDATE(rs.getString(MOVIE_START));
				moviebean.ENDDATE(rs.getString(MOVIE_END));
				
				list.add(moviebean);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getMovieList() 에러 : "+e);
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		return null;
	}

	public MovieBean getCheckDetail(int num) {
		MovieBean moviebean = null;

		try {
			con = ds.getConnection();

			pstmt = con.prepareStatement("select * from movie where movie_num = ?");
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			
			String MOVIE_START = rs.getString("MOVIE_START").replaceAll("-", "");
			String MOVIE_END = rs.getString("MOVIE_END").replaceAll("-", "");;
			

			if (rs.next()) {
				moviebean = new MovieBean();
				moviebean.setMOVIE_NUM(rs.getInt("MOVIE_NUM"));
				moviebean.setMOVIE_POSTER(rs.getString("MOVIE_POSTER"));
				moviebean.setMOVIE_SUBJECT(rs.getString("MOVIE_SUBJECT"));
				moviebean.STARTDATE(rs.getString(MOVIE_START));
				moviebean.ENDDATE(rs.getString(MOVIE_END));
			}
			return moviebean;
		} catch (Exception e) {
			System.out.println("getDetail() 에러 : no.4 :" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
