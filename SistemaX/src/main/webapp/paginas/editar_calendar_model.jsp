
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container" style="z-index: 10;">
    <div class="modal fade" id="editar_modal">
        <div class="modal-dialog modal-lm">
            <div class="modal-content">
                <div class="modal-header align-center">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title"><span id="data-title">Data</span></h3>
                </div>
                <form method="post" action="atualizar_feriado" class="form-inline no-margin-right" enctype="multipart/form-data">
                    <div class="modal-body align-center">
                            <p>Insira a data do feriado:</p>
                            <input type="date" class="form-control" name="data_feriado" id="data_feriado" required>
                            <br><br>
                            <p>Insira a descrição do feriado:</p>
                            <input type="text" class="form-control" name="descricao_feriado" id="descricao_feriado" placeholder="Descrição do feriado" required>
                            <br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-danger float-left" data-dismiss="modal"><span class="glyphicon glyphicon-ban-circle"></span> Cancelar</button>

                        <label for="cadastrar" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Salvar</label>
                        <input id="cadastrar" name="cadastrar" type="submit" class="hidden">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
