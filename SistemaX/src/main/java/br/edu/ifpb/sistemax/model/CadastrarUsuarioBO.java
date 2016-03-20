/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioAdminDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
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
        Map<String, String> result = ValidaUsuario(usuario);

        if (result.get("passou").equalsIgnoreCase("true")) {
            dao = new UsuarioAdmDAO();
            if (dao.addUsuario(usuario)) {
                return result;
            }
        }else
        result.put("passou", "false");
        return result;

    }

    private Map<String, String> ValidaUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {

        UsuarioAdmDAO DAO = new UsuarioAdmDAO();
        Map<String, String> resultado = new HashMap<>();
        if (usuario.getPapel() == null) {
            resultado.put("papel", "informe o papel do usuário ");
        }

        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            resultado.put("nome", "informe do nome usuário ");
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            resultado.put("email", "informe o email do usuário ");
        }

        if (usuario.getSenha() == null || usuario.getNome().trim().isEmpty()) {
            resultado.put("senha", "informe a senha do usuário ");
        }

        if (usuario.getMatricula() == null || usuario.getMatricula().trim().isEmpty()) {
            resultado.put("matricula", "informe a matricula do usuário ");
        }

        //verificar se o email existe
        if (dao.buscaPorEmail(usuario.getEmail()) != null) {
            resultado.put("emailExistente", "o email já existe ");
            throw new EmailExistenteException();
        }

        //verificar se o nome de usuario ja existe
        Usuario nomeExiste = dao.buscaPorNome(usuario.getNome());
        if (nomeExiste != null) {
            resultado.put("nomeExistente", "O nome já existe ");
            throw new NomeUsuarioExistenteException();
        }
        //verifica o formato do nome
        if (!ValidaUser.validaNome(usuario.getNome())) {
            System.out.println("p1");
            resultado.put("NomeInvalido", "O noeme não pode conter caracteres especiais  ");
        }

        //verifica o formato do email
        if (!ValidaUser.validarEmail(usuario.getEmail())) {

            resultado.put("emailInvalido", "email invalido");
        }

        //verifica se a senha possui ao menos 8 caracteres
        if (usuario.getSenha().length() < 8) {
            System.out.println("p3");
            resultado.put("senhaInvalida", "senha Invalida");
        }

//        verifica se possui ao menos 1 caractere não alfabetico
        if (!ValidaUser.validaPassword(usuario.getSenha())) {
            System.out.println("p4");
            resultado.put("senhaInvalida", "senha Invalida");
        }

        //verifica se a matricula possui 6 digitos numericos
        if (!ValidaUser.validaMatricula(usuario.getMatricula())) {
            System.out.println("p5");
            resultado.put("matricula", "Invalida");
        }
        if (resultado.isEmpty()) {
            resultado.put("passou", "true");
        } else {
            resultado.put("passou", "false");
        }
        return resultado;
    }

}
