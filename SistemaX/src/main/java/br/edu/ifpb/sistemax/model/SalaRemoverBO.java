
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Evento;
import java.util.List;

/**
 *
 * @author Aluísio
 */
public class SalaRemoverBO {

    public SalaRemoverBO() {
    }
    
    public boolean remover(int idSala,String responsavelPorExcluir){
        List<Evento> eventos = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO().buscaPorSala(idSala);
        boolean result = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().removerSala(idSala);
        if(result){
            NotificarUsuariosBO notificacao = new NotificarUsuariosBO();
            notificacao.notificaUsuario(eventos, responsavelPorExcluir);
        }
        return result;
    }
}
