/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.exeption;

/**
 *
 * @author José
 */
public class NomeUsuarioExistenteException extends Exception{

    public NomeUsuarioExistenteException() {
        super("O nome já está cadastrado");
    }
    
    
}
