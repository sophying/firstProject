package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
   // 데이터베이스 연결부분 작성
      DataSource ds;
      Connection con;
      PreparedStatement pstmt;
      ResultSet rs;

      // 1.
      public BoardDAO() {
         try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:comp/env/jdbc/MariaDB");
         } catch (Exception e) {
            System.out.println("DB 연결 실패 : no.1 : " + e);
            return;
         }
      }

      public int getListCount(String cond) {
         int x = 0;

         String sql = "select count(*) from board_Movie";
         if (cond != null && !cond.equals("")) {
            sql = sql + " where " + cond;
         }
         try {
            con = ds.getConnection();
            System.out.println("getConnection()");

            // pstmt = con.prepareStatement("select count(*) from board_2");

            // for debug
            System.out.println("getListCount() : " + sql);

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
               x = rs.getInt(1);
            }
         } catch (Exception e) {
            System.out.println("getListCount() 에러 : no.2 :  " + e);
            System.out.println("getListCount() 에러 : " + sql);
         } finally {
            try {
               if (rs != null)
                  rs.close();
               if (pstmt != null)
                  pstmt.close();
               if (con != null)
                  con.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         return x;
      }

      public List<BoardBean> getBoardList(int page, int limit, String cond) {
         String board_list_sql =  "select @rownum:=@rownum+1 as rnum, board.* " + 
 				" from (select @rownum:=0) tmp ,(select * from board_Movie) board " + 
 				" order by board_re_ref desc, board_re_seq asc " + 
 				" limit ?";

         String board_list_sql_fmt = "select @rownum:=@rownum+1 as rnum, board.* " + 
 				" from (select @rownum:=0) tmp ,(select * from board_Movie where %s ) board " + 
 				" order by board_re_ref desc, board_re_seq asc " + 
 				" limit ? ";

         if (cond != null && !cond.equals("")) {
            board_list_sql = String.format(board_list_sql_fmt, cond);
         }
         List<BoardBean> list = new ArrayList<BoardBean>();

         int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호
         int endrow = startrow + limit - 1; // 읽을 마지막 row 번호
         try {
            con = ds.getConnection();

            // for debug
            System.out.println("getBoardList() : " + board_list_sql);
            pstmt = con.prepareStatement(board_list_sql);
            pstmt.setInt(1, startrow);
            pstmt.setInt(2, endrow);
            rs = pstmt.executeQuery();

            while (rs.next()) {
               BoardBean board = new BoardBean();
               board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
               board.setBOARD_ID(rs.getString("BOARD_ID"));
               board.setBOARD_CATEGORY(rs.getString("BOARD_CATEGORY"));
               board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
               board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
               board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
               board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
               board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
               board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
               board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
               list.add(board);
            }
            return list;
         } catch (Exception e) {
            System.out.println("getBoardList() 에러 : no.3 : " + e);
            System.out.println("getBoardList() 에러 : " + board_list_sql);
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

      public boolean boardInsert(BoardBean boardbean) {
         int num = 0;
         String sql = "";
         int result = 0;

         try {
            con = ds.getConnection();

            pstmt = con.prepareStatement("select max(board_num) from board_Movie");
            rs = pstmt.executeQuery();

            if (rs.next()) {
               num = rs.getInt(1) + 1;
            } else {
               num = 1;
            }
            sql = "insert into board_Movie (board_num, board_id, board_category, board_subject, "
                  + "board_content, board_re_ref, board_re_lev, "
                  + "board_re_seq, board_readcount, board_date)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);
            pstmt.setString(2, boardbean.getBOARD_ID());
            pstmt.setString(3, boardbean.getBOARD_CATEGORY());
            pstmt.setString(4, boardbean.getBOARD_SUBJECT());
            pstmt.setString(5, boardbean.getBOARD_CONTENT());
            pstmt.setInt(6, num); 
            //현재 레코드가 0이었다면 1
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            pstmt.setInt(9, 0);

            result = pstmt.executeUpdate();
            if (result == 0)
               return false;

            return true;
         } catch (Exception e) {
            System.out.println("boardInsert() 에러 : no.5 : " + e);
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
         return false;
      }

  	public void setReadCountUpdate(int num) throws Exception {
		String sql = "update board_Movie set BOARD_READCOUNT=BOARD_READCOUNT+1 where BOARD_NUM="+num;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("setReadCountUpdate 글 읽은 갯수 수정 실패 : "+e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) pstmt.close();
			}catch(Exception ex) {}
		}
	}
  	
	public BoardBean getDetail(int num) throws Exception{
		BoardBean board = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from board_Movie where BOARD_NUM = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
	               board = new BoardBean();
	               board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
	               board.setBOARD_ID(rs.getString("BOARD_ID"));
	               board.setBOARD_CATEGORY(rs.getString("BOARD_CATEGORY"));
	               board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
	               board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
	               board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
	               board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
	               board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
	               board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
	               board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
			return board;
		}catch(Exception ex) {
			System.out.println("getDetail 내용보기 실패 : "+ex);
		}finally {
			if(rs != null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
			if(con != null) try {con.close();}catch(SQLException ex) {}
		}
		return null;
	}

	public boolean isBoardWriter(int num, String id) {
		System.out.println("id="+id);
		String board_sql="select * from board_Movie where BOARD_NUM=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			rs.next();
			
			if(id.equals(rs.getString("BOARD_ID"))) {
				return true;
			}
		}catch(SQLException ex) {
			System.out.println("isBoardWriter 실패 : "+ex);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception ex) {}
		}
		return false;
	}

	public boolean boardModify(BoardBean modifyboard) {
		String sql = "update board_Movie set BOARD_CATEGORY=?, BOARD_SUBJECT=?, BOARD_CONTENT=? where BOARD_NUM=?";
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getBOARD_CATEGORY());
			pstmt.setString(2, modifyboard.getBOARD_SUBJECT());
			pstmt.setString(3, modifyboard.getBOARD_CONTENT());
			pstmt.setInt(4, modifyboard.getBOARD_NUM());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex) {
			System.out.println("boardModify 수정 실패 : "+ex);
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
		}
		return false;
	}

	public int boardReply(BoardBean boardbean) {
	      String board_max_sql = "select max(board_num) from board_Movie";
	      String sql = "";
	      int num = 0;
	      int result = 0;
	      
	      int re_ref = boardbean.getBOARD_RE_REF();
	      int re_lev = boardbean.getBOARD_RE_LEV();
	      int re_seq = boardbean.getBOARD_RE_SEQ();
	      
	      try {
	         con = ds.getConnection();
	         
	         pstmt = con.prepareStatement(board_max_sql);
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            num = rs.getInt(1) + 1;
	         } else {
	            num = 1;
	         }
	         
	         sql = "update board_Movie set board_re_seq = board_re_seq + 1 where board_re_ref = ? and board_re_seq > ?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, re_ref);
	         pstmt.setInt(2, re_seq);
	         result = pstmt.executeUpdate();
	         
	         re_seq = re_seq + 1;
	         re_lev = re_lev + 1;
	         
	         sql = "insert into board_Movie (board_num, board_id, board_category, board_subject, "
	               + "board_content, board_re_ref, board_re_lev, "
	               + "board_re_seq, board_readcount, board_date) "
	               + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, num);
	         pstmt.setString(2, boardbean.getBOARD_ID());
	         pstmt.setString(3, boardbean.getBOARD_CATEGORY());
	         pstmt.setString(4, boardbean.getBOARD_SUBJECT());
	         pstmt.setString(5, boardbean.getBOARD_CONTENT());
	         pstmt.setInt(6, re_ref);
	         pstmt.setInt(7, re_lev);
	         pstmt.setInt(8, re_seq);
	         pstmt.setInt(9, 0);
	         
	         pstmt.executeUpdate();
	         
	         return num;
	      } catch (Exception e) {
	         System.out.println("boardReply() 에러 : " + e);
	      } finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstmt != null)
	               con.close();
	            if (con != null)
	               con.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return 0;
	   }

	public boolean boardDelete(int num) {
		String board_delete_sql = "delete from board_Movie where BOARD_NUM=?";
		
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			if(result == 0) return false;
			
			return true;
		}catch(Exception ex) {
			System.out.println("boardDelete 삭제 실패 : "+ex);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception ex) {}
		}
		return false;
	}
}