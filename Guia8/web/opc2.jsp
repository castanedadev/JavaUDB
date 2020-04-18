<%-- 
    Document   : opc2
    Created on : Mar 23, 2020, 12:11:04 AM
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@pagesession="true" %>
<%
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forwardpage="login.jsp">
    <jsp:paramname="error" value="Es obligatorio identificarse"/>
</jsp:forward>
<%
    } else {
        usuario = (String) sesionOk.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
