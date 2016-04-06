/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;
import br.edu.ifpb.sistemax.model.RemoverUsuarioBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class UsuarioRemover implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            RemoverUsuarioBO remover = new RemoverUsuarioBO();
            boolean result = remover.remover(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("removeu", result);
            RequestDispatcher des = request.getServletContext().getRequestDispatcher("/Administrador.jsp");
            des.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(UsuarioRemover.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioRemover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
