package kr.board.controller;

import kr.board.util.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "HelloServlet" , value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 클라이언트의 요청을 받는 작업(파라메타 수집) -> Controller(Servlet)
        // 2. 처리하는 작업(비즈니스 로직) -> Model (java class)
        MyUtil my = new MyUtil();
        int sum = my.hap();

        // 3. 요청한 클라이언트에게 응답하는 작업 (프리젠테이션 로직) -> view (jsp)
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(sum);
        out.println("</body>");
        out.println("</html>");

        //Servlet 과 Model로 회원관리 만들기
    }
}
