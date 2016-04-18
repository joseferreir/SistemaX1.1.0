/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Bloco;
import br.edu.ifpb.sistemax.model.BlocoAlterarBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class BlocoAltera implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Bloco blocoOriginal = (Bloco) request.getSession().getAttribute("blogo");
            String nome = request.getParameter("nome");
            blocoOriginal.setNome(nome);
            BlocoAlterarBO alterar = new BlocoAlterarBO();
            if (alterar.alterar(blocoOriginal)) {
                response.getWriter().print("true");
            } else {
                response.getWriter().print("true");
            }
        } catch (IOException ex) {
            Logger.getLogger(BlocoAltera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
