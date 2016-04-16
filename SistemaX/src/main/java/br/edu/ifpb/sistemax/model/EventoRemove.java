/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;

/**
 *
 * @author José
 */
public class EventoRemove {
    public boolean removerEvento(Evento evento){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO().remover(evento.getId());
    }
}
