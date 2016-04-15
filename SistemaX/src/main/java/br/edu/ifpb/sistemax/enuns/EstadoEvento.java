/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author José
 */
public enum EstadoEvento {
     pendente(1), agendado(2), emAndamento(3);

    public int id;
    
    private EstadoEvento(int id_banco) {
        id = id_banco;
    }
    
}
