package br.edu.ifpb.sistemax.command;


import br.edu.ifpb.sistemax.command.Command;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.model.SalaBuscarBO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluísio
 */
public class SalaBuscar implements Command{
    private SalaBuscarBO buscarSalas;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         try {
          response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
           Sala  sala = buscaPorId(request);
           
           if(sala!= null){
               request.getSession().setAttribute("sala", sala);
           
           }
           else{ 
               request.setAttribute("erro", "não encotramos uma sala que corresponda a estes parametros");
      
          }    
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SalaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SalaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Sala buscaPorId(HttpServletRequest request) {
        int idSala = Integer.parseInt(request.getParameter("qId"));
        if(buscarSalas == null)
         buscarSalas = new SalaBuscarBO();
        return buscarSalas.buscarSala(idSala);
    }

   
    
}
