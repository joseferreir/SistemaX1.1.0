/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José
 */
public class EventoValidar {

    public Map<String, String> validarEvento(Evento evento) {

        Map<String, String> erros = new HashMap<>();
        if (evento.getNome().trim().isEmpty()) {
            erros.put("nome", "Infome um nome para o evento!");
        }
        if (evento.getDescricao().trim().isEmpty()) {
            erros.put("descricao", "Infome a descrição!");
        }
        if (evento.getNumParticipantes() <= 0) {
            erros.put("participantes", "Infome o número de participântes");
        }
        if (evento.getResponsavel()==null) {
            erros.put("reponsavel", "Infome o nome do responsavel pelo evento");
        }
        if (evento.getDataInicio() == null) {
            erros.put("dataInicio", "Infome a data de inicio do evento");
        }
        if (evento.getDataTermino() == null) {
            erros.put("datatermino", "Infome a data do termino do evento");
        }
        if (erros.isEmpty()) {
            erros.put("passou", "true");
        } else {
            erros.put("passou", "false");
        }
        return erros;
    }
}
