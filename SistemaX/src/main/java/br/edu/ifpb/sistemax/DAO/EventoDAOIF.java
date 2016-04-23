/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.EventoDTO;
import java.util.List;

/**
 *
 * @author José
 */
public interface EventoDAOIF {

    public boolean add(Evento evento);

    public boolean Alterar(Evento evento);

    public boolean remover(int id);

    public Evento buscaPorId(int id);

    public Evento buscaPorNome(String nome);

    public Evento buscaPorReponsavel(int idResponsavel);

    public List<Evento> buscaPorSala(int idSala);

    public List<EventoDTO> listarNaoFinalizados();

    public List<EventoDTO> listarEventosDTO();
    

}
