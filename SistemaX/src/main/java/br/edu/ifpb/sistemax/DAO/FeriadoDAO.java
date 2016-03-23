/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.conexao.Conexao;
import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Feriado;
import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class FeriadoDAO implements FeriadoDAOIF {

    ConexaoIF conn = null;
    PreparedStatement ps;
    String sql;

    public FeriadoDAO() {
    }

    @Override
    public boolean adiciona(Feriado feriado) {

        boolean resul = false;
        sql = "INSERT INTO Feriado (data,nome)"
                + "VALUES (?, ?)";
        try {

            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(feriado.getData()));
            ps.setString(2, feriado.getNome());
            if (ps.executeUpdate() > 1);
            resul = true;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resul;
    }

    @Override
    public boolean edita(Feriado feriado) {
        boolean result = false;
        sql = "UPDATE Feriado SET data = ?, nome = ? "
                + "WHERE id = ?";
        try {
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(feriado.getData()));
            ps.setString(2, feriado.getNome());
            ps.setInt(3, feriado.getId());
            if (ps.executeUpdate() > 1);
            result = true;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

    @Override
    public Feriado buscarPorNome(String nome) {

        sql = "SELECT * FROM Feriado WHERE nome =?";
        try {
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return montarFeriado(rs);
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public List<Feriado> buscarTodos() {
        sql = "SELECT * FROM Feriado ";
        List<Feriado> feriados = new ArrayList<>();
        try {
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                feriados.add(montarFeriado(rs));
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return feriados;
    }

    @Override
    public Feriado busbarPorData(LocalDate data){
          sql = "SELECT * FROM Feriado WHERE nome =?";
        try {
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(data));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return montarFeriado(rs);
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    @Override
    public boolean remover(String nome) {
        boolean result = false;
        try {
            sql = "DELETE FROM Feriado WHERE nome =?";
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public boolean removerData(LocalDate data) {
        boolean result = false;
        try {
            sql = "DELETE FROM Feriado WHERE data =?";
            if (conn == null) {
                conn = new Conexao();
            }
            ps = conn.getConnection().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(data));
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public List<Feriado> buscarAtributos(Map<String, String> map) {
        try {

            if (conn == null) {
                conn = new Conexao();
            }

            StringBuilder sql = new StringBuilder("SELECT * FROM feriado WHERE ");

            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();

            String chave;
            while (it.hasNext()) {
                chave = it.next();
                sql.append(chave);
                sql.append(" = ");
                sql.append("'").append(map.get(chave)).append("'");
                if (it.hasNext()) {
                    sql.append(" AND ");
                }
            }
            PreparedStatement ps = conn.getConnection().prepareStatement(sql.toString());

            ResultSet rs = ps.executeQuery();
            List<Feriado> feriados = new ArrayList<>();

            while (rs.next()) {
                feriados.add(montarFeriado(rs));
            }

            return feriados;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();

            return null;
        } finally {
            try {
                conn.closeAll(ps);
            } catch (DataBaseException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public List<Feriado> buscarAtributosNaoExatos(Map<String, String> map) {
        StringBuilder sql = null;
        try {

            if (conn == null) {
                conn = new Conexao();
            }

            sql = new StringBuilder("SELECT * FROM feriado WHERE ");

            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();

            String chave;
            while (it.hasNext()) {
                chave = it.next();
                sql.append(chave);
                sql.append(" ilike ");
                sql.append("'%").append(map.get(chave)).append("%'");
                if (it.hasNext()) {
                    sql.append(" AND ");
                }
            }

            PreparedStatement ps = conn.getConnection().prepareStatement(sql.toString());

            ResultSet rs = ps.executeQuery();
            List<Feriado> feriados = new ArrayList<>();

            while (rs.next()) {
                Feriado feriado = montarFeriado(rs);

                feriados.add(feriado);
            }

            return feriados;
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Feriado montarFeriado(ResultSet rs) throws SQLException {
        Feriado f = new Feriado();
        f.setId(rs.getInt("id"));
        f.setNome(rs.getString("nome"));
        f.setData(rs.getDate("data").toLocalDate());
        return f;
    }

}
