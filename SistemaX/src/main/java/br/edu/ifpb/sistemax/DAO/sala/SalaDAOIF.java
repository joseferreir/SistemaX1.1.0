/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO.sala;

import br.edu.ifpb.sistemax.entidades.Sala;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aluísio
 */
public interface SalaDAOIF {
    public boolean addSala(Sala sala);
    public boolean atualizarSala (Sala sala);
    public boolean removerSala(int id);
    public Sala buscarSala (int id);
    public List<Sala> buscarAtributosNaoExatos(Map<String, String> map);
}
