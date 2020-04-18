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
            String id = request.getParameter("id_usuario");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String tipoUsuario = request.getParameter("tipoUsuario");
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            //Sentencia sql para ingresar datos
            String sql = "UPDATE `guia8`.`usuarios` SET "
                    + "`nombres` = '" + nombre + "', `apellidos` = '"
                    + apellido + "', `edad` = " + edad + ", `id_tipo_usuario` = " 
                    + tipoUsuario + ", `usuario` ='" + usuario + "', `password` = "
                    + "SHA2('" + password + "',256) WHERE `id_usuario` = "
                    + id + ";";
            System.out.println(sql);
            con.setQuery(sql);

            con.cerrarConexion();
        %>
        <%--Forward que se utiliza para redireccionar a la pagina de opc1.jsp--%>
        <jsp:forward page="opc1.jsp">
            <jsp:param name="resultado" value="Usuario actualizado exitosamente"/>
        </jsp:forward>
    </body>
</html>