/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.state;

import sun.security.util.PendingException;

/**
 *
 * @author José
 */
class EventoEmAndatento implements EventoState {

    public EventoEmAndatento() {
    }

    @Override
    public EventoState pendente() {
        return new EventoPendente();
    }

    @Override
    public EventoState emAndatento() {
        return new EventoEmAndatento();
    }

    @Override
    public EventoState agardando() {
        System.err.println("==================");
        return this;
    }

}
