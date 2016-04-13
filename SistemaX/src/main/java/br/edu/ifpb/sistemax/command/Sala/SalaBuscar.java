package br.edu.ifpb.sistemax.command.Sala;


import br.edu.ifpb.sistemax.command.Command;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluísio
 */
public class SalaBuscar implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
          response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SalaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
