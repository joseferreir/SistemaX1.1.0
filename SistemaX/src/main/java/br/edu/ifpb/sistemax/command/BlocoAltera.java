/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Bloco;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.BlocoAlterarBO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class BlocoAltera implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            Map<String, String> resultado = new HashMap<>();
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
                Bloco blocoOriginal = (Bloco) request.getSession().getAttribute("blogo");

                String nome = request.getParameter("nome");
                blocoOriginal.setNome(nome);
                BlocoAlterarBO alterar = new BlocoAlterarBO();
                if (alterar.alterar(blocoOriginal)) {
                    resultado.put("resultado", "Bloco atualizado");
                } else {
                    resultado.put("resultado", "erro");
                }
            }
            String json = new Gson().toJson(resultado);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(BlocoAltera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
