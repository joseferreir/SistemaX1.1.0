package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author José
 */
public enum EstadoSala {
     
    Disponivel(1), Indisponivel(2);

    public int id;
    
    private EstadoSala(int id_banco) {
        id = id_banco;
    }
}
