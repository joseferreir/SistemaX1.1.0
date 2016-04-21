
package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author José
 */
public enum EstadoMaterial {
    
   MaterialDisponivel(1), MaterialEmprestado(2);

    public int id;
    
    private EstadoMaterial(int id_banco) {
        id = id_banco;
    }
    
    public int getId(){
        return this.id;
    }
    
}
