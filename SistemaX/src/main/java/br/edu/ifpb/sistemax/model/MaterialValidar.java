/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.entidades.Material;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 */
public class MaterialValidar {

    public MaterialValidar() {
    }
    
    public Map<String, String> validar(Material material){
         Map<String, String> result = new HashMap();
        if (material.getDescricao().trim().isEmpty() || material.getDescricao().length() > 60) {
            result.put("nome", "Infome uma descricao para o material");
        }
        if (result.isEmpty()) {
            result.put("passou", "true");
        } else {
            result.put("passou", "false");
        }
        return result;
    }
}
