/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.model.EventoBuscarBO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class EventoBuscar implements Command {
private EventoBuscarBO busca = new EventoBuscarBO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String nomeEvento = request.getParameter("nomeEvento");
        
        int nomeResponsavel =Integer.parseInt( request.getParameter("nomeResponsavel"));
        
        int idEvento = Integer.parseInt(request.getParameter("idEvento"));
        
        int idSala = Integer.parseInt(request.getParameter("idSala"));
        
        if (nomeEvento != null) {
            
            Evento evento = busca.buscaPorNome(nomeEvento);
            request.getSession().setAttribute("evento", evento);
        }
        if (idEvento > 0) {
            Evento evento = busca.buscaPorId(idEvento);
            request.getSession().setAttribute("evento", evento);
        }
        if (idSala > 0) {
            List<Evento> evento = busca.buscaPorSala(idSala);
            request.getSession().setAttribute("listaevento", evento);
        }
             if (nomeResponsavel >0) {
            
                Evento evnto = busca.buscaPorReponsavel(nomeResponsavel);
            request.getSession().setAttribute("evento", evnto);
        }
        
    }

}
