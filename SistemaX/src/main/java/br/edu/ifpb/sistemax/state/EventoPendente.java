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
public class EventoPendente implements EventoState{
private String nome = "Pendente";
    @Override
    public EventoState pendente() {
        return this;
    }

    @Override
    public EventoState emAndatento() {
        return new EventoEmAndatento();
    }

    @Override
    public EventoState agardando() {
    return new EventoAgardando();
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
