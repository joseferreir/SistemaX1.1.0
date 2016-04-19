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
public class SalaDisponivel implements SalaState{
private String nome = "Disponivel";
    public SalaDisponivel() {
        
    }

    @Override
    public SalaState disponivel() {
   return this;
    }
    

    @Override
    public SalaState indisponivel() {
        return new SalaIndisponivel();
    }

    @Override
    public String toString() {
        return  nome ;
    }

   
     
    
    
}
