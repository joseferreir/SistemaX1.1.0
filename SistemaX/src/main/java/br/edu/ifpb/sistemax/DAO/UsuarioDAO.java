/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class UsuarioDAO implements UsuarioDAOIF {

    ConexaoIF conn;

    public UsuarioDAO() {
    }

    @Override
    public boolean editarPirfio(Usuario usuario) {
        boolean result = false;
        PreparedStatement pst = null;
        ConexaoIF conn = null;

        try {

            conn = new Conexao();
            String sql = "UPDATE Usuario SET matricula = ?, nomeUsuario = ?, email = ?, senha = ?,foto = ?"
                    + "WHERE id = ?";
            pst = conn.getConnection().prepareStatement(sql);
            pst.setString(1, usuario.getMatricula());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getFoto());
            pst.setInt(6, usuario.getId());
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
    public Usuario login(String nomeOuEmail, String senha) {
        boolean result = false;
        PreparedStatement pst = null;
        ConexaoIF conn = null;
        try {
            if (nomeOuEmail.contains("@")) {
                Usuario u = this.buscaPorEmail(nomeOuEmail);
                if (u != null) {
                    if (u.getSenha().equals(senha)) {
                        return u;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }

            } else {
                Usuario u = this.buscaPorNome(nomeOuEmail);
                if (u != null) {
                    if (u.getSenha().equals(senha)) {
                        return u;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }

        } finally {
           
        }
    }

    @Override
    public boolean alterarSenha(Usuario u) {
         boolean result = false;
        PreparedStatement pst = null;
        ConexaoIF conn = null;

        try {

            conn = new Conexao();
            String sql = "UPDATE Usuario SET senha = ? WHERE email = '" + u.getEmail() + "'";
                   
            pst = conn.getConnection().prepareStatement(sql);
            
            pst.setString(1, u.getSenha());
           
            
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
    public Usuario buscaPorEmail(String email) {
        Usuario resultado = null;

        try {
            conn = new Conexao();
            String consulta = "SELECT * FROM Usuario WHERE email = '" + email + "'";
            PreparedStatement ps = conn.getConnection().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resultado = montarUsuario(rs);
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    @Override
    public Usuario buscaPorNome(String nome) {
        Usuario resultado = null;

        try {
            conn = new Conexao();
            String consulta = "SELECT * FROM Usuario WHERE nomeusuario = '" + nome + "'";
            PreparedStatement ps = conn.getConnection().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resultado = montarUsuario(rs);
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    private Usuario montarUsuario(ResultSet rs) throws SQLException {
        Usuario us = new Usuario();
        us.setId(rs.getInt("id"));
        us.setMatricula(rs.getString("matricula"));
        us.setNome(rs.getString("nomeUsuario"));
        us.setEmail(rs.getString("email"));
        us.setSenha(rs.getString("senha"));
        us.setFoto(rs.getString("foto"));
        us.setPapel(PapelUser.valueOf(rs.getString("papel")));
        return us;

    }

}
