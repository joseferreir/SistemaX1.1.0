/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.command.Command;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class UsuarioBuscar implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
          response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
