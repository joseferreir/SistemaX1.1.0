
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;

/**
 *
 * @author Aluísio
 */
public class SalaRemoverBO {
    public boolean remover(int idSala){
        return Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().removerSala(idSala);
    }
}
