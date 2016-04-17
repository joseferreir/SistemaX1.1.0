/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public class UsuarioBuscarBO {

    public UsuarioBuscarBO() {
    }
      public List<Usuario> buscarAtributos(Map<String, String> map){
       return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscarAtributos(map);
      }

    public List<Usuario> buscarAtributosNaoExatos(Map<String, String> map){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscarAtributosNaoExatos(map);
        
    }

     public Usuario buscaPorEmail(String email){
         return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorEmail(email);
     }

    public Usuario buscaPorNome(String nome){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorNome(nome);
    }
    
}
