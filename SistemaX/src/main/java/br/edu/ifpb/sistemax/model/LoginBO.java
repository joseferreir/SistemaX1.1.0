/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;

/**
 *
 * @author José
 */
public class LoginBO {

    public LoginBO() {
    }
    

    public Usuario loga(String login, String senha) {
        if (login == null || login.trim().isEmpty()) {
            return null;
        }
        if (!ValidaUser.validaPassword(senha)) {
            return null;
        }
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().login(login, senha);
    }

}
