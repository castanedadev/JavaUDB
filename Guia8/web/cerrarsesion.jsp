<%-- 
    Document   : cerrarsesion
    Created on : Mar 22, 2020, 11:46:47 PM
    Author     : Rick
--%>
<%@page session="true"%>
<%
    HttpSession sesionOk = request.getSession();
    sesionOk.invalidate();
%>
<jsp:forward page="login.jsp"/>