<%-- 
    Document   : principal
    Created on : Mar 15, 2020, 2:20:40 PM
    Author     : Rick
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sv.edu.udb.complementarios.models.TipoEmpleado"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.edu.udb.servlet.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session_actual = request.getSession(false);
    String usuario = (String) session_actual.getAttribute("USER");
    String nombres = (String) session_actual.getAttribute("NAME");
    if (usuario == null) {
        response.sendRedirect("login.html");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Guia 7 :: Main</title>
        <link rel="stylesheet" type="text/css" href="web_style.css">
        <style>
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100%;
            }
        </style>
    </head>
    <body class="text-center">

        <div class="container">
            <div class="button-wrapper">
                <h2> Bienvenido: (<%=usuario%>) <%=nombres%> </h2>
                <br><br><br>
                <p>Que opcion de mantenimiento desea realizar?</p>
                <br><br>
                <a class="btn btn-info" href="mttoUsuarios.jsp"> Usuarios </a>
               
                <a class="btn btn-info" href="mttoCasos.jsp"> Casos </a>
            </div>
        </div>

    </body>
</html>
