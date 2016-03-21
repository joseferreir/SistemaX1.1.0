/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;

/**
 *
 * @author José
 */
public class RemoverUsuarioBO {
      public boolean remover(int id){
           return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioAdmDAO().remover(id);
      }
        
    
}
