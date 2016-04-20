package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.model.SalaCadastrarBO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluísio
 */
public class SalaCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            SalaCadastrarBO cadastrar = new SalaCadastrarBO();
            Sala sala = montarSala(request);
            Map<String, String> result = cadastrar.cadastrat(sala);
            if (result.get("passou").equals("true")) {
                request.getSession().setAttribute("sala", sala);
                response.getWriter().print("true");
            }
            request.setAttribute("errosSala", result);
            response.getWriter().print("false");

        } catch (Exception e) {
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
