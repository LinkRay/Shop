<%--
  Created by IntelliJ IDEA.
  User: LIN
  Date: 2018/10/21
  Time: 上午8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel = "stylesheet" type = "text/css" href="table.css">
    <title>Title</title>
    <style>
        #firstrow{
            height: 50px;
        }
    </style>
</head>
<body>
    <%
        Connection conn;
        Statement stat;
        Statement stat2;
        String url = "jdbc:mysql://localhost:3306/school?"
                + "user=root&password=linkairui33&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            stat = conn.createStatement();
            stat2 = conn.createStatement();


            String sql;
            /*
            ResultSet rs = stat.executeQuery(sql);
            out.print("省:");
            out.println("<select name = province>");
            while(rs.next()) {
                String province = rs.getString("provinceName");
                out.println("<option value=\""+province+"\">"+province+"</option>");
            }
            out.print("<from>");
            out.println("</select>");
            out.print("市:");
            sql = "Select * from tcity";
            rs = stat.executeQuery(sql);
            out.println("<select name = city>");
            while(rs.next()) {
                String city = rs.getString("cityName");
                out.println("<option value=\""+city+"\">"+city+"</option>");
            }
            out.println("</select>");
            out.print("</form>");
            out.print("<br>");
            */
            sql = "SELECT * from tprovince";
            ResultSet rs = stat.executeQuery(sql);
            int cnt = 0;
        out.println("<table border = 1 name=\""+cnt+"\">");
            while(rs.next()) {
                cnt++;
                String provinceid = rs.getString("provinceId");
                String provinceName = rs.getString("provinceName");
                String sql2 = "select * from tcity where provinceId="+provinceid;
                ResultSet rs2 = stat2.executeQuery(sql2);
                out.println("<tr>");
                out.println("<th colspan = \"2\" id = \"firstrow\">"+provinceName+"</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>邮政编码</th>");
                out.println("<th>城市名称</th>");
                out.println("</tr>");
                while(rs2.next()) {
                    String cityName = rs2.getString("cityName");
                    String cityCode = rs2.getString("cityCode");
                    out.println("<tr>");
                    out.println("<th>"+cityCode+"</th>");
                    out.println("<th>"+cityName+"</th>");
                    out.println("</tr>");
                  //  out.print(provinceName+" "+city);
                  //  out.print("<br>");
                }

            }
        out.println("</table>");
            stat2.close();
            stat.close();
            conn.close();


    %>
</body>
</html>
