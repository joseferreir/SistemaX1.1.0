/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Sala;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class SalaBuscarPorAtributo implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
         response.setContentType("text/html;charset=UTF-8");
        try {
             request.setCharacterEncoding("UTF-8");
        Map<String, String> mapa = new HashMap<String, String>();
        String busca = request.getParameter("buscaAT");
        mapa.put("nome", busca);
        List<Sala> result = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarAtributosNaoExatos(mapa);
        request.setAttribute("salasAT", result);
     
            response.sendRedirect("pagina");
        } catch (IOException ex) {
            Logger.getLogger(SalaBuscarPorAtributo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
