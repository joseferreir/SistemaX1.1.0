/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.SalaDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Sala;
import java.util.Map;

/**
 *
 * @author José
 */
public class SalaAlterarBO {
    public Map<String, String> alterar(Sala sala){
        
        
         SalaValidar validar = new SalaValidar();
        Map<String, String> erros = validar.validarSala(sala);
        SalaDAOIF dao = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO();
        if (!erros.get("passou").equalsIgnoreCase("true") && dao.atualizarSala(sala)) {
            erros.put("passou", "false");
        }
        return erros;
    }
    
}
