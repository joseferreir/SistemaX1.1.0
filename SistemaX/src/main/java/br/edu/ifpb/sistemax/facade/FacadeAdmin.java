/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.facade;

import br.edu.ifpb.sistemax.model.RemoverUsuarioBO;

/**
 *
 * @author José
 */
public class FacadeAdmin extends FadadeUsuario {

    private RemoverUsuarioBO removerUsuarioBO = null;

    public boolean remover(int id) {
        if (removerUsuarioBO == null) {
            removerUsuarioBO = new RemoverUsuarioBO();
        }
        return removerUsuarioBO.remover(id);

    }

}
