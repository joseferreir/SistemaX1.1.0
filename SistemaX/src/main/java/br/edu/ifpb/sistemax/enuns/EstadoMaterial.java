
package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author José
 */
public enum EstadoMaterial {
    
    DISPONIVEL(1), INDISPONIVEL(2);

    public int id;
    
    private EstadoMaterial(int id_banco) {
        id = id_banco;
    }
    
    public int getId(){
        return this.id;
    }
    
}
