<%-- 
    Document   : Administrador
    Created on : 20/03/2016, 10:43:09
    Author     : José
--%>
<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<% 
  Usuario  usuario =(Usuario)  session.getAttribute("user");
  pageContext.setAttribute("admin", usuario);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="${admin.foto}" style="width: 100px ;height: 80px;">
        <h3>  ${admin.nome}</h3>
        <h1>pagina admin!</h1>
    </body>
</html>
