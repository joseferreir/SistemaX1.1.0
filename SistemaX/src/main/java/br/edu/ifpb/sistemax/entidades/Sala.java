
package br.edu.ifpb.sistemax.entidades;

import br.edu.ifpb.sistemax.state.SalaDisponivel;
import br.edu.ifpb.sistemax.state.SalaState;
import br.edu.ifpb.sistemax.state.SalaIndisponivel;

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
          estado = new SalaDisponivel();
        
    }

    public Sala(String nome, int idBloco, int capacidade, int tipo) {
        this.nome = nome;
        this.idBloco = idBloco;
        this.capacidade = capacidade;
        this.tipo = tipo;
        estado = new SalaDisponivel();
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

    public SalaState getEstado() {
        return estado;
    }

   

  

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
     public void disponivel(){
      this.estado =  estado.disponivel();
        
        
     }

    public void indisponivel(){
     this.estado = this.estado.indisponivel();
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", nome=" + nome + ", idBloco=" + idBloco + ", capacidade=" + capacidade + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
    
}
