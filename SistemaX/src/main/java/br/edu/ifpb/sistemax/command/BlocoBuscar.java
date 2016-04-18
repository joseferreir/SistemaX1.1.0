/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Bloco;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class BlocoBuscar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String busca = request.getParameter("busca");
        int id = Integer.parseInt(busca);
        Bloco bloco;

        if (busca != null && !busca.trim().isEmpty()) {
            bloco = Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarPorNome(busca);
            request.getSession().setAttribute("bloco", bloco);
        }
        if (id > 0) {
            bloco = Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarPorId(id);
            request.getSession().setAttribute("bloco", bloco);
        }
        if (busca.equalsIgnoreCase("todos")) {
            List<Bloco> blocos = Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarTodos();
            request.getSession().setAttribute("blocos", blocos);
        }

    }

}
