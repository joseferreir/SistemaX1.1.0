/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Material;

/**
 *
 * @author José
 */
public interface MaterialDAOIF {

    public boolean add(Material material, int quantidade);

    public boolean alterar(Material material);

    public boolean remover(long tombamento);

    public Material busvarPorTombamento(long tombamento);

    public Material busvarTodos();

    public Material busvarPorDescricao(String descricao);

}
