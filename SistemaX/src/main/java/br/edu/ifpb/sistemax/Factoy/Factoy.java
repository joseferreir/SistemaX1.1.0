/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.Factoy;

/**
 *
 * @author José
 */
public class Factoy {

    public static final int DAO_BD = 0;

    public static FactoryDAOIF criarFactoy(int factoryType) {
        if (factoryType == DAO_BD) {
            return new FactoryBD();
        }
        return null;
    }

}
