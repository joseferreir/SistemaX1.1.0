
package br.edu.ifpb.sistemax.entidades;

import br.edu.ifpb.sistemax.state.Disponivel;
import br.edu.ifpb.sistemax.state.SalaState;
import br.edu.ifpb.sistemax.state.Indisponivel;

/**
 *
 * @author Aluísio
 */
public class Sala {
    private int id;
    private String nome;
    private int idBloco;
    private int capacidade;
    private SalaState estado;
    private int tipo;

    public Sala(){
        
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(int idBloco) {
        this.idBloco = idBloco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getEstado() {
        return estado.getClass().getSimpleName();
    }

  

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
     public SalaState disponivel(){
       return new Disponivel();
        
        
     }

    public SalaState indisponivel(){
       return new Indisponivel();
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", nome=" + nome + ", idBloco=" + idBloco + ", capacidade=" + capacidade + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
    
}
