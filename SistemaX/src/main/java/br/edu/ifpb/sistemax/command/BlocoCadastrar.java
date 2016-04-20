/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Bloco;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.model.BlocoCadastrarBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 */
public class BlocoCadastrar implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> resultado = new HashMap<>();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            if (usuario.getPapel() != PapelUser.Administrador || usuario.getPapel() != PapelUser.AssistenteDeSala) {
                response.sendRedirect("pagina");
                String nome = request.getParameter("nome");
                if (nome.trim().isEmpty()) {
                    resultado.put("nome", "Infome o nome do bloco");
                }
                Bloco bloco = new Bloco();
                bloco.setNome(nome);
                BlocoCadastrarBO cadastrar = new BlocoCadastrarBO();
                boolean result = cadastrar.cadastrar(bloco);
                if (result) {
                    resultado.put("resultado", "bloco cadastrado");
                }

            }

            String json = new Gson().toJson(resultado);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(BlocoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
