package kr.board.controller;

import kr.board.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //http://127.0.0.1:8081/web/memberDelete.do?num= get 방식
        int num= Integer.parseInt(req.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberDelete(num);
        if(cnt >0){
            resp.sendRedirect("/web/memberList.do");
        }else {
            throw new ServletException("not insert");
        }
    }
}
