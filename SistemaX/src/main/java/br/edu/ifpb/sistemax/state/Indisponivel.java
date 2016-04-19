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
public class Indisponivel implements SalaState{

    @Override
    public SalaState disponivel() {
   return new Disponivel();
    }

    @Override
    public SalaState indisponivel() {
        return this;
    }
    
}
