/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Bloco;
import java.util.List;

/**
 *
 * @author José
 */
public class BlocoBuscarBO {

    public BlocoBuscarBO() {
    }
    
     public Bloco buscarPorId(int idBloco){
         return Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarPorId(idBloco);
     }

    public Bloco buscarPorNome(String nomeBloco){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarPorNome(nomeBloco);
    }

    public List<Bloco> buscarTodos(){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarTodos();
    }
    
}
