/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 */
public class CadastrarUsuarioBO {

    public CadastrarUsuarioBO() {
    }

    UsuarioAdmDAO dao = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioAdmDAO();

    public Map<String, String> addUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {
        Map<String, String> result = ValidaUser.validaUsuario(usuario);

        if (result.get("passou").equalsIgnoreCase("true")) {
            dao = new UsuarioAdmDAO();
            
            if (dao.addUsuario(usuario)) {
                return result;
            }
        }else
        result.put("passou", "false");
        return result;

    }

   
}
