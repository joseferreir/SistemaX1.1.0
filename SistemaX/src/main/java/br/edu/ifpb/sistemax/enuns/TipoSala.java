package br.edu.ifpb.sistemax.enuns;

/**
 *
 * @author Aluísio
 */
public enum TipoSala {
    
    Comum ("Comum"), Laboratorio ("Laboratorio"), Oficina ("Oficina"), Inteligente("Inteligente");
   
    public String id;
    
    TipoSala(String tipo){
        id = tipo;
    }
    
}
