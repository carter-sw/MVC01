<%--
  Created by IntelliJ IDEA.
  User: kks
  Date: 2023-08-28
  Time: 오후 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int sum=0;
    for(int i=0; i<=10; i++){
        sum+=i;
    }
%>
<%=sum%>

</body>
</html>
