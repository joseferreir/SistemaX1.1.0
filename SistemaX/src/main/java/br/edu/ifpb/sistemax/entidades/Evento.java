/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.entidades;

import br.edu.ifpb.sistemax.state.EventoPendente;
import br.edu.ifpb.sistemax.state.EventoState;
import java.sql.Timestamp;

/**
 *
 * @author José
 */
public class Evento {
    

    private int id;
    private String nome;
    private String descricao;
    private int numParticipantes;
    private String responsavel;
    private Timestamp dataInicio;
    private Timestamp dataTermino;
    private EventoState estado;

    public Evento() {
        this.estado = new EventoPendente();
    }

    public void setId(int id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

   

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Timestamp dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getEstado() {
        return this.estado.getClass().getSimpleName();
    }

    public void setEstado(EventoState estado) {
        this.estado = estado;
    }
     public void pendente(){
         this.estado.pendente();
     }

    public void emAndatento(){
        this.estado.emAndatento();
    }

    public void agardando(){
        this.estado.agardando();
    }

  
    
}
