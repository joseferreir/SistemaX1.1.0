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
class MaterialEmprestado implements MateralState{
 private String nome="Empretado";  
    @Override
    public MateralState emprestado() {
       return this;
    }

    @Override
    public MateralState disponivel() {
       return new MaterialDisponivel();
    }

    @Override
    public String toString() {
        return nome ;
    }
    

   
}
