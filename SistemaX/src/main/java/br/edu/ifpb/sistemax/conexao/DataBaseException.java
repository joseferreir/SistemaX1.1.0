/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.conexao;

import java.sql.SQLException;

/**
 *
 * @author susanneferraz
 */
public class DataBaseException extends SQLException {

    private static final long serialVersionUID = 1L;

    public DataBaseException(String error) {
        super("Erro na dase de dados:" + error);
    }

}
