/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.DAO;

import br.edu.ifpb.sistemax.conexao.ConexaoIF;
import br.edu.ifpb.sistemax.entidades.Feriado;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author José
 */
public interface FeriadoDAOIF {
    

    public boolean adiciona(Feriado feriado);

    public boolean edita(Feriado feriado);

    public Feriado buscarPorNome(String nome);

    public List<Feriado> buscarTodos();

    public Feriado busbarPorData(LocalDate data);

    public boolean remover(String nome);

    public boolean removerData(LocalDate data);

    public List<Feriado> buscarAtributos(Map<String, String> map);

    public List<Feriado> buscarAtributosNaoExatos(Map<String, String> map);

}
