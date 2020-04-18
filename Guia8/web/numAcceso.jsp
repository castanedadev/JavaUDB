<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int numeroAccesos = 0;
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date primerAcceso = new Date();

    private Date ahora() {
        Date now = new Date();
        return now;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible"content="IE=edge">
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
                <h3>Accesos a la pagina</h3>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Información del acceso</div>
                <div class="panel-body">
                    <p>
                        <%="La página ha sido accedida " + (++numeroAccesos)
                                + " veces desde el arranque del servidor"%>
                    </p>
                    <p>
                        <%="El primer acceso a la página se realizó el dia "
                                + formatoFecha.format(primerAcceso) + " a las "
                                + formatoHora.format(primerAcceso)%>
                    </p>
                    <p>
                        <%="El ultimo acceso fue el " + formatoFecha.format(ahora())
                                + " a las " + formatoHora.format(ahora())%>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>