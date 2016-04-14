/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO.sala;

import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Sala;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluísio
 */
public class SalaDAO implements SalaDAOIF {

    private ConexaoIF conexao;
    private PreparedStatement pst = null;
    private String sql;

    public SalaDAO() {

    }

    @Override
    public boolean addSala(Sala sala) {
        boolean resultado = false;
        try {
            conexao = new Conexao();
            sql = "INSERT INTO sala (nome, idBloco, capacidade, estado, tipo)" + "VALUES(?,?,?,?,?)";
            pst = conexao.getConnection().prepareStatement(sql);
            pst.setString(1, sala.getNome());
            pst.setInt(2, sala.getIdBloco());
            pst.setInt(3, sala.getCapacidade());
            pst.setInt(4, sala.getEstado());
            pst.setInt(5, sala.getTipo());
            if (pst.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println("ERRO!" + e);

        } finally {
            try {
                conexao.closeAll(pst);
            } catch (DataBaseException ex) {
                System.err.println("ERRO!" + ex);
            }

        }
        return resultado;

    }

    @Override
    public boolean atualizarSala(Sala sala) {
            boolean resultado = false;
        try {
            conexao = new Conexao();
            sql = "UPDATE sala SET nome=?, idBloco=?, capacidade=?, estado=?, tipo=? WHERE id=?";
            pst = conexao.getConnection().prepareStatement(sql);
            pst.setString(1, sala.getNome());
            pst.setInt(2, sala.getIdBloco());
            pst.setInt(3, sala.getCapacidade());
            pst.setInt(4, sala.getEstado());
            pst.setInt(5, sala.getTipo());
            pst.setInt(6, sala.getId());
            if (pst.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println("ERRO!" + e);

        } finally {
            try {
                conexao.closeAll(pst);
            } catch (DataBaseException ex) {
                System.err.println("ERRO!" + ex);
            }

        }
        return resultado;
        
        
    }

    @Override
    public boolean removerSala(int id) {
    boolean resultado = false;
        try {
            conexao = new Conexao();
            sql = "DELETE FROM sala WHERE id='"+id+"'";
            pst = conexao.getConnection().prepareStatement(sql);
            if (pst.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println("ERRO!" + e);
        } finally {
            try {
                conexao.closeAll(pst);
            } catch (DataBaseException ex) {
                System.err.println("ERRO!" + ex);
            }

        }
        return resultado;
    }

    @Override
    public Sala buscarSala(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
