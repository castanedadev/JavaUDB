<%@page session="true" language="java" import="java.util.*" %>
<%@page import="sv.edu.udb.Conexion, java.sql.*" %>
<%
    String usuario = request.getParameter("usuario");
    String clave = request.getParameter("clave");
    Conexion con = new Conexion();
    //buscará una coincidencia (count usuario), si es correcto
    //podrá loguearse
    String sql = "select count(usuario),nombres from usuarios"
            + " where usuario='" + usuario + "' and "
            + "password=SHA2('" + clave + "',256)";
    con.setRs(sql);
    out.println(sql);
    //Se esta usando SHA2 con claves de 256 bits
    ResultSet rs = con.getResultSet();
    rs.next();
    if (rs.getInt(1) == 1) { //solo una coincidencia es permitida

        //si se puede loguear, hay que evitar que quede una conexión
        //activa
        rs.close();
        con.cerrarConexion();

        //se asignan los parámetros de sesión
        HttpSession sesionOk = request.getSession();
        sesionOk.setAttribute("usuario", usuario);
%>
<jsp:forwardpage="menu.jsp" />
<%
} else {
%>
<jsp:forward page="login.jsp">
    <jsp:param name="error" value="Usuario y/o clave incorrecto. Vuelve a intentarlo."/>
</jsp:forward>
<%
    }
    rs.close();
    con.cerrarConexion();
%>