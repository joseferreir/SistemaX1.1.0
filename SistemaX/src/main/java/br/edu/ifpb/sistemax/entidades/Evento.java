/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.entidades;

import br.edu.ifpb.sistemax.state.EventoPendente;
import br.edu.ifpb.sistemax.state.EventoState;
import java.sql.Timestamp;
import java.util.Objects;

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
  private Sala sala;

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

    public EventoState getEstado() {
        return estado;
    }

    public void setEstado(EventoState estado) {
        this.estado = estado;
    }

  

    public void pendente() {
        this.estado = this.estado.pendente();
    }

    public void emAndatento() {
        this.estado = this.estado.emAndatento();
    }

    public void agardando() {
        this.estado = this.estado.agardando();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        return true;
    }
    
    

}
