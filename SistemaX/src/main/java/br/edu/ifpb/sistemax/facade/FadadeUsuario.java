/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.facade;

import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.model.CadastrarUsuarioBO;
import br.edu.ifpb.sistemax.model.LoginBO;
import java.util.Map;

/**
 *
 * @author José
 */
public class FadadeUsuario {

    private static FadadeUsuario instancia = null;
    private CadastrarUsuarioBO cadastrarUsuarioBO = null;
    private LoginBO loginBO = null;

    private FadadeUsuario() {

    }

    public static FadadeUsuario getInstancia() {
        if (instancia == null) {
            instancia = new FadadeUsuario();
        }
        return instancia;

    }

    public Map<String, String> cadastrarUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {
        if (cadastrarUsuarioBO == null) {
            cadastrarUsuarioBO = new CadastrarUsuarioBO();
        }
        return cadastrarUsuarioBO.addUsuario(usuario);
    }

    public Usuario logar(String login, String senha) {
        if (loginBO == null) {
            loginBO = new LoginBO();
        }
        return loginBO.loga(login, senha);
    }

}
