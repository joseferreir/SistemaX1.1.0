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
public class BlocoCadastrarBO {

    public BlocoCadastrarBO() {
    }
    
    public boolean cadastrar(Bloco bloco){
        if(!bloco.getNome().trim().isEmpty())
            return Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().add(bloco);
        return false;
    }
}
