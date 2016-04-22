/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.conexao.*;
import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.EventoDTO;
import br.edu.ifpb.sistemax.entidades.Material;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpb.sistemax.enuns.EstadoEvento;
import br.edu.ifpb.sistemax.enuns.EstadoMaterial;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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

    public EventoDAO() throws SQLException, IOException, ClassNotFoundException {
        conn = new Conexao();
    }
    

    /**
     *
     * @param evento objeto do tipo evento que devera ser persistido
     *
     * @return boolean valor true se a operaçáo for bem sucedida caso contrario
     * retorna false
     */
    @Override
    public boolean add(Evento evento) {
        sql = "INSERT INTO Evento (nome , descricao,  numeroParticipantes,  idResponsavel , dataInicio,  dataTermino, estado)"
                + "VALUES(?, ?, ?, ? ,? ,?, ?) ";
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
            
            pst = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                eventos.add(montarEvento(rs));
                
            }
            
        } catch (SQLException e) {
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
        System.err.println("di " + e.getId());
        e.setNome(rs.getString("nome"));
        e.setDescricao(rs.getString("descricao"));
        e.setDataInicio(rs.getTimestamp("dataInicio"));
        e.setDataTermino(rs.getTimestamp("dataTermino"));
        Usuario responsavel = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioDAO().buscaPorId(rs.getInt("idResponsavel"));
        e.setResponsavel(responsavel.getNome());
        e.setNumParticipantes(rs.getInt("numeroParticipantes"));
        int op = rs.getInt("estado");
        
        switch (op) {
            case 1: {
                e.pendente();
                break;
            }
            case 2: {
                e.agardando();
                System.err.println("eeeee" + op);
                break;
            }
            case 3: {
                e.emAndatento();
                break;
            }
            
        }
        return e;
        
    }
// metodo com erro
    public List<EventoDTO> listarNaoFinalizados() throws DataBaseException {
        
        try {
            
            String agora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
            System.out.println(agora + " ");
//            String sql = "SELECT e.id, e.dataInicio, e.dataTermino, e.nome as nomeEvento, s.nome as nomeSala FROM Evento e, Sala s,alocacao al WHERE data_termino > '" + agora + "' AND al.idsala = s.id";
            String sql = "SELECT e.id, e.dataInicio, e.dataTermino, e.nome as nomeEvento, al.idsala as idSala FROM Evento e, alocacao al WHERE dataTermino > '" + agora + "' AND al.idsala=alocacao.idsala";
            
            PreparedStatement pst = conn.getConnection().prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            List<EventoDTO> eventos = new ArrayList<>();
            
            while (rs.next()) {
                EventoDTO e = preencherEventoDTO(rs);
                eventos.add(e);
            }
            
            return eventos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            conn.closeAll(pst);
        }
    }
    // metodo com erro
    public List<EventoDTO> listarEventosDTO() throws DataBaseException {
        List<EventoDTO> eventos = new ArrayList<>();
        try {
            
            String sql = "SELECT e.id, e.dataInicio, e.dataTermino, e.nome as nomeEvento, a.idsala as local FROM Evento e, Alocacao  a WHERE a.idsala= alocacao.idsala";
            
             pst = conn.getConnection().prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
           
            while (rs.next()) {
                EventoDTO e = preencherEventoDTO(rs);
                eventos.add(e);
            }
            
            return eventos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            conn.closeAll(pst);
        }
            return eventos;
    }
    
    private EventoDTO preencherEventoDTO(ResultSet rs) throws SQLException, SQLException {
        EventoDTO eData = null;
        
        try {
            
            eData = new EventoDTO();
            
            eData.setId(rs.getInt("id"));
            eData.setNome(rs.getString("nomeEvento"));
            
            int idSala = rs.getInt("local");
            
            if (idSala == 0) {
                eData.setLocal("--");
            } else {
                
                Sala s = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarSala(idSala);
                eData.setLocal(s.getNome());
            }
            
            Timestamp dataInicio = rs.getTimestamp("dataInicio");
            Timestamp dataFim = rs.getTimestamp("dataTermino");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            eData.setData(sdf.format(dataInicio));
            
            Duration diff2 = Duration.between(dataInicio.toLocalDateTime(), dataFim.toLocalDateTime());
            
            long horas = diff2.getSeconds() / 3600;
            long minutos = (diff2.getSeconds() - (3600 * horas)) / 60;
            eData.setDuracao(String.format("%dh%02d", horas, minutos));
            
            String situacao = null;
            Timestamp agora = Timestamp.from(Instant.now());
            
            if (dataInicio.after(agora)) {
                if (eData.getLocal().equals("--")) {
                    situacao = "Pendente de Alocação";
                } else {
                    situacao = "Agendado";
                }
            } else {
                if (dataFim.after(agora)) {
                    situacao = "Em andamento";
                } else { //aqui colocar um else e consultar se tem materiais ainda não baixados desse evento
                    Map<String, String> parametros = new HashMap<>();
                    final Map<String, String> parametros1 = parametros;
                    parametros.put("local", Integer.toString(idSala));
                    parametros1.put("estado", Integer.toString(EstadoMaterial.MaterialEmprestado.id));
                    MaterialDAOIF dmat = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO();
                    List<Material> naoBaixados = dmat.buscarAtributos(parametros1);
                    
                    if (naoBaixados.size() != 0) {
                        situacao = "Concluído com pendência";
                    } else {
                        situacao = "Concluído";
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eData;
    }
}
