package br.edu.ifpb.sistemax.Factoy;

import br.edu.ifpb.sistemax.DAO.FeriadoDAO;
import br.edu.ifpb.sistemax.DAO.FeriadoDAOIF;
import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioAdminDAOIF;
import br.edu.ifpb.sistemax.DAO.UsuarioDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioDAOIF;
import br.edu.ifpb.sistemax.DAO.sala.SalaDAO;
import br.edu.ifpb.sistemax.DAO.sala.SalaDAOIF;

public class FactoryBD implements FactoryDAOIF {

    public FactoryBD() {
    }

    @Override
    public UsuarioDAOIF criaUsuarioDAO() {
        return new UsuarioDAO();

    }

    @Override
    public UsuarioAdmDAO criaUsuarioAdmDAO() {
        return new UsuarioAdmDAO();
    }

    @Override
    public FeriadoDAOIF criaFeriadoDAO() {
        return new FeriadoDAO();
    }

    @Override
    public SalaDAOIF criaSalaDAO() {
        return new SalaDAO();
    }

}
