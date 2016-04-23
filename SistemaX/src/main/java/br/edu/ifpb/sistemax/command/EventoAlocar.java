/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.EventoCadastrarBO;
import br.edu.ifpb.sistemax.model.EventoValidarAlocarBO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author José
 */
public class EventoAlocar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() == PapelUser.Aluno) {
                response.sendRedirect("pagina");
            }
            String Evento = request.getParameter("evento");
            String sala = request.getParameter("sala");

            if (Evento != null && sala != null) {
                Evento e = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO().buscaPorId(Integer.parseInt(Evento));
                Sala s = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarSala(Integer.parseInt(sala));
                EventoCadastrarBO alocar = new EventoCadastrarBO();
                e.setSala(s);
                Map<String, String> result = alocar.cadastrarEvento(e);
                String json = new Gson().toJson(result);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

            }
        } catch (Exception e) {
            System.err.println("Erro " + e);

        }
    }

}
