<%-- 
    Document   : cadastro_model
    Created on : 31/01/2016, 16:35:16
    Author     : victor
--%>

<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<%@page import="br.edu.ifpb.sistemax.enuns.PapelUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="cadastrar_modal">
    <div class="modal-dialog modal-lm">
        <div class="modal-content">
            <div class="modal-header align-center">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="modal-title">Cadastrar Usuário</h3>
            </div>

            <form method="post" action="AppControle?logica=newuser" role="form">
                <div class="modal-body align-center">
                    <div class="row">
                        <div class="col-sm-6 left-block-profile">
                            <img src="img/profile.jpg" class="cadastro-img" alt="Imagem de Perfil">

                            <div class="input-group">
                                <div class="input-group-btn">
                                    <span class="file-input btn btn-primary btn-file">
                                        <span class="glyphicon glyphicon-open"></span> Enviar Foto
                                        <input type="file" >
                                    </span>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                <%
                                    Usuario usuario_criacao = null;
                                    try {
                                        usuario_criacao = (Usuario) session.getAttribute("usuario_criação");
                                    } catch (Exception ex) {
                                    }

                                    out.print("<input name=\"nome\" pattern=\"[A-Za-z0-9.]+\" title=\"Não pode conter caracteres especiais (%-$_#@, por exemplo), números ou espaços, com exceção de ponto final\" type=\"text\" class=\"form-control\" id=\"nome\" placeholder=\"Seu.Nome\" ");
                                    if (usuario_criacao != null) {
                                        out.print("value=\"" + usuario_criacao.getNome() + "\"");
                                    }
                                    out.print("required>");
                                %>

                            </div>
                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <%
                                    out.print("<input name=\"senha\" pattern=\"^(([a-zA-Z0-9]{0,})+([^a-zA-Z0-9]{0,})+((([A-Z]{1,})+([a-z]{0,})+([^a-zA-Z0-9]{1,}))|(([^a-zA-Z0-9]{1,})+([a-z]{0,})+([A-Z]{1,})))+([a-zA-Z0-9]{0,})+([^a-zA-Z0-9]{0,}))+$\" title=\"A senha deve ter pelo menos 8 dígitos, pelo menos 1 caractere maiúsculo e pelo menos 1 caracteres não-alfabéticos (por exemplo, !, $, #, %)\" type=\"password\" class=\"form-control\" id=\"senha\" placeholder=\"********\"  minlength=\"8\" ");
                                    if (usuario_criacao != null) {
                                        out.print("value=\"" + usuario_criacao.getSenha() + "\"");
                                    }
                                    out.print("required>");
                                %>

                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <%
                                    out.print("<input name=\"email\" type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"nome@email.com\" title=\"Digite um email válido\"");
                                    if (usuario_criacao != null) {
                                        out.print("value=\"" + usuario_criacao.getEmail() + "\"");
                                    }
                                    out.print("required>");
                                %>

                            </div>
                            <div class="form-group">
                                <label for="mtr">Matrícula:</label>
                                <%
                                    out.print("<input name=\"matricula\" pattern=\"[0-9]{6}\" title=\"Matrícula deve conter 6 dígitos numéricos\" type=\"text\" class=\"form-control\" id=\"mtr\" placeholder=\"201412\" ");
                                    if (usuario_criacao != null) {
                                        out.print("value=\"" + usuario_criacao.getMatricula() + "\"");
                                    }
                                    out.print("required>");
                                %>

                            </div>
                            <div class="control-group">
                                <label class="control-label" for="papel">Papel:</label>
                                <div class="controls">
                                    <select id="papel" name="tipo" class="form-control" required>
                                        <%
                                            if (usuario_criacao != null) {
                                                for (PapelUser t : PapelUser.values()) {
                                                    if (!t.equals(PapelUser.Administrador)) {
                                                        out.print("<option");
                                                        if (t.equals(usuario_criacao.getPapel())) {
                                                            out.print(" selected");
                                                        }
                                                        out.print(">" + t.name() + "</option>");
                                                    }
                                                }
                                            } else {
                                                for (PapelUser t : PapelUser.values()) {
                                                    if (!t.equals(PapelUser.Administrador)) {
                                                        out.print("<option");
                                                        if (t.equals(t.Aluno)) {
                                                            out.print(" selected");
                                                        }
                                                        out.print(">" + t.name() + "</option>");
                                                    }
                                                }
                                            }

                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success"> <span class="glyphicon glyphicon-ok"></span> Cadastrar</button>
                    <button class="btn btn-danger float-left" data-dismiss="modal"><span class="glyphicon glyphicon-ban-circle"></span> Cancelar</button>
                    <input id="cadastrar" name="cadastrar" type="submit" value="cadastrar" class="hidden" >
                </div>
            </form>
        </div>
    </div>
</div>
<%    session.setAttribute("usuario_criação", null);
%>
