/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.facade.FadadeUsuario;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class CadastrarUsuario implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = montarUsuario(request);
        FadadeUsuario facade =  FadadeUsuario.getInstancia();
        try {
            Map<String, String> result = facade.cadastrarUsuario(usuario);
            if(result.get("passou").equalsIgnoreCase("true")){
                request.setAttribute("cadastrou", true);
            request.getRequestDispatcher(usuario.getPapel().name());
            }else{
                request.setAttribute("cadastrou", false);
                 request.getRequestDispatcher(usuario.getPapel().ADMISTRAD0R.name());
            }
        } catch (EmailExistenteException |NomeUsuarioExistenteException  ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private Usuario montarUsuario(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
