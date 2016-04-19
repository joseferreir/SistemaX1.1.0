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
public class SalaIndisponivel implements SalaState {

    private String nome = "Indisponivel";

    @Override
    public SalaState disponivel() {
        return new SalaDisponivel();
    }

    @Override
    public SalaState indisponivel() {
        return this;
    }

    @Override
    public String toString() {
        return nome;
    }

}
