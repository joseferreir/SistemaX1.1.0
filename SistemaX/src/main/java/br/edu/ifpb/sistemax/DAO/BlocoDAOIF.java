/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Bloco;
import java.util.List;

/**
 *
 * @author José
 */
public interface BlocoDAOIF {

    public boolean add(Bloco bloco);

    public boolean alterar(Bloco bloco);

    public boolean remover(int id);

    public Bloco buscarPorId(int idBloco);

    public Bloco buscarPorNome(String nomeBloco);

    public List<Bloco> buscarTodos();
}
