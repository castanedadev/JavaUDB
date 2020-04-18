<%-- 
    Document   : ingresar_usuario
    Created on : Mar 23, 2020, 12:13:54 AM
    Author     : Rick
--%>

<%@page import="sv.edu.udb.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Conexion con = new Conexion();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String tipoUsuario = request.getParameter("tipoUsuario");
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            //Sentencia sql para ingresar datos
            String sql = "INSERT INTO `guia8`.`usuarios` (`id_usuario`,`nombres`,"
                    + "`apellidos`, `edad`, `id_tipo_usuario`, `usuario`, "
                    + "`password`) VALUES (null, '" + nombre + "', '"
                    + apellido + "'," + edad + ", " + tipoUsuario + ", '"
                    + usuario + "', SHA2('" + password + "',256));";
            System.out.println(sql);
            con.setQuery(sql);

            con.cerrarConexion();
        %>
        <%--Forward que se utiliza para redireccionar a la pagina de opc1.jsp--%>
        <jsp:forward page="opc1.jsp">
            <jsp:param name="resultado" value="Usuario Ingresado Exitosamente"/>
        </jsp:forward>
    </body>
</html>