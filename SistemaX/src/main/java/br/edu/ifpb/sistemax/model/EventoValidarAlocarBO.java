/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public class EventoValidarAlocarBO {

    public EventoValidarAlocarBO() {
    }

    public Map<String, String> EventoValidaralocar(Evento evento) {
        Map<String, String> result = new HashMap<>();
        List<Evento> eventoLocados = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO().buscaPorSala(evento.getSala().getId());
        if (!eventoLocados.isEmpty()) {
            for (Evento e : eventoLocados) {
                if (evento.equals(e)) {
                    result.put("isEvento", "existe um evento alocado para está sala");
                    result.put("passou", "false");
                }
            }
        }
        if (evento.getNumParticipantes() > evento.getSala().getCapacidade()) {
            result.put("capacidade", "A sala não comporta o número de participantes");
        }
        if (result.isEmpty()) {
            result.put("passou", "true");
        } else {
            result.put("passou", "false");
        }
        return result;

    }

}
