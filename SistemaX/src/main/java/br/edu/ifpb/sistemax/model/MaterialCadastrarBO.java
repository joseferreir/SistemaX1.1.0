/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.MaterialDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Material;
import java.util.Map;

/**
 *
 * @author José
 */
public class MaterialCadastrarBO {

    public Map<String, String> cadastrar(Material material,int quantidade) {
      MaterialValidar validar  = new MaterialValidar();
        Map<String, String> result = validar.validar(material);
        MaterialDAOIF dao = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO();
        if(result.get("passou").equalsIgnoreCase("true") &&dao.add(material, quantidade))
            result.put("passou", "true");
        return result;
    }
}
