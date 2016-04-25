
<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style-pages.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        
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
        <div class="panel panel-default">
            <%@include file="WEB-INF/jspf /CabecaRodape/cabecalho.jspf" %>
        </div>
        
        <div class="alert-link">
            <ol class="breadcrumb">
                <li class="active">Início</li>
            </ol>
        </div>

        <div class="container" class="col-lg-8">
            <div class="panel-group" id="accordion" class="col-lg-8">
                <div class="panel panel-body" class="col-lg-10">
                    <div class="panel-footer">
                        <a href="#collpaseone" data-toggle="collapse" data-parent="accordion">
                            <h4 class="panel-title">Recursos Humanos</h4>
                        </a>                    
                    </div>
                    <div id="collpaseone" class="panel-collapse collapse in">
                        <div class="panel-body">

                            <div class="panel-option">
                                <a href="#">
                                    <span class="glyphicon glyphicon-user" style="font-size:40px;"></span>
                                    <p>Professores</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="#">
                                    <span class="glyphicon glyphicon-calendar"style="font-size:40px;"></span>                                    
                                    <p>Feriados</p>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="panel panel-body">
                    <div class="panel-footer">
                        <a href="#collpasetwo" data-toggle="collapse" data-parent="accordion">
                            <h4 class="panel-title">Recursos Materiais e Dependências</h4>
                        </a>                    
                    </div>                    
                    <div id="collpasetwo" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <div class="panel-option">
                                <a href="#">
                                    <span class="aluisio-view_agenda"style="font-size:40px;"></span>  
                                    <p>Visualizar Blocos</p>
                                </a>
                            </div>
                            <div class="panel-option">
                                <a href="#">
                                    <span class="aluisio-class"style="font-size:40px;"></span>  
                                    <p>Visualizar Salas</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="#">
                                    <span class="aluisio-assignment"style="font-size:40px;"></span>  
                                    <p>Visualizar Materiais</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="#">
                                    <span class="aluisio-settings_backup_restore"style="font-size:40px;"></span>
                                    <p>Alocar Sala e Materiais</p>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="js/jquery-1.12.0.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function a() {
                $('#myModal').modal({
                    show: 'true'
                });
            }

            <%                Integer b = (Integer) session.getAttribute("cadastro");
            %>
            var c = <%=b%>;
            if (c == 1) {
                a();
            } else {
            }
        </script>

        <footer></footer>

    </body>
</html>
