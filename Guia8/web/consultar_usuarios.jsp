<%-- 
    Document   : consultar_usuarios
    Created on : Mar 23, 2020, 12:13:15 AM
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="eliminar_usuario.jsp" method="post">
            <div class="row col-md-7">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Edad</th>
                            <th>Id_Tipo_usuario</th>
                            <th>Usuario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Connection conexion = null;
                            PreparedStatement st = null;
                            ResultSet rs = null;
                            //Leemos el driver de Mysql
                            Class.forName("com.mysql.jdbc.Driver");
                            // Se obtiene una conexión con la base de datos.
                            conexion = DriverManager.getConnection("jdbc:mysql://localhost/guia8", "root", "This#is#4#MySQL");

                            st = conexion.prepareStatement("SELECT * FROM usuarios;");
                            rs = st.executeQuery();
                            while (rs.next()) {
                        %>
                        <tr>
                            <td><%=rs.getString("nombres")%></td>
                            <td><%=rs.getString("apellidos")%></td>
                            <td><%=rs.getString("edad")%></td>
                            <td><%=rs.getString("id_tipo_usuario")%></td>
                            <td><%=rs.getString("usuario")%></td>
                            <td colspan="4"> 
                                <a class="btn btn-danger" href='eliminar_usuario.jsp?id=<%=rs.getString("id_usuario")%>'>
                                    Eliminar
                                </a>
                                    <a class="btn btn-info" href='consulta_usuario.jsp?id=<%=rs.getString("id_usuario")%>'>
                                    Editar
                                </a>                                
                            </td>
                        </tr>
                        <%
                            }
                            conexion.close();
                        %>
                    </tbody>
                </table>
            </div>
        </form>
    </body>
</html>