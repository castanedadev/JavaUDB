<%-- 
    Document   : eliminar_usuario
    Created on : Mar 23, 2020, 1:12:44 AM
    Author     : Rick
--%>

<%@include file="conexion.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            st = conexion.prepareStatement("DELETE FROM usuarios WHERE id_usuario=" + id);
            st.executeUpdate();
            conexion.close();
        %>
        <%--Forward que se utiliza para redireccionar a la pagina de ingresaremp.jsp--%>
        <jsp:forward page="opc1.jsp">
            <jsp:param name="resultado" value="Datos Eliminados Exitosamente"/>
        </jsp:forward>
    </body>
</html>

