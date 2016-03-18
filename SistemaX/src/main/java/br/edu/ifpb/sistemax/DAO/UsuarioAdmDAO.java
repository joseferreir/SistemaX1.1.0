/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class UsuarioAdmDAO implements UsuarioAdminDAOIF ,UsuarioDAOIF{

    public UsuarioAdmDAO() {
    }
    

    @Override
    public boolean addUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscaTotosUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> buscaPorPalavraChave(String palavra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizarParaAdministrador(Usuario u) {
          boolean result = false;
        PreparedStatement pst = null;
        ConexaoIF conn = null;

        try {

            conn = new Conexao();
            String sql = "UPDATE Usuario SET papel = ? WHERE email = '" + u.getEmail() + "'";
                   
            pst = conn.getConnection().prepareStatement(sql);
            
            pst.setString(1, PapelUser.ADMISTRAD0R.name());
           
            
            if (pst.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Erro " + e.getMessage());
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
     return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().editarPirfio(usuario);
    }

    @Override
    public Usuario buscaPorEmail(String email) {
       return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorEmail(email);
    }

    @Override
    public Usuario buscaPorNome(String nome) {
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorNome(nome);
    }

    @Override
    public boolean editarPirfio(Usuario usuario) {
        return editarUsuario(usuario);
    }

    @Override
    public Usuario login(String nomeOuEmail, String senha) {
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().login(nomeOuEmail, senha);
    }

    @Override
    public boolean alterarSenha(Usuario u) {
        return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().alterarSenha(u);
    }
    
}
