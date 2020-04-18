<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="eliminar.jsp" method="post">
            <div class="row col-md-7">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Operaciones</th>
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

                            st = conexion.prepareStatement("SELECT * FROM empleados;");
                            rs = st.executeQuery();
                            while (rs.next()) {
                        %>
                        <tr>
                            <td><%=rs.getString("nombre")%></td>
                            <td><%=rs.getString("apellidos")%></td>
                            <td><%=rs.getString("telefono")%></td>
                            <td>
                                <a class="btn btn-danger" href='eliminar.jsp?id=<%=rs.getString("codigo")%>'>
                                    Eliminar
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
