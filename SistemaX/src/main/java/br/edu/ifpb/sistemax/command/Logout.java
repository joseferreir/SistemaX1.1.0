/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
public class Logout implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            session.invalidate();
             try {
                 request.getRequestDispatcher("index.html").forward(request, response);
             } catch (IOException ex) {
                 Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ServletException ex) {
                 Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
             }

        }

    }
    
}
