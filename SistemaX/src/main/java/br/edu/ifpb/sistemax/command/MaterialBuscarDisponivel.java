/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Material;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class MaterialBuscarDisponivel implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("materialDisponinivel", request);
        response.setContentType("text/html;charset=UTF-8");
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() == PapelUser.Aluno) {
                response.sendRedirect("pagina");
            }
            List<Material> matDisponivel = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO().buscarDsponivel();
            request.getSession().setAttribute("materialDisponinivel", matDisponivel);
        } catch (Exception e) {

        }

    }

}
