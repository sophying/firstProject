package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =new ActionForward();
		
		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberdata = new MemberBean();
		
		int result = -1;
		
		memberdata.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		memberdata.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		
		result = memberdao.isMember(memberdata);
		System.out.println("result : " +result);
		if(result == 0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}else if(result == -1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>"); 
			out.close();
			return null;
		}
		
		//로그인 성공
		//아이디 비밀번호 일치하며 세션 설정
		session.setAttribute("id", memberdata.getMEMBER_ID());
		System.out.println("로그인 성공");
		forward.setRedirect(true);
		forward.setPath("./MovieMain1.mo");
		return forward;
	}

}
