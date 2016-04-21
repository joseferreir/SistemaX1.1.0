/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.command;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Material;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
public class MaterialBuscar implements Command {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<Material> lista = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO().busvarTodos();
        request.getSession().setAttribute("materiais", lista);
    }
    
}
