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
public class MaterialDisponivel implements MateralState{
private String nome = "Disponivel";
    @Override
    public MateralState emprestado() {
  return new MaterialEmprestado();
    }

    @Override
    public MateralState disponivel() {
        return (MateralState) this;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
