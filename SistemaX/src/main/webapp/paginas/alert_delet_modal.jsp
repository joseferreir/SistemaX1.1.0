<%-- 
    Document   : cadastro_model
    Created on : 31/01/2016, 16:35:16
    Author     : vict
--%>

<%@page import="br.edu.ifpb.sistemax.entidades.Usuario"%>
<%@page import="br.edu.ifpb.sistemax.enuns.PapelUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="deletar_modal">
    <div class="modal-dialog modal-lm">
        <div class="modal-content">
            <form action="" id="delete_modal" method="post">
                <div class="modal-header align-center">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title">Confirmar Exclusão</h3>
                </div>

                <div class="modal-body align-center">
                    <div class="row">
                        <div class="col-sm-12 align-center">
                            <h4>Tem certeza que deseja excluir do sistema <span name="descricao" id="nome_delet"></span> ?</h4>
                            <p>Caso você clique em "Confirmar" todos os dados relacionado à mesma serão perdidos para sempre.</p>
                            <input type="text" name="dados" id="dados" hidden>
                            <input type="text" name="dados_complementares" id="dados_complementares" hidden>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" for="deletar" id="confirmar_exclusao" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Confirmar</button>
                    <button class="btn btn-danger float-left" data-dismiss="modal"><span class="glyphicon glyphicon-ban-circle"></span> Cancelar</button>
                    <input id="deletar" name="deletar" type="submit" value="deletar" class="hidden" >
                </div>
            </form>
        </div>
    </div>
</div>
