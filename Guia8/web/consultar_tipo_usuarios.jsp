<%-- 
    Document   : consultar_tipo_usuarios
    Created on : Mar 23, 2020, 12:27:18 AM
    Author     : Rick
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="sv.edu.udb.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion con = new Conexion();
    String sql = "SELECT * FROM tipo_usuarios;";
    con.setRs(sql);

    ResultSet rs = con.getResultSet();
%>

<select class="form-control" id="tipoUsuario" name="tipoUsuario" required>
    <%
        while (rs.next()) {
            int id_tipo = rs.getInt("id_tipo_usuario");
            String tipo = rs.getString("tipo_usuario");

    %>
    <option value="<%=id_tipo%>"><%=tipo%></option>

    <%
        } // cerrando-while
        rs.close();
        con.cerrarConexion();
    %>
</select>

