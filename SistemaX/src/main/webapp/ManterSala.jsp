<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@page import="br.edu.ifpb.sistemax.entidades.Sala"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpb.sistemax.DAO.SalaDAO"%>
<%-- 
    Document   : ManterSala
    Created on : 22/04/2016, 16:33:51
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style-pages.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



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


        <%@page import="br.edu.ifpb.sistemax.entidades.Material"%>
        <%@page import="java.util.List"%>
        <%@page import="br.edu.ifpb.sistemax.DAO.MaterialDAOIF"%>


    </head>
    <body>
        
        <div class="panel panel-default">
            <%@include file="WEB-INF/jspf /CabecaRodape/cabecalho.jspf" %>
            <div class="container container-fluid col-md-12">
                <ol class="breadcrumb">
                    <li><a href="Administrador.jsp">Início</a>
                    </li>
                    <li class="active">Gerenciamento de salas</li>
                </ol>
            </div>
        </div>
        <div class="DivCadBloco">
            <%@include file="WEB-INF/jspf /CadastrarSala.jspf" %>
        </div>

        <br>
        <div class="DivCadBloco">
            <!-- cadastrar usuário-->    
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button title="Adicionar sala" class="btn btn-success glyphicon glyphicon-plus" data-toggle="modal" data-target="#cadastrar_modal" ></button>
                            <button title="Editar sala"id="btn-editar" class="btn btn-warning glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editar_modal" disabled></button>
                            <button title="Remover sala"id="btn-deletar" class="btn btn-danger glyphicon glyphicon-trash" data-toggle="modal" data-target="#deletar_modal" disabled></button>
                        </div>                
                        <div class="col-md-6">
                            <input type="text" id="filter" class="form-control" placeholder="Pesquisar material" class="col-md-3 form-control btn-group-justified">
                        </div>
                        <div class="col-md-1"> 
                            <button id="butao4" name="butao4" class="btn btn-link"><span class="glyphicon glyphicon-search"></span></button>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="container ">
                <div class="container col-md-11">
                    <div class="panel panel-default ">
                        <table class="table table-bordered table-hover table-selectable">
                            <thead>
                                <tr class="alert-info text-align-center">
                                    <th class="text-align-center">Sala</th>
                                    <th class="text-align-center">Bloco</th>
                                    <th class="text-align-center">Capaciade</th>
                                    <th class="text-align-center">Estado</th>
                                </tr>
                            </thead>
                            <tbody class="searchable" id="materiaisTable">

                                <%                                            SalaDAO salaDAO = new SalaDAO();
                                    List<Sala> sala = salaDAO.buscarTodas();

                                    for (Sala s : sala) {
                                        out.print("<tr onclick=\"displayData(" + s.getId() + ")\" >");
                                        out.print("<th>" + s.getNome() + "</th>");
                                        out.print("<th>" + s.getIdBloco() + "</th>");
                                        out.print("<th>" + s.getCapacidade() + "</th>");
                                        out.print("<th>" + s.getEstado() + "</th>");
                                        out.print("</tr>");
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <footer></footer>
        <script src="js/jquery-1.12.0.js"></script>
        <script src="js/gerenciar_usuarios.js"></script>
        <script src="/js/bootstrap.min.js"></script>

        <script type="text/javascript">

            function show_success() {
                $('#sucessModal').modal({
                    show: 'true'
                });
            }

            function show_error(textError) {
                $('p#error-body').html(textError);
                $('#errorModal').modal({
                    show: 'true'
                });
            }

            $(document).ready(function EOQ() {
            <%
                Integer aux = (Integer) session.getAttribute("operacao");
                session.setAttribute("operacao", null);
                String erro = (String) session.getAttribute("erro");
                session.setAttribute("erro", null);
            %>
                var c = <%=aux%>;
                var d = "<%=erro%>";
                if (c == 1) {
                    show_success();
                } else if (d !== "null") {
                    show_error(d);
                }
            });

            function displayData(idee) {
                $.ajax({
                    url: "editar_usuario",
                    type: "POST",
                    data: {ide: idee},
                    success: function (data) {
                        var valores = data.split("#break#");
                        $("#nome_edit").val(valores[0]);
                        $("#nome_delet").val(valores[0]);
                        $("#email_edit").val(valores[1]);
                        $("#mtr_edit").val(valores[2]);
                        $("#papel_edit").val(valores[3]);

                        $("#delete_modal").attr("action", "excluir_usuario");
                        $(":input#dados").val(idee);

                        if (valores[3].localeCompare("ADMINISTRADOR")) {
                            $("#papel_edit").prop("disabled", false);
                        } else {
                            $("#papel_edit").prop("disabled", true);
                        }
                    }
                });
            }
            ;
        </script>

    </body>
</html>

