
package br.edu.ifpb.sistemax.entidades;

/**
 *
 * @author Aluísio
 */
public class Sala {
    private int id;
    private String nome;
    private int idBloco;
    private int capacidade;
    private int estado;
    private int tipo;

    public Sala(){
    }

    public Sala(String nome, int idBloco, int capacidade, int estado, int tipo) {
        this.nome = nome;
        this.idBloco = idBloco;
        this.capacidade = capacidade;
        this.estado = estado;
        this.tipo = tipo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", nome=" + nome + ", idBloco=" + idBloco + ", capacidade=" + capacidade + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
    
}
