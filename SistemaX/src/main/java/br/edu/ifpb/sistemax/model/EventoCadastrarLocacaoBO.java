/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.EventoDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.Map;

/**
 *
 * @author José
 */
public class EventoCadastrarLocacaoBO {

    public EventoCadastrarLocacaoBO() {
    }
    

    public Map<String, String> cadastrar(Evento evento) {
        EventoValidarAlocarBO validar = new EventoValidarAlocarBO();
        Map<String, String> result = validar.EventoValidaralocar(evento);
        EventoDAOIF cadastrou = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO();
        if (result.get("passou").equalsIgnoreCase("true") && cadastrou.Alterar(evento)) {
            return result;
        } else {
            result.put("resultado", "Erro por favor verifique os dados e tente novamente!");
        }
        return result;
    }

}
