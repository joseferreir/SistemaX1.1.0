/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Usuario;

/**
 * interface para objetos do tipo Usuario, onde serão contidos, os
 * métodositeração com a base de dados para o mesmo.
 *
 * @Aluísio , josé e zilderlan
 *
 * @version 1.05
 *
 * @since Release 02 da aplicação
 *
 */
public interface UsuarioDAOIF {
/**
 * 
 * @param objeto tipo usuario
 * @return Bololean true caso o Usuário seja Atualizado, caso contrario false
 * 
 */
    public boolean editarPirfio(Usuario usuario);

    public Usuario login(String nomeOuEmail, String senha);

    public boolean alterarSenha(Usuario u);
     public Usuario buscaPorEmail(String email);

    public Usuario buscaPorNome(String nome);

}
