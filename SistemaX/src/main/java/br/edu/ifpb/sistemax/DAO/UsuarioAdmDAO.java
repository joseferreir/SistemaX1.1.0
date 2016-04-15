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
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class UsuarioAdmDAO implements UsuarioAdminDAOIF, UsuarioDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String operacao;

    public UsuarioAdmDAO() {
    }

    // certo

    @Override
    public boolean addUsuario(Usuario usuario) {
        boolean result = false;
        try {
            conn = new Conexao();
            operacao = "INSERT INTO usuario (matricula , nomeUsuario, email, senha ,foto, papel)"
                    + "VALUES(?, ?, ?, ? ,? ,?) ";
            pst = conn.getConnection().prepareStatement(operacao);

            pst.setString(1, usuario.getMatricula());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getFoto());
            pst.setString(6, String.valueOf(usuario.getPapel()));
            if (pst.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    //c

    @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            operacao = "DELETE FROM Usuario WHERE id = ?";
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(operacao);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

    //c

    @Override
    public List<Usuario> buscaTotosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = new Conexao();
            operacao = "SELECT * FROM usuario";
            pst = conn.getConnection().prepareStatement(operacao);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuarios.add(montarUsuario(rs));

            }

        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }

    //c

    @Override
    public List<Usuario> buscaPorPalavraChave(String palavra) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = new Conexao();
            operacao = "SELECT * FROM Usuario WHERE nomeUsuario LIKE ?";
            pst = conn.getConnection().prepareStatement(operacao);
            pst.setString(1, palavra);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuarios.add(montarUsuario(rs));

            }

        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
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

            pst.setString(1, PapelUser.Administrador.name());

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

    //===========================================
    @Override
    public List<Usuario> buscarAtributos(Map<String, String> map) {
              return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscarAtributos(map);
          }

    //============================================
    public List<Usuario> buscarAtributosNaoExatos(Map<String, String> map) {
     return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscarAtributosNaoExatos(map);
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

    private Usuario montarUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(Integer.parseInt(rs.getString("id")));
        u.setMatricula(rs.getString("matricula"));
        u.setNome(rs.getString("nomeUsuario"));
        u.setEmail(rs.getString("email"));
        u.setFoto(rs.getString("foto"));
        u.setPapel(PapelUser.valueOf(rs.getString("papel")));
        u.setSenha(rs.getString("senha"));
        u.setStatus(rs.getBoolean("status"));
        return u;
    }

    @Override
    public Usuario buscaPorId(int idUsuario) {
         return Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorId(idUsuario);
    }

  

}
