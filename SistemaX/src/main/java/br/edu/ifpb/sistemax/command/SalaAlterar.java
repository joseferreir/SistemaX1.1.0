/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.model.SalaAlterarBO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class SalaAlterar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
             request.setCharacterEncoding("UTF-8");
            SalaAlterarBO alterar = new SalaAlterarBO();
            Sala Sala = (Sala) request.getSession().getAttribute("sala");
            Sala = atualizarSala(request, Sala);
            Map<String, String> result = alterar.alterar(Sala);
            if (result.get("passou").equals("true")) {
                request.getSession().setAttribute("sala", Sala);
                response.getWriter().print("true");
            }
            request.setAttribute("errosSala", result);
            response.getWriter().print("false");

        } catch (Exception e) {
        }

    }

    private Sala atualizarSala(HttpServletRequest request, Sala sala) {

        sala.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
        sala.setIdBloco(Integer.parseInt(request.getParameter("bloco")));
        sala.setTipo(Integer.parseInt(request.getParameter("tipo")));
        sala.setNome(request.getParameter("nome"));
        return sala;
    }
}
