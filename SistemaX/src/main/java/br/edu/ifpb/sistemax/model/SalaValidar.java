/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.entidades.Sala;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 */
public class SalaValidar {

    public Map<String, String> validarSala(Sala sala) {
        Map<String, String> erros = new HashMap<>();
        if (sala.getNome().trim().isEmpty()) {
            erros.put("nome", "nome invalido");
        }
        if (sala.getCapacidade() <= 0) {
            erros.put("capacidade", "Digite a capacidade");
        }
        if (sala.getIdBloco() <= 0) {
            erros.put("bloco", "infome o bloco ao qual esta sala está localizada ");
        }
        if (sala.getTipo() <= 0) {
            erros.put("tipo", "infome o tipo da sala");
        }
        if (erros.isEmpty()) {
            erros.put("passou", "true");
        } else {
            erros.put("passou", "false");
        }
        return erros;
    }
}
