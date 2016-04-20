package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.SalaCadastrarBO;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author Aluísio
 */
public class SalaCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> result = null;
        response.setContentType("text/html;charset=UTF-8");
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador||usuario.getPapel()!=PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
            }

            request.setCharacterEncoding("UTF-8");
            SalaCadastrarBO cadastrar = new SalaCadastrarBO();
            Sala sala = montarSala(request);
            result = cadastrar.cadastrat(sala);
            if (result.get("passou").equals("true")) {
                result.put("resultado", "Cadastro bem sucedido");
                request.getSession().setAttribute("sala", sala);
               
            }

        } catch (Exception e) {
        }
        String json = new Gson().toJson(result);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(json);
        } catch (IOException ex) {
            Logger.getLogger(SalaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Sala montarSala(HttpServletRequest request) {
        Sala sala = new Sala();
        sala.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
        sala.setIdBloco(Integer.parseInt(request.getParameter("bloco")));
        sala.setTipo(Integer.parseInt(request.getParameter("tipo")));
        sala.setNome(request.getParameter("nome"));
        return sala;
    }

}
