package kr.board.controller;

import kr.board.model.MemberDAO;
import kr.board.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 1.클라이언트의 요청을 받기(memberList.do)
        // 2.회원전체 리스트 가져오기(Model 연동)
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();


        // 3.회원전체 리스트를 html로 만들어서 응답하기
        // -응답되는 데이터 안에 한글이 있는 경우 -> 인코딩
        //System.out.println(lsit);
        res.setContentType("text/html;charset=utf-8"); // 서버가 클라이언트에게 (홈페이지) 에게 MIME-TYPE
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th>");
        out.println("<th>아이디</th>");
        out.println("<th>비밀번호</th>");
        out.println(" <th>이름</th>");
        out.println("<th>나이</th>");
        out.println("<th>이메일</th>");
        out.println("<th>전화번호</th>");
        out.println("<th>삭제</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for(MemberVO vo : list) {
            out.println("<tr>");
            out.println("<td>"+vo.getNum()+"</td>");
            out.println("<td><a href='/web/memberContent.do?num="+vo.getId()+"'>"+vo.getId()+"</a></td>");
            out.println("<td>"+vo.getPass()+"</td>");
            out.println("<td>"+vo.getName()+"</td>");
            out.println("<td>"+vo.getAge()+"</td>");
            out.println("<td>"+vo.getEmail()+"</td>");
            out.println("<td>"+vo.getPhone()+"</td>");
            out.println("<th><a href='/web/memberDelete.do?num="+vo.getNum()+"'>삭제</th>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tr>");
        out.println("<td colspan='7'>");
        out.println("<a href='member/memberRegister.html'>회원가입</a>");
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");
    }
}
