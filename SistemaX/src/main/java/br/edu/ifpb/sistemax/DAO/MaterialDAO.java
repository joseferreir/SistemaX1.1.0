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
import br.edu.ifpb.sistemax.entidades.Material;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.enuns.EstadoMaterial;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.internal.core.helper.CoreClassConstants;

/**
 *
 * @author José
 */
public class MaterialDAO implements MaterialDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addMaterial = 0;
    private final int setMaterial = 1;

    public MaterialDAO() {
        try {
            this.conn = new Conexao();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean add(Material material, int quantidade) {
        boolean result = true;
        sql = "INSERT INTO Material(descricao, tombamento) VALUES(?, nextval('numerosTombamento'))";
        try {
            while (quantidade > 0 && result) {
                pst = conn.getConnection().prepareCall(sql);
                pst.setString(1, material.getDescricao());
                if (pst.executeUpdate() > 0) {
                    result = true;
                } else {
                    result = false;
                }
                quantidade--;

            }
        } catch (Exception e) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public boolean alterar(Material material) {
        boolean result = true;
        sql = "UPDATE Material SET descricao=?,estado=?,local=? WHERE tombamento=?";
        try {
            pst = conn.getConnection().prepareCall(sql);
            pst.setString(1, material.getDescricao());
            pst.setInt(2, EstadoMaterial.valueOf(material.getEstado().getClass().getSimpleName()).id);
            pst.setInt(3, material.getLocal().getId());
            pst.setInt(4, (int) material.getTombamento());
            if (pst.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

    @Override
    public boolean remover(long tombamento) {
        boolean result = false;
        try {
            sql = "DELETE FROM material WHERE tombamento = '" + tombamento + "'";
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
    public Material busvarPorTombamento(long tombamento) {
        sql = "SELECT * FROM Material WHERE tombamento = '" + tombamento + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public List<Material> busvarTodos() {
        sql = "SELECT * FROM Material";
        return bucarNoBD(sql);
    }

    @Override
    public Material busvarPorDescricao(String descricao) {
        sql = "SELECT * FROM Material WHERE descricao='" + descricao + "'";
        return bucarNoBD(sql).get(0);
    }

    private List<Material> bucarNoBD(String sql) {
        List<Material> eventos = new ArrayList<>();
        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                eventos.add(montarMaterial(rs));

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
        if (!eventos.isEmpty()) {
            return eventos;
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Material> buscarAtributos(Map<String, String> map) {
        List<Material> materiais = new ArrayList<>();
        try {

            StringBuilder sqlq = new StringBuilder("SELECT * FROM Material WHERE ");

            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();

            String key;
            while (it.hasNext()) {
                key = it.next();
                sqlq.append(key);
                sqlq.append(" = ");
                sqlq.append("'").append(map.get(key)).append("'");
                if (it.hasNext()) {
                    sqlq.append(" AND ");
                }
            }

            pst = conn.getConnection().prepareStatement(sqlq.toString());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Material bloco = montarMaterial(rs);

                materiais.add(bloco);
            }

        } catch (SQLException ex) {

        } finally {
            try {
                conn.closeAll(pst);
            } catch (DataBaseException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return materiais;
    }

    private Material montarMaterial(ResultSet rs) throws SQLException {
        Material material = new Material();
        material.setTombamento(rs.getLong("tombamento"));
        material.setDescricao(rs.getString("descricao"));
        Sala sala = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarSala(rs.getInt("local"));
        System.err.println("estado ss " + rs.getInt("estado"));
        if (rs.getInt("estado") == 1) {
            material.disponivel();
        } else {
            material.emprestado();
        }
        material.setLocal(sala);
        return material;
    }

    @Override
    public List<Material> buscarDsponivel() {
        String sql = "SELECT * FROM Material WHERE local is null";
        return bucarNoBD(sql);
    }

}
