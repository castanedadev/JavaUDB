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
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            //Sentencia sql para ingresar datos
            st = conexion.prepareStatement("INSERT INTO empleados values (null,?,?,?)");
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, telefono);
            st.executeUpdate();
            conexion.close();
        %>
        <%--Forward que se utiliza para redireccionar a la pagina de ingresaremp.jsp--%>
        <jsp:forward page="ingresaremp.jsp">
            <jsp:param name="resultado" value="Datos Ingresados Exitosamente"/>
        </jsp:forward>
    </body>
</html>
