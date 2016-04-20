/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.model.SalaBuscarBO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class SalaBuscarTodas implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        SalaBuscarBO buscar = new SalaBuscarBO();
        List<Sala> lista = buscar.buscarTodas();
        if(!lista.isEmpty()){
            request.getSession().setAttribute("salas", lista);
        }
    }
    
}
