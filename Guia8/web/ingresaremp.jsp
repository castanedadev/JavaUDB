<%@page language="java" import="java.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport"content="width=device-width, initial-scale=1">
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
        <div class="container">
            <div class="row">
                <h3>Empleados</h3>
            </div>
            <div class="row col-md-5">
                <form role="form" action="ingresar.jsp" method="POST">
                    <div class="col-md-10">
                        <div class="well well-sm">
                            <strong>
                                <span class="glyphicon glyphicon-asterisk"></span>
                                Campos requeridos
                            </strong>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombres:</label>
                            <div class="input-group">
                                <input type="text"class="form-control" name="nombre" id="nombre"
                                       placeholder="Ingresa el nombre" required>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-asterisk"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellidos:</label>
                            <div class="input-group">
                                <input type="text"class="form-control"id="apellido" name="apellido"
                                       placeholder="Ingresa el apellido" required>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-asterisk"></span>                                        
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edad">Edad: </label>
                            <div class="input-group">
                                <input type="text" class="form-control"id="telefono" name="edad"
                                       placeholder="Ingresa la edad" required>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-asterisk"></span>                                        
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono: </label>
                            <div class="input-group">
                                <input type="text" class="form-control"id="telefono" name="telefono"
                                       placeholder="Ingresa el telefono del usuario" required>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-asterisk"></span>                                        
                                </span>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-info" value="Guardar">
                    </div>
                </form>
                <%-- Verificando si la variable resultado esta vacia--%>
                <%if (request.getParameter("resultado") != null) {
                %>
                <div class="alert alert-success col-md-10">
                    <b><%=request.getParameter("resultado")%></b>
                </div>
                <%
                    }
                %>
            </div>
            <!--notese el uso de jsp:include -->
            <jsp:include page="consulta.jsp" />
        </div><!-- /container -->

    </body>
</html>
