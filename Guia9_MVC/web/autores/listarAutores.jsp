<%-- 
    Document   : listarAutores
    Created on : Apr 22, 2020, 9:27:16 PM
    Author     : Rick
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de autores</title>
        <%@ include file='/WEB-INF/cabecera.jsp' %>
    </head>
    <body>        
        <jsp:include page="/WEB-INF/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Lista de autores</h3>
            </div>
            <div class="row">
                <div class="col-md-10">
                    <a type="button" class="btn btn-primary btn-md"
                       href="${pageContext.request.contextPath}/autores.do?op=nuevo"> Nuevo autor</a>
                    <br/><br/>
                    <table class="table table-striped table-bordered table-hover"
                           id="tabla">
                        <thead>
                            <tr>
                                <th>Codigo del autor</th>
                                <th>Nombre del autor</th>
                                <th>Nacionalidad</th>
                                <th>Operaciones</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${requestScope.listaAutores}" var="autores">
                                <tr>
                                    <td>${autores.codigoAutor}</td>
                                    <td>${autores.nombreAutor}</td>
                                    <td>${autores.nacionalidad}</td>
                                    <td>
                                        <a class="btn btn-primary"
                                           href="${contextPath}/autores.do?op=obtener&id=${autores.codigoAutor}"><span
                                                class="glyphicon glyphicon-edit"></span> Editar</a>
                                        <a class="btn btn-danger"
                                           href="javascript:eliminar('${autores.codigoAutor}')"><span class="glyphicon glyphicontrash"></span> Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('#tabla').DataTable();
            });
            <c:if test="${not empty exito}">
            alertify.success('${exito}');
                <c:set var="exito" value="" scope="session" />
            </c:if>
            <c:if test="${not empty fracaso}">
            alertify.error('${fracaso}');
                <c:set var="fracaso" value="" scope="session" />
            </c:if>
            function eliminar(id) {
                alertify.confirm("¿Realmente decea eliminar este Autor?", function (e) {
                    if (e) {
                        location.href = "autores.do?op=eliminar&id=" + id;
                    }
                });
            }
        </script>
    </body>
</html>
