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
public class EventoDTO {

    private int id;
    private String data;
    private String duracao;
    private String nome;
    private String situacao;
    private String Local;

    public EventoDTO() {

    }

    public EventoDTO(int id, String data, String duracao, String nome, String situacao, String Local) {
        this.data = data;
        this.duracao = duracao;
        this.nome = nome;
        this.situacao = situacao;
        this.Local = Local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String Local) {
        this.Local = Local;
    }

 }
