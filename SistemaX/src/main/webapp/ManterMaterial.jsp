<%-- 
    Document   : ManterMaterial
    Created on : 23/04/2016, 14:53:27
    Author     : Aluísio
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Material</title>
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

        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="br.edu.ifpb.sistemax.entidades.Material"%>
        <%@page import="java.util.List"%>

    </head>
    <body>
        <%--
        <%@include file="WEB-INF/jspf /CabecaRodape/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf /CadastrarMaterial.jspf" %>
        --%>

        <div class="form-group">
            <label class="col-md-4 control-label" for="butao1"></label>
            <div class="col-md-8">
                <button id="butao1" name="butao1" class="btn btn-success "> <span class="glyphicon glyphicon-plus"></span></button>
                <button id="butao2" name="butao2" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></button>    
                <button id="butao3" name="butao3" class="btn btn-danger "> <span class="glyphicon glyphicon-trash"></span></button>
                <button id="butao4" name="butao4" class="btn btn-primary"><span class="glyphicon glyphicon-download"></span></button>
            </div>
        </div>
        <div class="container-fluid col-md-10">
            <label class="col-md-2 control-label" for="tabela"></label>
            <table class="table table-bordered table-hover table-selectable">
                <thead>
                    <tr class="alert-info text-align-center">
                        <th class="text-align-center">Material</th>
                        <th class="text-align-center">Tombamento</th>
                        <th class="text-align-center">Estado</th>
                        <th class="text-align-center">Local</th>
                    </tr>
                </thead>
                <tbody class="searchable" id="materiaisTable">
                    <jsp:useBean id="dao" class="br.edu.ifpb.sistemax.DAO.MaterialDAOIF"/>
                <c:forEach var="m" items="${dao.busvarTodos()}">
                    <tr>
                        <th>${m.descricao}</th>
                        <th>${m.tombamento}</th>
                        <th>${m.estado}</th>
                        <th>${m.local}</th>
                    </tr>
                    <th></th>
                </c:forEach>

                </tbody>
            </table>
        </div>



    </body>
</html>
