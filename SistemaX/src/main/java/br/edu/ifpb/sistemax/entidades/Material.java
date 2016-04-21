/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.entidades;

import br.edu.ifpb.sistemax.state.MateralState;

/**
 *
 * @author José
 */
public class Material {

    private String descricao;
    private MateralState estado;
    private Sala local;
    private long tombamento;

    public Material() {
        this.estado = this.estado.disponivel();
        this.local = null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MateralState getEstado() {
        return estado;
    }

    public Sala getLocal() {
        return local;
    }

    public void setLocal(Sala local) {
        this.local = local;
    }

    public long getTombamento() {
        return tombamento;
    }

    public void setTombamento(long tombamento) {
        this.tombamento = tombamento;
    }

    public void emprestado() {
        this.estado = this.estado.emprestado();
    }

    public void disponivel() {
        this.estado = this.estado.disponivel();
    }

}
