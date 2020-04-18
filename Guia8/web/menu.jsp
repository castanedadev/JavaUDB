<%-- 
    Document   : menu
    Created on : Mar 22, 2020, 11:42:14 PM
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@pagesession="true" %>
<%
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forwardpage="login.jsp">
    <jsp:paramname="error" value="Es obligatorio identificarse"/>
</jsp:forward>
<%
    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button"class="navbar-toggle collapsed"
                            data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Desplegar navegación</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"href="#">Ejemplo Java</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">Inicio</a>
                        </li>
                        <li>
                            <a href="ingresaremp.jsp">Empleados</a>
                        </li>
                        <li class="dropdown">
                            <a href="#"class="dropdown-toggle" data-toggle="dropdown"
                               role="button" aria-haspopup="true"
                               aria-expanded="false">Usuarios <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="opc1.jsp">Crear usuario</a></li>
                                <li><a href="opc2.jsp">Borrar usuario</a></li>
                                <li><a href="opc3.jsp">Cambiar clave</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="cerrarsesion.jsp">
                                <%=usuario%> (cerrar sesión)</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h3>PROCESO DE IDENTIFICACIÓN</h3>
            <p>
            <h5>Menú de administración</h5>
            <b>Usuario activo:</b><%=usuario%>
        </p>
    </div>
</body>
</html>
