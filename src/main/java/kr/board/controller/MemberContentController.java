package kr.board.controller;

import kr.board.model.MemberDAO;
import kr.board.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //http://127.0.0.1:8081/web/memberContent.do?num= get 방식
        int num=Integer.parseInt(req.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        if(vo != null){
            out.println("<tr>");
            out.println("<td colspan='2'>"+vo.getName()+"회원의 상세보기 </td>");
            out.println("<td>"+vo.getNum()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>번호<td>");
            out.println("<td>"+vo.getNum()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>아이디</td>");
            out.println("<td>"+vo.getId()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>비밀번호</td>");
            out.println("<td>"+vo.getPass()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이름</td>");
            out.println("<td>"+vo.getName()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>나이</td>");
            out.println("<td><input type='text' name='age' value='"+vo.getAge()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이메일</td>");
            out.println("<td><input type='text' name='email' value='"+vo.getEmail()+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>전화번호</td>");
            out.println("<td><input type='text' name='phone' value='"+vo.getPhone()+"</td>");
            out.println("</tr>");
        }else {
            out.println("<tr>");
            out.println("<td>일치하는 회원이 없습니다.</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
