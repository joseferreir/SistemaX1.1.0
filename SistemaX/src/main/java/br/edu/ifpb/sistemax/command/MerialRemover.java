/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.MaterialRemoveBO;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class MerialRemover implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
                MaterialRemoveBO remove = new MaterialRemoveBO();
                Map<String, String> result = new HashMap<>();
                if (remove.remover(Integer.parseInt(request.getParameter("tombamento")))) {
                    result.put("resultado", "Material removido");
                }
                String json = new Gson().toJson(result);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
            }
        } catch (Exception e) {
        }
    }

}
