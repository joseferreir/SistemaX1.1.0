/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José
 */
public class ValidaUser {

    private final static String EXPRESSAO_REGULAR_SENHA_FORTE = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
    private final static String EXPRESSAO_REGULAR_EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,3}$";
    private final static String EXPRESSAO_REGULAR_MATRICULA = "[0-9]{6}";
    private final static String EXPRESSAO_REGULAR_NOME = "[A-Za-z0-9.]+";

    public static boolean validaPassword(final String password) {

        Pattern p = Pattern.compile(EXPRESSAO_REGULAR_SENHA_FORTE);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    private static boolean validaNome(final String nome) {

        Pattern p = Pattern.compile(EXPRESSAO_REGULAR_NOME);
        Matcher m = p.matcher(nome);
        return m.matches();
    }

    private static boolean validarEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            Pattern pattern = Pattern.compile(EXPRESSAO_REGULAR_EMAIL, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;

    }

    private static boolean validaMatricula(String matricula) {

        Pattern pattern = Pattern.compile(EXPRESSAO_REGULAR_MATRICULA);

        Matcher matcher = pattern.matcher(matricula);
        if (matcher.find() && matcher.group().equals(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    public static Map<String, String> validaUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {

        UsuarioAdmDAO dao = new UsuarioAdmDAO();
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
            resultado.put("senhaInvalida", "senha Invalida");
        }

//        verifica se possui ao menos 1 caractere não alfabetico
        if (!ValidaUser.validaPassword(usuario.getSenha())) {
            resultado.put("senhaInvalida", "senha Invalida");
        }

        //verifica se a matricula possui 6 digitos numericos
        if (!ValidaUser.validaMatricula(usuario.getMatricula())) {
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
