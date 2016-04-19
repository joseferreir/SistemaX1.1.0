/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.Factoy;

import br.edu.ifpb.sistemax.DAO.BlocoDAOIF;
import br.edu.ifpb.sistemax.DAO.EventoDAOIF;
import br.edu.ifpb.sistemax.DAO.FeriadoDAOIF;
import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioDAOIF;
import br.edu.ifpb.sistemax.DAO.SalaDAOIF;

/**
 *
 * @author José
 */
public interface FactoryDAOIF {

    public UsuarioDAOIF criaUsuarioDAO();

    public UsuarioAdmDAO criaUsuarioAdmDAO();

    public FeriadoDAOIF criaFeriadoDAO();

    public SalaDAOIF criaSalaDAO();

    public EventoDAOIF criaEventoDAO();

    public BlocoDAOIF criaBlocoDAO();

}
