/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.model.EventoCadastrarBO;
import java.sql.Timestamp;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class EventoCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {

            EventoCadastrarBO cadastrar = new EventoCadastrarBO();
            Evento evento = montarEvento(request);
            Map<String, String> result = cadastrar.cadastrarEvento(evento);
            if (result.get("passou").equals("true")) {
                request.getSession().setAttribute("evento", evento);
                response.getWriter().print("true");
            }
             request.setAttribute("erros", result);
            response.getWriter().print("false");

        } catch (Exception e) {
        }

    }

    private Evento montarEvento(HttpServletRequest request) {
        Evento e = new Evento();
        e.setNome(request.getParameter("nome"));
        e.setDescricao(request.getParameter("descricao"));
        e.setResponsavel(request.getParameter("responsavel"));
        e.setNumParticipantes(Integer.parseInt("numeroParticipantes"));
        e.setDataInicio(Timestamp.valueOf(request.getParameter("dataInicio")));
        e.setDataTermino(Timestamp.valueOf(request.getParameter("dataInicio")));
        return e;
    }

}
