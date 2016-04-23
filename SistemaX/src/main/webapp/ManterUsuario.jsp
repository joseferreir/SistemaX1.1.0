<%-- 
    Document   : ManterUsuario
    Created on : 23/04/2016, 18:51:18
    Author     : José
--%>

<%@page import="br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style-pages.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@ include file="paginas/alert_sucess_model.jsp" %>
        <%@ include file="paginas/alert_error_model.jsp" %>
        <%@ include file="paginas//editar_usuario_model.jsp" %>
        <%@ include file="paginas/editar_usuario_model.jsp" %>
        <%@ include file="paginas/alert_delet_modal.jsp" %>


        <%@include file="paginas/BarraUsuario.jsp"%>
        <div class="container container-full">
            <ol class="breadcrumb">
                <li><a href="home">Home</a>
                </li>
                <li class="active">Gerenciador de Usuarios</li>
            </ol>
        </div>

        <div class="container">

            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <button class="btn btn-info glyphicon glyphicon-plus" data-toggle="modal" data-target="#cadastrar_modal" ></button>
                        <button id="btn-editar" class="btn btn-warning glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editar_modal" disabled></button>
                        <button id="btn-deletar" class="btn btn-danger glyphicon glyphicon-trash" data-toggle="modal" data-target="#deletar_modal" disabled></button>

                        <form class="form-inline float-right col-xs-8 no-margin-right">
                            <div class="form-group col-xs-12 no-margin-right">
                                <div class="input-group col-xs-12 float-right">
                                    <input type="text" id="filter" class="form-control" placeholder="Nome ou Email">
                                    <div class="btn input-group-addon glyphicon glyphicon-search"></div>
                                </div>
                            </div>
                        </form>

                    </div>

                    <table class="table table-bordered table-hover table-selectable">
                        <thead>
                            <tr class="alert-info text-align-center">

                                <th class="text-align-center">Nome</th>
                                <th class="text-align-center">Email</th>
                                <th class="text-align-center">Papel</th>
                                <!--<th class="text-align-center">Status</th>-->
                            </tr>
                        </thead>
                        <tbody class="searchable">
                            <%                UsuarioAdmDAO queryUsuario = new UsuarioAdmDAO();
                                List<Usuario> usuarios = queryUsuario.buscaTotosUsuarios();

                                Collections.sort(usuarios);

                                for (Usuario u : usuarios) {
                                    out.print("<tr onclick=\"displayData(" + u.getId() + ")\" >");
                                    out.print("<th>" + u.getNome() + "</th>");
                                    out.print("<th>" + u.getEmail() + "</th>");
                                    out.print("<th>" + u.getPapel().name() + "</th>");
                                    out.print("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
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
