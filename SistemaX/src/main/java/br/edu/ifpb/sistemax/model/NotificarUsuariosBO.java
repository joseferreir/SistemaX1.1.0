/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.List;

/**
 *
 * @author José
 * classe para informa aos Usuário que a sala de um evento foi exccluida do sistema  
 */
public class NotificarUsuariosBO {

    public NotificarUsuariosBO() {
    }
    
    public void notificaUsuario(List<Evento> eventos, String responsavelPorExcluir){
        for(Evento e: eventos)
           e.getResponsavel().update(e, responsavelPorExcluir);
        
    }
}
