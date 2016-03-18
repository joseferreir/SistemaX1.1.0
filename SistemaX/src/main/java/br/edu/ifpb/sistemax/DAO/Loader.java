/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;

/**
 *
 * @author José
 */
public class Loader {
    public static void main(String[] args) {
        UsuarioAdmDAO s = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioAdmDAO();
        boolean y = s.atualizarParaAdministrador(s.buscaPorNome("admin"));
        System.err.println(y);
        
       
    }
    
}
