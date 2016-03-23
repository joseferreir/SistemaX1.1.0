
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpb.sistemax.model.LoginBO;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
public class Logar implements Command {

    public Logar() {
    }
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        LoginBO loga = new LoginBO();
        Usuario usuario = loga.loga(login, senha);
        try {
            if (usuario != null) {

                HttpSession session = request.getSession();
                session.setAttribute("user", usuario);
                RequestDispatcher des = request.getServletContext().getRequestDispatcher("/"+usuario.getPapel().name()+".jsp");
                des.forward(request, response);
                        

            } else {
                request.setAttribute("logado", false);
                 RequestDispatcher des = request.getServletContext().getRequestDispatcher("/index.html");
                des.forward(request, response);
            }
        } catch (IOException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
