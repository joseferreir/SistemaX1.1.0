<%-- 
    Document   : Administrador
    Created on : 20/03/2016, 10:43:09
    Author     : José
--%>
<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<% 
  Usuario  usuario =(Usuario)  pageContext.getSession().getAttribute("user");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="${usuario.nome}">
        ${usuario.nome}
        <h1>pagina admin!</h1>
    </body>
</html>
