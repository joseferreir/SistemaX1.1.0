/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpb.sistemax.facade.FadadeUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
public class Logar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        FadadeUsuario facade = FadadeUsuario.getInstancia();
        Usuario usuario = facade.logar(login, senha);
        try {
            if (usuario != null) {

                HttpSession session = request.getSession();
                session.setAttribute("user", usuario);
                request.getRequestDispatcher(usuario.getPapel().Administrador.name() + ".jsp").forward(request, response);

            } else {
                request.setAttribute("logado", false);
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        } catch (IOException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
