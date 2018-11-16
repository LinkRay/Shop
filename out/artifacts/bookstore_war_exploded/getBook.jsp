<%--
  Created by IntelliJ IDEA.
  User: 李宇
  Date: 2018/11/1
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql:///bookstore";
    String user = "root";
    String password = "linkairui33";
    String sql = "select bid,name,author,price,image,description,category_id from book" +
            " where category_id = ?";
    String categoryID = request.getParameter("cid");
    Connection conn = DriverManager.getConnection(url,user,password);
    PreparedStatement pstat = conn.prepareStatement(sql);
    pstat.setString(1,categoryID);
    ResultSet rs = pstat.executeQuery();
    while (rs.next()) {
%>
<div class="col-sm-9 col-md-3"><div class="thumbnail" ><img src="images/book.jpg"><div class="caption">  <h4>
    <%=rs.getString("name")%>
</h4><p><%=rs.getString("description")%>
</p><p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="#" class="btn btn-default" role="button">查看详情
</a></p></div></div> </div>
<%
    }
    pstat.close();
    conn.close();
%>

</body>
</html>
