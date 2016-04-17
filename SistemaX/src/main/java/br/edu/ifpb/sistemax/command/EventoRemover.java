/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.model.EventoRemoveBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class EventoRemover implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
        int idEvento = Integer.parseInt(request.getParameter("idEvento"));
         EventoRemoveBO remover = new  EventoRemoveBO();
        boolean removeu = remover.removerEvento(idEvento);
        request.getSession().setAttribute("eventoRmovido",removeu);
        
            response.sendRedirect("pagina adequada");
        } catch (IOException ex) {
            Logger.getLogger(EventoRemover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
