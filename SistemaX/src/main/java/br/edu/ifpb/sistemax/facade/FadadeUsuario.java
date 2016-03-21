/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.facade;

import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.model.AtualizarPerfilBO;
import br.edu.ifpb.sistemax.model.BuscarUsuarioBO;
import br.edu.ifpb.sistemax.model.CadastrarUsuarioBO;
import br.edu.ifpb.sistemax.model.LoginBO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public class FadadeUsuario {

    private static FadadeUsuario instancia = null;
    private CadastrarUsuarioBO cadastrarUsuarioBO = null;
    private LoginBO loginBO = null;
    private BuscarUsuarioBO buscarUsuarioBO = null;
    private AtualizarPerfilBO atualizarPerfil = null;

    protected FadadeUsuario() {

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

    public List<Usuario> buscarAtributos(Map<String, String> map) {
        if (buscarUsuarioBO == null) {
            buscarUsuarioBO = new BuscarUsuarioBO();
        }
        return buscarUsuarioBO.buscarAtributos(map);
    }

    public List<Usuario> buscarAtributosNaoExatos(Map<String, String> map) {
        if (buscarUsuarioBO == null) {
            buscarUsuarioBO = new BuscarUsuarioBO();
        }
        return buscarUsuarioBO.buscarAtributosNaoExatos(map);
    }

    public Usuario buscaPorEmail(String email) {
        if (buscarUsuarioBO == null) {
            buscarUsuarioBO = new BuscarUsuarioBO();
        }
        return buscarUsuarioBO.buscaPorEmail(email);

    }

    public Usuario buscaPorNome(String nome) {
        if (buscarUsuarioBO == null) {
            buscarUsuarioBO = new BuscarUsuarioBO();
        }
        return buscarUsuarioBO.buscaPorNome(nome);
    }

    public Map<String, String> atualizarPerfil(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {
        if (atualizarPerfil == null) {
            atualizarPerfil = new AtualizarPerfilBO();
        }
        return atualizarPerfil.editarPerfil(usuario);
    }
}
