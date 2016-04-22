/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Material;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public interface MaterialDAOIF {

    public boolean add(Material material, int quantidade);

    public boolean alterar(Material material);

    public boolean remover(long tombamento);

    public Material busvarPorTombamento(long tombamento);

    public List<Material> busvarTodos();

    public Material busvarPorDescricao(String descricao);
    
public List<Material> buscarAtributos(Map<String, String> map);
}
