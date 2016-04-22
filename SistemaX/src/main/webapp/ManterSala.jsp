<%-- 
    Document   : ManterSala
    Created on : 22/04/2016, 16:33:51
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Sala</title>
                <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        <%@include file="WEB-INF/jspf /CadastrarSala.jspf" %>
        <%@include file="WEB-INF/jspf /InserirEvento.jspf" %>
        <%@include file="WEB-INF/jspf /AlocarEvento.jspf" %>
        <%@include file="WEB-INF/jspf /AlocarMaterial.jspf" %>
        <%@include file="WEB-INF/jspf /DevolverMaterial.jspf" %>
    </body>
</html>
