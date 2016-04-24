<%-- 
    Document   : AlocarSala
    Created on : 24/04/2016, 01:31:01
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alocar Sala</title>
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
        <%@include file="WEB-INF/jspf /InserirEvento.jspf" %> 
        <%@include file="WEB-INF/jspf /AlocarEvento.jspf" %>
        <%@include file="WEB-INF/jspf /AlocarMaterial.jspf" %>
        <%@include file="WEB-INF/jspf /DevolverMaterial.jspf" %>
        --%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button id="butao1" name="butao1" class="btn btn-success " alt="Adicionar Evento" title="Adicionar evento"> <span class="aluisio-event_available"></span></button>
                            <button id="butao2" name="butao2" class="btn btn-danger " alt="Remover Evento" title="Remover evento"> <span class="aluisio-event_busy"></span></button>
                            <button id="butao3" name="butao3" class="btn btn-success " alt="Alocar sala" title="Alocar sala"><span class="aluisio-lock_outline"></span></button>
                            <button id="butao4" name="butao4" class="btn btn-danger " alt="Remover alocar da sala" title="Remover sala"> <span class="aluisio-lock_open"></span></button>
                            <button id="butao5" name="butao5" class="btn btn-primary" alt="Adicionar material" title="Adicionar material"><span class="glyphicon glyphicon-download"></span></button>                    
                        </div>                
                        <div class="col-md-6">                    
                            <input id="filtrar" name="filtrar" type="text" placeholder="Pesquisar evento" class="col-md-3 form-control btn-group-justified">
                        </div>
                        <div class="col-md-1"> 
                            <button id="butao4" name="butao4" class="btn btn-link"><span class="glyphicon glyphicon-search"></span></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="container-fluid col-md-12">
                    <table class="table table-bordered table-hover table-selectable">
                        <thead>
                            <tr class="alert-info text-align-center">                            
                                <th class="text-align-center">Data</th>
                                <th class="text-align-center">Duração</th>
                                <th class="text-align-center">Evento</th>
                                <th class="text-align-center">Situação</th>
                                <th class="text-align-center">Local</th>
                            </tr>
                        </thead>
                        <tbody class="searchable" id="materiaisTable">
                            <jsp:useBean id="dao" class="br.edu.ifpb.sistemax.DAO.EventoDAO"/>
                        <c:forEach var="e" items="${dao.buscarTodos()}">
                            <tr>
                                <th>${e.dataInicio}</th>
                                <th>${e.duracao}</th>
                                <th>${e.nome}</th>
                                <th>${e.estado}</th>
                                <th>${e.local}</th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
