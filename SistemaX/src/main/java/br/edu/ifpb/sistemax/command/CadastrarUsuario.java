/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.facade.FadadeUsuario;
import br.edu.ifpb.sistemax.model.ProcessadorFotos;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author José
 */
public class CadastrarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usuario = montarUsuario(request);
            FadadeUsuario facade = FadadeUsuario.getInstancia();
            boolean cadastrou = false;
            try {
                if(usuario != null){
                    Map<String, String> result = facade.cadastrarUsuario(usuario);
                    if (result.get("passou").equalsIgnoreCase("true")) {
                        cadastrou = true;
                    }
                }
                request.setAttribute("cadastrou", cadastrou);
                request.getRequestDispatcher(usuario.getPapel().Administrador.name()+".jsp").forward(request, response);
                
            } catch (EmailExistenteException | NomeUsuarioExistenteException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Usuario montarUsuario(HttpServletRequest request) throws IOException, ServletException {

          String nome = request.getParameter("name");
          String matricula = request.getParameter("matricula");
            String email = request.getParameter("email");
            String papel = request.getParameter("papel");
            String senha = request.getParameter("senha");
        boolean status = true;
        //processando e salvando a capa do livro
        Part fotoPart = request.getPart("foto");
        String nomeArquivo = fotoPart.getSubmittedFileName();
        if (nomeArquivo == null || nomeArquivo == "")
            nomeArquivo = "img/pefUsuer/reader-default";
        
        String foto = new ProcessadorFotos("img/pefUsuer").processarArquivoCapa(request, fotoPart, "foto" + matricula + nomeArquivo);
        Usuario usuario = new Usuario(matricula, nome, email, senha, foto, status, PapelUser.valueOf(papel));
        return usuario;
        
    }

}
