<%-- 
    Document   : ManterBloco
    Created on : 23/04/2016, 23:35:34
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Bloco</title>
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
        <%@include file="WEB-INF/jspf /CadastrarBloco.jspf" %>
        --%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button id="butao1" name="butao1" class="btn btn-success" title="Adicionar bloco"> <span class="glyphicon glyphicon-plus"></span></button>
                            <button id="butao2" name="butao2" class="btn btn-warning" title="Editar bloco"><span class="glyphicon glyphicon-pencil"></span></button>    
                            <button id="butao3" name="butao3" class="btn btn-danger " title="Remover bloco"> <span class="glyphicon glyphicon-trash"></span></button>
                        </div>                
                        <div class="col-md-6">                    
                            <input id="filtrar" name="filtrar" type="text" placeholder="Pesquisar bloco" class="col-md-3 form-control btn-group-justified">
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
                                        <tr>
                                            <th>
                                                Nome do bloco
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <jsp:useBean id="dao" class="br.edu.ifpb.sistemax.DAO.BlocoDAO"/>
                                    <c:forEach var="b" items="${dao.buscarTodos()}">
                                        <tr>
                                            <th>${b.nome}</th>                                            
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
