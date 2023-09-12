package kr.board.controller;

import kr.board.model.MemberDAO;
import kr.board.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
       //1. 파라메타 수집(VO)
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //2. 파라메타수집(VO)
        MemberVO vo = new MemberVO(id,pass,name,age,email,phone);

//        System.out.println(vo);
        //Model과 연동부분
        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberInsert(vo);
        PrintWriter out = resp.getWriter();
        if(cnt >0){
            //가입성공
            out.println("insert success");
        }else{
            //가입실패 -> 예외객체를 만들어서 WAS에게 던짐.
            throw new ServletException("not insert");
        }
    }
}
