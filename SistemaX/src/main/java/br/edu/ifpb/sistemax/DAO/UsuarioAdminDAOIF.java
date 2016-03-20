/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Usuario;
import java.util.List;

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
public interface UsuarioAdminDAOIF {

    public boolean addUsuario(Usuario usuario);

    public boolean remover(int id);

    public List<Usuario> buscaTotosUsuarios();

    public List<Usuario> buscaPorPalavraChave(String palavra);

    public boolean atualizarParaAdministrador(Usuario u);

    public boolean editarUsuario(Usuario usuario);

   

}
