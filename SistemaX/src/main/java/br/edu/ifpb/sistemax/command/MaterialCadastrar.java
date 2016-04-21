/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Material;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.MaterialCadastrarBO;
import com.google.gson.Gson;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class MaterialCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
             response.setContentType("text/html;charset=UTF-8");
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
            }

            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Material material = new Material();
            MaterialCadastrarBO cadastrar = new MaterialCadastrarBO();
            Map<String, String> result = cadastrar.cadastrar(material, quantidade);
            if (result.get("passou").equalsIgnoreCase("true")) {
                request.getSession().setAttribute("material", material);
                result.put("resultado", "material cadastrado");
            }
            String json = new Gson().toJson(result);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

        } catch (Exception e) {
        }

    }

}
