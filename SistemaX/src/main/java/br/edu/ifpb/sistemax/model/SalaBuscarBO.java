
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.SalaDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Sala;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aluísio
 */
public class SalaBuscarBO {
 private SalaDAOIF dao;

    public SalaBuscarBO() {
        this.dao = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO();
    }
    public Sala buscarSala(int id){
        return dao.buscarSala(id);
    }

    public List<Sala> buscarAtributosNaoExatos(Map<String, String> map){
       return dao.buscarAtributosNaoExatos(map);
    }

    public List<Sala> buscarTodas(){
        return dao.buscarTodas();
    }
}
