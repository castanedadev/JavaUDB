<%-- 
    Document   : mttoUsuarios
    Created on : Mar 15, 2020, 5:11:52 PM
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session_actual = request.getSession(false);
    String usuario = (String) session_actual.getAttribute("USER");
    if (usuario == null) {
        response.sendRedirect("login.html");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Guia 7 :: Usuarios</title>
        <link rel="stylesheet" type="text/css" href="web_style.css">        
    </head>
    <body class="text-center">
        <form class="text-center" action="servlet_ingresar_jefe_sistemas" method="POST" >
            <h1>Mantenimiento Usuarios</h1>
            <br>
            <div class="form-group">
                <label for="nombres">Ingrese sus nombres:</label> 
                <input id="nombres" type="text" name="nombres" value="" size="45" class="form-control" />
            </div>
            <br>
            <div class="form-group">
                <label for="apellidos">Ingrese sus apellidos: </label > 
                <input id="apellidos" type="text" name="apellidos" value="" size="45" class="form-control"/>
            </div>
            <br>
            <div>
                <label for="edad">Ingrese su edad:</label> 
                <input id="edad" type="text" name="edad" value="" size="45" class="form-control" />
            </div>
            <br>
            <div>
                <input id="tipoUsuario" type="text" name="tipoUsuario" value="4" size="45" class="form-control" hidden="true" />
            </div>
            <br>
            <div>
                <label for="username">Ingrese su nombre de usuario:</label> 
                <input id="username" type="text" name="username" value="" size="45" class="form-control" />
            </div>
            <br>
            <div>
                <label for="password">Ingrese su Password: </label > 
                <input id="password" type="password" name="password" value="" size="45" class="form-control"/>
            </div>
            <br>
            <br>
            <br>
            <input type="submit" value="Enviar" name="enviar" class="btn btn-lg btn-primary btn-block"/>
        </form>
    </body>
</html>
