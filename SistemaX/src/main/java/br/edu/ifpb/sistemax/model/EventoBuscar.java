/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.EventoDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.List;

/**
 *
 * @author José
 */
public class EventoBuscar {
    private  EventoDAOIF eventoDAO = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO();
     public Evento buscaPorId(int id){
       return eventoDAO.buscaPorId(id);
         
     }

    public Evento buscaPorNome(String nome){
        return eventoDAO.buscaPorNome(nome);
    }

    public Evento buscaPorReponsavel(int idDoResponsavel){
        return eventoDAO.buscaPorReponsavel(idDoResponsavel);
    }

    public List<Evento> buscaPorSala(int idSala){
        return eventoDAO.buscaPorSala(idSala);
    }
    
}
