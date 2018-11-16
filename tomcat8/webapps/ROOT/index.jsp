<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: LIN
  Date: 2018/10/31
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <title>网上书店</title>

  </head>

  <body>
  <script src="js/jquery.min.js" ></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/commons.js"></script>
  <div class="header">

    <div class="container">
      <div class="row">
        <div class="login span4">
          <h1><a href=""> 欢迎来到<strong>我的</strong>书店</a>
            <span class="red">.</span></h1>
        </div>
        <div class="links span8">
          <a class="login" href="login.html" rel="tooltip" data-placement="bottom" data-toggle="modal" data-target="#myModal"></a>
          <a class="register" href="" rel="tooltip" data_placement="bottom"></a>
        </div>
      </div>
    </div>

    <div class="modal fade" id = "myModal">
      <div class = "modal-dialog">
        <div class = "modal-content">
          <div class = "modal-header"></div>
          <div class = "modal-body"></div>
          <div class= "modal-footer"></div>
        </div>
      </div>
    </div>
  </div> <%--header--%>
  <div class="row">
    <div class="col-md-3">
      <ul class="nav nav-list">
        <li class="nav-header">书籍类型</li>
        <%
          Class.forName("org.sqlite.JDBC");
          String url = "jdbc:sqlite:/Users/LinkRay/Desktop/bookstore.db";
          String sql = "select id, name, description from category";
          Connection conn = DriverManager.getConnection(url);
          Statement stat = conn.createStatement();
          ResultSet rs = stat.executeQuery(sql);
          while(rs.next()) {
        %>
        <li>
          <a href="<%=rs.getString("id")%>"><%=rs.getString("name")%></a>
        </li>
        <%
          }
          stat.close();
          conn.close();
        %>
      </ul>
    </div>
  </div>
  </body>
</html>
