<%--
  Created by IntelliJ IDEA.
  User: LIN
  Date: 2018/11/7
  Time: 上午8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中文会乱码</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    out.println("id:"+id+"<br>");
    out.print("pwd:"+pwd);
%>
</body>
</html>
