/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.model.BlocoRemoverBO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class BlocoRemover implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int idBloco =Integer.parseInt( request.getParameter("id"));
        BlocoRemoverBO  remover = new BlocoRemoverBO();
        boolean result = remover.remover(idBloco);
        try {
            if(result)
                response.getWriter().print("true");
            else
                response.getWriter().print("false");
        } catch (Exception e) {
        }
    }
    
}
