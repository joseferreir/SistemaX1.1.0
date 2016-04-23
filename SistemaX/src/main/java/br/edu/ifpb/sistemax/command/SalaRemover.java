/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.RemoverUsuarioBO;
import br.edu.ifpb.sistemax.model.SalaRemoverBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluísio
 */
public class SalaRemover implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            
              Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
            }
             SalaRemoverBO remover = new  SalaRemoverBO();
            boolean result = remover.remover(Integer.parseInt(request.getParameter("idSala")),usuario.getNome());
            request.setAttribute("removeu", result);
            RequestDispatcher des = request.getServletContext().getRequestDispatcher("/Administrador.jsp");
            des.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(SalaRemover.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SalaRemover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
