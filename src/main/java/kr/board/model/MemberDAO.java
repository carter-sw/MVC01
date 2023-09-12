package kr.board.model;
import java.sql.*;
// JDBC -> myBatis, JPA
public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // 데이터베이스 연결객체 생성 (Connection)
    public void getConnect(){
        // 데이터베이스 접속 URL
        String URL="jdbc:mysql://localhost:3306/com";
        String user="com";
        String password="com01";

        //MySQL Driver Loading
        try {
            //동적로딩 (실행지점에서 객체를 생성하는 방법)
            Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(URL,user,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 회원 저장 동작
    public int memberInsert(MemberVO vo){
        //                                                        ?(파라메터) 1 2 3 4 5 6
        String SQL="insert into member (id,pass,name,age,email,phone) values(?,?,?,?,?,?)";
        getConnect();
        //SQL 문장을 전송하는 객체 생성
        int cnt = -1;
        try {
            ps=conn.prepareStatement(SQL); // 미리 컴파일을 시킨다. (속도가 빠르기)
            ps.setString(1,vo.getId());
            ps.setString(2,vo.getPass());
            ps.setString(3,vo.getName());
            ps.setInt(4,vo.getAge());
            ps.setString(5,vo.getEmail());
            ps.setString(6,vo.getPhone());

           cnt = ps.executeUpdate(); // 전송(실행) 1성공 0 실패

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt; //1 or 0
    }


}
