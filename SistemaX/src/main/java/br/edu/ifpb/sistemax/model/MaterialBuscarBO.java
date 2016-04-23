/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.MaterialDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Material;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public class MaterialBuscarBO {

    MaterialDAOIF dao;

    public MaterialBuscarBO() {
        dao = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO();
    }

    public Material busvarPorTombamento(long tombamento) {
        return dao.busvarPorTombamento(tombamento);
    }

    public List<Material> busvarTodos() {
        return dao.busvarTodos();

    }

    public Material busvarPorDescricao(String descricao) {
        return dao.busvarPorDescricao(descricao);
    }

    public List<Material> buscarAtributos(Map<String, String> map) {
        return dao.buscarAtributos(map);
    }

    public List<Material> buscarDsponivel() {
        return dao.buscarDsponivel();
    }
}
