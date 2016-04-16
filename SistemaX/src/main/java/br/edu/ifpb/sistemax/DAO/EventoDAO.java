/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.conexao.*;
import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.EstadoEvento;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.sistemax.enuns.EstadoEvento;

/**
 *
 * @author José
 */
public class EventoDAO implements EventoDAOIF {

    private ConexaoIF conn;
    private PreparedStatement pst = null;
    private String sql;
    private final int addEvento = 0;
    private final int setEvento = 1;

    /**
     *
     * @param evento objeto do tipo evento que devera ser persistido
     *
     * @return boolean valor true se a operaçáo for bem sucedida caso contrario
     * retorna false
     */
    @Override
    public boolean add(Evento evento) {
        sql = "INSERT INTO Evento (nome , descricao,  numeroParticipantes,  idResponsavel , dataInicio,  dataTermino)"
                + "VALUES(?, ?, ?, ? ,? ,?) ";
        return persinteNoBD(evento, sql, addEvento);

    }

    @Override
    public boolean Alterar(Evento evento) {
        sql = "UPDATE Evento SET nome=?, descricao=?,  numeroParticipantes=?,  idResponsavel=? , dataInicio=?,  dataTermino=?,estado=? WHERE id=?";
        return persinteNoBD(evento, sql, setEvento);
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;
        try {
            sql = "DELETE FROM Evento WHERE id = '" + id + "'";
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
    public Evento buscaPorId(int id) {
        sql = "SELECT * FROM Evento WHERE id='" + id + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public Evento buscaPorNome(String nome) {
        sql = "SELECT * FROM Evento WHERE nome='" + nome + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public Evento buscaPorReponsavel(int idResponsavel) {
        sql = "SELECT * FROM Evento WHERE idResponsavel='" + idResponsavel + "'";
        return bucarNoBD(sql).get(0);
    }

    @Override
    public List<Evento> buscaPorSala(int idSala) {
        sql = "SELECT * FROM Evento ,alocacao al WHERE al.idSala='" + idSala + "' AND evento.id=al.idEvento ";
        return bucarNoBD(sql);
    }

    private boolean persinteNoBD(Evento evento, String sql, int operacao) {
        boolean result = false;
        try {
            conn = new Conexao();

            pst = conn.getConnection().prepareStatement(sql);

            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getDescricao());
            pst.setInt(3, evento.getNumParticipantes());
            Usuario responsavel = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorNome(evento.getResponsavel());
            pst.setInt(4, responsavel.getId());
            pst.setTimestamp(5, evento.getDataInicio());
            pst.setTimestamp(6, evento.getDataTermino());
            pst.setInt(7, EstadoEvento.valueOf(evento.getEstado().getClass().getSimpleName()).id);
            if (operacao == setEvento) {
                pst.setInt(8, evento.getId());
            }
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

    private List<Evento> bucarNoBD(String sql) {
        List<Evento> eventos = new ArrayList<>();
        try {
            conn = new Conexao();
            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                eventos.add(montarEvento(rs));

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
        return eventos;
    }

    private Evento montarEvento(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setId(rs.getInt("id"));
        e.setNome(rs.getString("nome"));
        e.setDescricao(rs.getString("descricao"));
        e.setDataInicio(rs.getTimestamp("dataInicio"));
        e.setDataTermino(rs.getTimestamp("dataTermino"));
        Usuario responsavel = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorId(rs.getInt("idResponsavel"));
        e.setResponsavel(responsavel.getNome());
        e.setNumParticipantes(rs.getInt("numeroParticipantes"));
        int op = rs.getInt("estado");

        switch (op) {
            
            case 2:
                e.agardando();
                System.err.println("eeeee" +op);
                break;
            case 3:
                e.emAndatento();
                break;
            default:
                e.pendente();

        }
        return e;

    }

}
