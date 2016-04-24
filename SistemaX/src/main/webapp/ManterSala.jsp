<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
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
                padding-top: 5%;
                padding-left: 10%;
                padding-right: 10%;                
                padding-bottom: 2%;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <link rel="stylesheet" href="css/aluisioIcomoon/style.css">
    </head>
    <body>

        <%--
        <%@include file="WEB-INF/jspf /CabecaRodape/cabecalho.jspf" %>
        <%@include file="WEB-INF/jspf /CadastrarSala.jspf" %>
        --%>

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button id="butao1" name="butao1" class="btn btn-success " title="Adicionar sala"> <span class="glyphicon glyphicon-plus"></span></button>
                            <button id="butao2" name="butao2" class="btn btn-warning" title="Editar sala"><span class="glyphicon glyphicon-pencil"></span></button>    
                            <button id="butao3" name="butao3" class="btn btn-danger " title="Remover sala"> <span class="glyphicon glyphicon-trash"></span></button>
                        </div>                
                        <div class="col-md-6">                    
                            <input id="filtrar" name="filtrar" type="text" placeholder="Pesquisar sala" class="col-md-3 form-control btn-group-justified">
                        </div>
                        <div class="col-md-1"> 
                            <button id="butao4" name="butao4" class="btn btn-link"><span class="glyphicon glyphicon-search"></span></button>
                        </div>
                    </div>
                </div>
            </div>                       
            <div class="panel-body">
                <div class="container-fluid col-md-12">

                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-condensed">
                                    <thead>
                                        <tr class="alert-info text-align-center">
                                            <th class="text-align-center">Sala</th>
                                            <th class="text-align-center">Bloco</th>
                                            <th class="text-align-center">Capaciade</th>
                                            <th class="text-align-center">Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody class="searchable" id="materiaisTable">
                                        
                                        <jsp:useBean id="dao" class="br.edu.ifpb.sistemax.DAO.SalaDAO"/>
                                        <c:forEach var="s" items="${dao.buscarTodas()}">
                                            <tr>
                                                <th>${s.nome}</th>
                                                <th>${s.idBloco}</th>
                                                <th>${s.capacidade}</th>
                                                <th>${s.estado}</th>
                                            </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
