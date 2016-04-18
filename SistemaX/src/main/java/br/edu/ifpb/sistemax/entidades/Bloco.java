/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.entidades;

/**
 *
 * @author José
 */
public class Bloco {
    private int id;
    private String nome;

    public Bloco() {
    }

    public Bloco(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
