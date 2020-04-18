<%@page language="java" import="java.sql.*" %>
<%
    Connection conexion = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    //Leemos el driver de Mysql
    Class.forName("com.mysql.jdbc.Driver");
    // Se obtiene una conexión con la base de datos.
    conexion = DriverManager.getConnection("jdbc:mysql://localhost/guia8", "root", "This#is#4#MySQL");
%>
