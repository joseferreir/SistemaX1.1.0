/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.EventoAlterarBO;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class EventoAlterar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("user");
        if (usuario.getPapel() == PapelUser.Aluno) {
            try {
                response.sendRedirect("pagina");

                response.setContentType("text/html;charset=UTF-8");
                Evento eventoOriginal = (Evento) request.getAttribute("evento");
                eventoOriginal = atualizarEvento(request, eventoOriginal);
                EventoAlterarBO alterar = new EventoAlterarBO();
                Map<String, String> result = alterar.alterarEvento(eventoOriginal);
                if (result.get("passou").equals("true")) {
                    request.getSession().setAttribute("errosNaAtulizacao", result);
                    result.put("resultado", "Evento atualizado");
                }
                String json = new Gson().toJson(result);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
            } catch (IOException ex) {
                Logger.getLogger(EventoAlterar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Evento atualizarEvento(HttpServletRequest request, Evento e) {
        e.setNome(request.getParameter("nome"));
        e.setDescricao(request.getParameter("descricao"));
        e.setResponsavel(request.getParameter("responsavel"));
        e.setNumParticipantes(Integer.parseInt("numeroParticipantes"));
        e.setDataInicio(Timestamp.valueOf(request.getParameter("dataInicio")));
        e.setDataTermino(Timestamp.valueOf(request.getParameter("dataInicio")));
        return e;
    }

}
