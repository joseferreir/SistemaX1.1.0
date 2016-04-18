/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Bloco;
import br.edu.ifpb.sistemax.model.BlocoCadastrarBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class BlocoCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String nome = request.getParameter("nome");
            Bloco bloco = new Bloco();
            bloco.setNome(nome);
            BlocoCadastrarBO cadastrar = new BlocoCadastrarBO();
            boolean result = cadastrar.cadastrar(bloco);
            if (result) {
                response.getWriter().print("false");
            } else {
                response.getWriter().print("true");
            }
        } catch (IOException ex) {
            Logger.getLogger(BlocoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
