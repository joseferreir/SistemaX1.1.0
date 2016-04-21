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
import br.edu.ifpb.sistemax.model.MaterialAlterarBO;
import com.google.gson.Gson;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class MaterialAlterar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
            }

            String descricao = request.getParameter("descricao");
            int tombamento = Integer.parseInt(request.getParameter("tombamento-editar"));
            Material material = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO().busvarPorTombamento(tombamento);
            MaterialAlterarBO atualizar = new MaterialAlterarBO();
            Map<String, String> result = atualizar.atualizar(material);
            if (result.get("passou").equalsIgnoreCase("true")) {
                //   request.getSession().setAttribute("material", material);
                result.put("resultado", "material atualizado");
            }
            String json = new Gson().toJson(result);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

        } catch (Exception e) {
        }

    }

}
