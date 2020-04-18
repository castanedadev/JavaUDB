<%-- 
    Document   : second_jsp
    Created on : Mar 22, 2020, 7:43:32 PM
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%! String titulo = "Mi primer ejemplo con JSP";
    String cadena = "Primer ejemplo";
%>
<!DOCTYPEhtml>
<html>
    <head>
        <title><%=titulo%></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <%
            //Obteniendo la fecha actual
            Date fechaActual = new Date();
            //Formateando la fecha
            DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        %>
        <div class="container">
            <div class="row">
                <h3><%=titulo%></h3>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading"><%=cadena%></div>
                <div class="panel-body">
                    <p><%="La fecha actual es: " + formatoFecha.format(fechaActual)%></p>
                    <p><%="La hora actual es: " + formatoHora.format(fechaActual)%></p>
                    <p><%=" El tamaño de la cadena " + cadena + " es:" + cadena.length()%></p>
                </div>
            </div>
        </div>
    </body>
</html>
