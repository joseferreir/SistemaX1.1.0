/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Bloco;

/**
 *
 * @author José
 */
public class BlocoAlterarBO {
    public boolean alterar(Bloco bloco){
        if(!bloco.getNome().trim().isEmpty()&& bloco.getId()>0)
            return Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().alterar(bloco);
        return false;
    }
}
