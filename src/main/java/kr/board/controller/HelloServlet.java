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

        // 1~100 까지의 총합=?
        MyUtil my = new MyUtil();
        int sum = my.hap();

        //요청한 클라이언트에게 응답하기?
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(sum);
        out.println("</body>");
        out.println("</html>");
    }
}
