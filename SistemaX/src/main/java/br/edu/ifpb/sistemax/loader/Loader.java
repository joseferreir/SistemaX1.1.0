/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.loader;

import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.facade.FadadeUsuario;
import br.edu.ifpb.sistemax.model.CadastrarUsuarioBO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdk.nashorn.internal.runtime.regexp.joni.constants.TokenType;

/**
 *
 * @author José
 */
public class Loader {
    public static void main(String[] args) throws EmailExistenteException, NomeUsuarioExistenteException {
        UsuarioAdmDAO s = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioAdmDAO();
          Usuario u = new Usuario("000032", "mariaw", "maria2@gmail.com", "wSew12@#32", "foto4", true, PapelUser.Administrador);
        HashMap<String, String> aa = new HashMap<String, String>();
        aa.put("nomeusuario", "d");
        //   CadastrarUsuarioBO bo = new CadastrarUsuarioBO();
        // Map<String, String> y = bo.addUsuario(u);
        FadadeUsuario cc = FadadeUsuario.getInstancia();
        
            Usuario y = cc.logar("mariaw", "wSew12@#32");
        
        System.err.println("ff"+y.getEmail());
        
       
    }
    
}
