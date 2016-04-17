/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.EventoDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.Map;



/**
 *
 * @author José
 */


public class EventoCadastrarBO {

    public Map<String, String> cadastrarEvento(Evento evento) {
        EventoValidar valida = new EventoValidar();
        Map<String, String> erros = valida.validarEvento(evento);
        EventoDAOIF cadastrou = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO();
        if (erros.get("passou").equals("true") && cadastrou.add(evento)) {
            return erros;
        } else {
            erros.put("passou", "false");
            return erros;
        }
    }

}
