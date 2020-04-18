<%-- 
    Document   : consulta_usuario
    Created on : Mar 23, 2020, 1:29:28 AM
    Author     : Rick
--%>

<%@page import="sv.edu.udb.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<%
    Conexion con = new Conexion();
    String id = request.getParameter("id");
    System.out.println("update ID " + id);
    con.setRs("SELECT * FROM usuarios WHERE id_usuario= " + id + ";");
    ResultSet rs = con.getResultSet();

    String nombre = "";
    String apellido = "";
    int edad = 0;
    int tipo_usuario = 0;
    String usuario = "";
    String password = "";

    while (rs.next()) {
        nombre = rs.getString("nombres");
        apellido = rs.getString("apellidos");
        edad = rs.getInt("edad");
        tipo_usuario = rs.getInt("id_tipo_usuario");
        usuario = rs.getString("usuario");
        password = rs.getString("password");
    }
    con.cerrarConexion();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    <body class="container-fluid"> 
        <form action="actualizar_usuario.jsp" method="post">
            <div class="row">
                <h3>Usuarios</h3>
            </div>
            <div class="row">
                <div 
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
                               placeholder="Ingresa el nombre" required value="<%=nombre%>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellidos:</label>
                    <div class="input-group">
                        <input type="text"class="form-control"id="apellido" name="apellido"
                               placeholder="Ingresa el apellido" required value="<%=apellido%>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>                                        
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edad">Edad: </label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="edad" name="edad"
                               placeholder="Ingresa la edad" required value="<%=edad%>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>                                        
                        </span>
                    </div>
                </div>
                <div>
                    <label for="tipoUsuario">Tipo Usuario: </label>
                    <div class="input-group">
                        <jsp:include page="consultar_tipo_usuarios.jsp" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>                                        
                        </span>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label for="usuario">Usuario: </label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="usuario" name="usuario"
                               placeholder="Ingresa el nombre de usuario" required value="<%=usuario%>">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>                                        
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Ingresa el password" required value="password">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-asterisk"></span>                                        
                        </span>
                    </div>
                </div>

                <input type="hidden" id="id_usuario" name="id_usuario" value="<%=id%>">
                <input type="submit" class="btn btn-info" value="Guardar">
                <a href="opc1.jsp"> Regresar</a>                       
            </div>
        </form>
    </body>
</html>