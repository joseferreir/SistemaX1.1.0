/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author José
 */
/**
 * 
 * Enumeração que utilizada para determina o papel dos Usuários
 */
public enum PapelUser {
     Administrador("Administrador") ,AssistenteDeSala("AssistenteDeSala"), Professor("Professor"), Monitor("Monitor"), Aluno(" Aluno");
    
    public String id;
    
    PapelUser(String papel){
        id = papel;
    }
}
