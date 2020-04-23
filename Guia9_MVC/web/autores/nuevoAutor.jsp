<%-- 
    Document   : nuevoAutor
    Created on : Apr 22, 2020, 9:41:30 PM
    Author     : Rick
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo autor</title>
        <%@ include file='/WEB-INF/cabecera.jsp' %>
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp"/>
        <div class="container">
            <div class="row">
                <h3>Nuevo autor</h3>
            </div>
            <div class="row">
                <div class=" col-md-7">

                    <c:if test="${not empty listaErrores}">
                        <div class="alert alert-danger">
                            <ul>
                                <c:forEach var="errores"
                                           items="${requestScope.listaErrores}">
                                    <li>${errores}</li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                    <form role="form" action="${pageContext.request.contextPath}/autores.do" method="POST">
                        <input type="hidden" name="op" value="insertar">
                        <div class="well well-sm"><strong><span class="glyphicon
                                                                glyphicon-asterisk"></span>Campos requeridos</strong></div>
                        <div class="form-group">

                            <label for="codigo">Codigo del autor</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="codigo"
                                       id="codigo" value="${autor.codigoAutor}" placeholder="Ingresa el codigo del autor" >
                                <span class="input-group-addon"><span class="glyphicon
                                                                      glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre del autor</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="nombre"
                                       id="nombre" value="${autor.nombreAutor}" placeholder="Ingresa el nombre del autor" >
                                <span class="input-group-addon"><span class="glyphicon
                                                                      glyphicon-asterisk"></span></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contacto">Nacionalidad del autor:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="contacto"
                                       value="${autor.nacionalidad}" name="nacionalidad" placeholder="Ingresa la nacionalidad del autor">
                                <span class="input-group-addon"><span class="glyphicon
                                                                      glyphicon-asterisk"></span></span>
                            </div>
                        </div>

                        <input type="submit" class="btn btn-info" value="Guardar"
                               name="Guardar">
                        <a class="btn btn-danger"
                           href="${pageContext.request.contextPath}/autores.do?op=listar">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
