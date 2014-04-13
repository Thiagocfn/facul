
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.jdbc.Driver" %>
<%
    
    Class.forName("com.mysql.jdbc.Driver");
    //Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.divulgando.com.br/divulgando09", "divulgando09", "dsw1401");
    Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.4.4/facul", "root", "webradius");
    String db_prefix = "666_";
%>
