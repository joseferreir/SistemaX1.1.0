
<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style-pages.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="paginas/BarraUsuario.jsp"%>
        <script src="js/jquery-1.12.0.js"></script>
        <script src="js/bootstrap.min.js"></script>
          <div class="container container-full">
            <ol class="breadcrumb">
                <li class="active">Home</li>
            </ol>
        </div>

        <div class="container">
            <div class="panel-group" id="accordion">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <a href="#collpaseone" data-toggle="collapse" data-parent="accordion">
                            <h4 class="panel-title">Administração</h4></a>
                    </div>
                    <div id="collpaseone" class="panel-collapse collapse in">
                        <div class="panel-body">

                            <div class="panel-option">
                                <a href="ManterUsuario.jsp">
                                    <img src="img/novoUser.jpg" alt="..." class="img-rounded option-img">
                                    <p>Gerenciar Usuários</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="calendar.jsp">
                                    <img src="img/novocalendario.jpg" alt="..." class="img-rounded option-img">
                                    <p>Gerenciar Feriados</p>
                                </a>
                            </div>


                            <div class="panel-option">
                                <a href="">
                                    <img src="img/logo.png" alt="..." class="img-rounded option-img">
                                    <p>Funcionalidade 3</p>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <a href="#collpasetwo" data-toggle="collapse" data-parent="accordion">
                            <h4 class="panel-title">Controle de Infraestrutura e Recursos</h4></a>
                    </div>
                    <div id="collpasetwo" class="panel-collapse collapse in">
                        <div class="panel-body">

                            <div class="panel-option">
                                <a href="manter_material.jsp">
                                    <img src="img/gerenciar_material_img.png" alt="..." class="img-rounded option-img">
                                    <p>Gerenciar Material</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="gerenciar_bloco.jsp">
                                    <img src="img/company-building-blue.png" alt="..." class="img-rounded option-img">
                                    <p>Gerenciar Blocos</p>
                                </a>
                            </div>

                            <div class="panel-option">
                                <a href="gerenciar_salas.jsp">
                                    <img src="img/sala-icon.png" alt="..." class="img-rounded option-img">
                                    <p>Gerenciar Salas</p>
                                </a>
                            </div>
                            
                            <div class="panel-option">
                                <a href="alocar_salas.jsp">
                                    <img src="img/locar-sala-img.png" alt="..." class="img-rounded option-img" style="width: 72px">
                                    <p>Alocar Salas</p>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script type="text/javascript">
            function a() {
                $('#myModal').modal({
                    show: 'true'
                });
            }

            <%
                Integer b = (Integer) session.getAttribute("cadastro");
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
