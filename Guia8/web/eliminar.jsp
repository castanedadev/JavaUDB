<%-- 
    Document   : eliminar
    Created on : Mar 22, 2020, 11:57:45 PM
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
        <%//Capturando los datos por medio del request y el metodo getParameter
            String id = request.getParameter("id");
            //Sentencia sql para ingresar datos
            st = conexion.prepareStatement("DELETE FROM empleados WHERE codigo=" + id);
            st.executeUpdate();
            conexion.close();
        %>
        <%--Forward que se utiliza para redireccionar a la pagina de ingresaremp.jsp--%>
        <jsp:forward page="ingresaremp.jsp">
            <jsp:param name="resultado" value="Datos Eliminados Exitosamente"/>
        </jsp:forward>
    </body>
</html>
