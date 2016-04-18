/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Bloco;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class BlocoDAO implements BlocoDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addBloco = 0;
    private final int setBloco = 1;

    @Override
    public boolean add(Bloco bloco) {
        sql = "INSERT INTO Bloco(nome) VALUES(?)";
        return persinteNoBD(bloco, sql, addBloco);
    }

    @Override
    public boolean alterar(Bloco bloco) {
        sql = "UPDATE Bloco SET nome=? WHERE id=?";
        return persinteNoBD(bloco, sql, setBloco);
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            sql = "DELETE FROM Bloco WHERE id = '" + id + "'";
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(sql);
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

    @Override
    public Bloco buscarPorId(int idBloco) {
        sql = "SELECT * FROM Bloco WHERE id='" + idBloco + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public Bloco buscarPorNome(String nomeBloco) {
        sql = "SELECT * FROM Bloco WHERE nome='" + nomeBloco + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public List<Bloco> buscarTodos() {
        sql = "SELECT * FROM Bloco";
        return bucarNoBD(sql);
    }

    private boolean persinteNoBD(Bloco bloco, String sql, int operacao) {
        boolean result = false;
        try {
            conn = new Conexao();

            pst = conn.getConnection().prepareStatement(sql);

            pst.setString(1, bloco.getNome());

            if (operacao == setBloco) {
                pst.setInt(2, bloco.getId());
            }
            if (pst.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException | ClassNotFoundException | IOException e) {
            Logger.getLogger(BlocoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(BlocoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

    private List<Bloco> bucarNoBD(String sql) {

        List<Bloco> blocos = new ArrayList<>();
        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                blocos.add(montarBloco(rs));
            }

        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(BlocoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(BlocoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return blocos;

    }

    private Bloco montarBloco(ResultSet rs) throws SQLException {
        Bloco bloco = new Bloco(rs.getInt("id"));
        
        bloco.setNome(rs.getString("nome"));
        return bloco;
    }

}
