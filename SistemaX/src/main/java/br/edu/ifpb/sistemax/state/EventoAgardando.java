/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.state;

/**
 *
 * @author José
 */
class EventoAgardando implements EventoState {

    @Override
    public String toString() {
        return  nome ;
    }
    private String nome = "Agardando";
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
       
        return this;
    }

}
