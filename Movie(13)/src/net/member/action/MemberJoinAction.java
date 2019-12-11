package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberdata = new MemberBean();
		
		boolean result = false;
		
		memberdata.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		memberdata.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		memberdata.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
		memberdata.setMEMBER_BIRTH(request.getParameter("MEMBER_BIRTH"));
		memberdata.setMEMBER_GENDER(request.getParameter("MEMBER_GENDER"));
		memberdata.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
		memberdata.setMEMBER_ADDR(request.getParameter("MEMBER_ADDR"));
		memberdata.setMEMBER_GENRE(request.getParameter("MEMBER_GENRE"));
		
		result = memberdao.joinMember(memberdata);
		
		if (result == false) {
			System.out.println("회원가입 실패");
			return null;
		}
		System.out.println("회원가입 성공");
		
		forward.setRedirect(true);
		forward.setPath("./MemberLogin.me");
		
		return forward;
	}

}
