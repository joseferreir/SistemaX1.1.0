<%-- 
    Document   : cadastro_model
    Created on : 31/01/2016, 16:35:16
    Author     : victor
--%>

<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<%@page import="br.edu.ifpb.sistemax.enuns.PapelUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="modal fade" id="editar_modal">
      <div class="modal-dialog modal-lm">
        <div class="modal-content">
         <div class="modal-header align-center">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">Editar Usuário</h3>
        </div>

        <form method="post" action="AppControle?logica" role="form">
          <div class="modal-body align-center">
            <div class="row">
              <div class="col-sm-6 left-block-profile">
                <img src="img/profile.jpg" class="cadastro-img" alt="Imagem de Perfil">

                <div class="input-group">
                  <div class="input-group-btn">
                    <span class="file-input btn btn-primary btn-file">
                      <span class="glyphicon glyphicon-open"></span> Enviar Foto
                      <input type="file">
                    </span>
                  </div>
                </div>
              </div>

              <div class="col-sm-6">
                <div class="form-group">
                  <label for="nome">Nome:</label>
                  <input name="nome" pattern="[A-Za-z0-9.]+" title="Não pode conter caracteres especiais (%-$_#@, por exemplo), números ou espaços, com exceção de ponto final" type="text" class="form-control" id="nome_edit" placeholder="Nome" required>
                </div>
                <div class="form-group">

                </div>
                <div class="form-group">
                  <label for="email">Email:</label>
                    <input name="email" type="email" class="form-control" id="email_edit" placeholder="nome@email.com" value="" required>
                </div>
                <div class="form-group">
                  <label for="mtr">Matrícula:</label>
                    <input name="matricula" pattern="[0-9]{6}" title="Matrícula deve conter 6 dígitos numéricos" type="text" class="form-control" id="mtr_edit" placeholder="201412" value="" required>
                </div>
                <div class="control-group">
                  <label class="control-label" for="papel">Papel:</label>
                  <div class="controls">
                    <select id="papel_edit" name="tipo" class="form-control">
                      <%
                          for(PapelUser t : PapelUser.values()){
                              out.print("<option");
                              
                              if(t.equals(PapelUser.Administrador)){
                                out.print(" id=\" admin-option \" hidden>"+t.name()+"</option>");
                              }else{
                                out.print(">"+t.name()+"</option>");  
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
              <button class="btn btn-danger float-left" data-dismiss="modal"><span class="glyphicon glyphicon-ban-circle"></span> Cancelar</button>

              <label for="editar_user" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Salvar</label>
              <input id="editar_user" name="editar_user" type="submit" value="" class="hidden">
            </div>
        </form>
      </div>
    </div>
  </div>
