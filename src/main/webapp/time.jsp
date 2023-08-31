<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: kks
  Date: 2023-08-30
  Time: 오후 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
Date d = new Date();
%>
<html>
<head>
    <title>Hi</title>
</head>
<body>
Carter 홈페이지 방문을 환영합니다 (동적)<br>
지금 시간은 <%=d.toString()%>


</body>
</html>
