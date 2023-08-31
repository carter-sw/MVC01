<%@ page import="kr.board.util.MyUtil" %><%--
  Created by IntelliJ IDEA.
  User: kks
  Date: 2023-08-30
  Time: 오후 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MyUtil my = new MyUtil();
   int sum = my.hap();
%>
<html>
<head>
    <title>Hi sum</title>
</head>
<body>
<table border="1">
    <tr>
        <td>
            1~100까지의 총합
        </td>
        <td><%=sum%></td>
    </tr>
</table>

</body>
</html>
