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
     ADMISTRAD0R("ADMISTRAD0R") ,ASSISTENTE_SALA("ASSISTENTE_SALA"), PROFESSOR("PROFESSOR"), MONITOR("MONITOR"), ALUNO("ALUNO");
    
    public String id;
    
    PapelUser(String papel){
        id = papel;
    }
}
