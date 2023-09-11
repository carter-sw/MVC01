package kr.board.controller;

import kr.board.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //1. 파라메타 수집(VO)
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //2. 파라메타수집(VO)
        MemberVO vo = new MemberVO(id,pass,name,age,email,phone);

        System.out.println(vo);
    }
}
