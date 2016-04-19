/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.enuns.EstadoSala;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            pst.setInt(4, EstadoSala.valueOf(sala.getEstado().toString()).id);
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
            pst.setInt(4,  EstadoSala.valueOf(sala.getEstado().toString()).id);
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
            sql = "DELETE FROM sala WHERE id='" + id + "'";
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
        Sala resultado = null;

        try {
            conexao = new Conexao();
            String consulta = "SELECT * FROM sala WHERE id='" + id + "'";
            PreparedStatement ps = conexao.getConnection().prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resultado = montarSala(rs);
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }
       
    @Override
    public List<Sala> buscarAtributosNaoExatos(Map<String, String> map) {
        StringBuilder sql = null;
        try {
            ConexaoIF conexao = null;

            conexao = new Conexao();

            sql = new StringBuilder("SELECT * FROM sala WHERE ");

            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();

            String key;
            while (it.hasNext()) {
                key = it.next();
                sql.append(key);
                sql.append(" ilike ");
                sql.append("'%").append(map.get(key)).append("%'");
                if (it.hasNext()) {
                    sql.append(" AND ");
                }
            }

            PreparedStatement pst = conexao.getConnection().prepareStatement(sql.toString());

            ResultSet rs = pst.executeQuery();
            List<Sala> salas = new ArrayList<>();

            while (rs.next()) {
                Sala sala = montarSala(rs);

                salas.add(sala);
            }

            return salas;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private Sala montarSala(ResultSet rs) throws SQLException {
        Sala sala = new Sala();
        sala.setId(rs.getInt("id"));
        sala.setNome(rs.getString("nome"));
        sala.setIdBloco(rs.getInt("idBloco"));
        sala.setCapacidade(rs.getInt("capacidade"));
      if(EstadoSala.Disponivel.id==rs.getInt("estado"))
          sala.disponivel();
      else
          sala.indisponivel();
        sala.setTipo(rs.getInt("tipo"));
        return sala;
    }
}
