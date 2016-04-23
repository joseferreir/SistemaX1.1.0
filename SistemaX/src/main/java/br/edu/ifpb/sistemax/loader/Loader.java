/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.loader;

import br.edu.ifpb.sistemax.DAO.EventoDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.conexao.DataBaseException;
import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Material;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.FeriadoException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.model.SalaRemoverBO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author José
 */
public class Loader {

    public static void main(String[] args) throws EmailExistenteException, NomeUsuarioExistenteException, FeriadoException, IOException, FileNotFoundException, ParseException, DataBaseException, SQLException, ClassNotFoundException {
//        UsuarioAdmDAO s = Factoy.criarFactoy(Factoy.DAO_BD).criaUsuarioAdmDAO();
//          Usuario u = new Usuario("000032", "mariaw", "maria2@gmail.com", "wSew12@#32", "foto4", true, PapelUser.Administrador);
//        Map<String, String> aa = new HashMap<String, String>();
//        aa.put("nomeusuario", "d");
//           UsuarioCadastrarBO bo = new UsuarioCadastrarBO();
//         Map<String, String> y = bo.addUsuario(u);
//         System.err.println("dddddddd"+y.get("passou"));
//         

//##adicionar sala teste;
        Sala sala0 = new Sala("sala 2", 1, 30, 1);
       // sala0.disponivel();
      //  System.err.println("ssss "+ sala0.getEstado());
      //  System.err.println("trocou "+sala0.indisponivel().toString());
        sala0.indisponivel();
        sala0.setId(1);
        System.out.println("estado "+sala0.getEstado());
        sala0.indisponivel();
        System.err.println("estado 2 "+sala0.getEstado().toString());
       // boolean sala1 = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().atualizarSala(sala0);
      // System.out.println("Resultado: " + sala1);
//atualizar sala teste;    
//        Sala sala0 = new Sala("sala2", 1, 35, 1, 1);
//        sala0.setId(1);
//        boolean sala2 = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().atualizarSala(sala0);
//        System.out.println("Resultado: " + sala2);
//        
//deletar sala teste;
//boolean sala3=Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().removerSala(2);
//        System.out.println("Resultado: "+ sala3);
//buscar sala teste;
//Sala sala4=Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarSala(1);
//        System.out.println("Resultado: " + sala4.toString());
//buscar sala por atributos não exatos;
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("nome", "sala");
//
//        List<Sala> sala5 = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().buscarAtributosNaoExatos(map);
//
//        System.out.println("Resultado:"+sala5.get(0).getNome());
        Timestamp i = Timestamp.from(Instant.now());
        Timestamp f = Timestamp.from(Instant.now());
        Evento e = new Evento();
        e.setDataInicio(i);
        e.setDataTermino(f);
        e.setDescricao("testo 2");
                e.setNome("padroes 2");
                e.setNumParticipantes(20);
               // e.setResponsavel("Administrador");
                sala0.setId(1);
                e.setSala(sala0);
                e.emAndatento();
              //  e.setId(3);
                EventoDAO dao = new EventoDAO();
               // dao.add(e);
     //  boolean ddd = dao;
       // System.err.println("dddd "+ddd);
        Evento qe;
       // int q = dao.desalocarEvento(2);
                 //System.err.println("desalocol "+q);
                UsuarioAdmDAO s = new UsuarioAdmDAO();
                
        Usuario u = s.buscaPorId(1);
        System.err.println("addddddd  "+u.getId());
        e.setResponsavel(u);
       //  dao.add(e);
       // qe.setNome("Aula de padroes");
        System.err.println("user"+u.getNome());
        u.setNome("Diogo Moreira");
        //   u.update(qe,"maria");
      // List<Evento> sala12 = dao.buscaPorSala(5);
       //System.err.println("sala1122323 "+sala12.get(0).getNome());
        SalaRemoverBO remo = new SalaRemoverBO();
        boolean zz = remo.remover(6, u.getNome());
        System.err.println("zzzz  "+zz);
        
//       // System.err.println("uuu "+u.getNome());
     //   Evento rr = dao.buscaPorId(1);
//        System.err.println("eeee  "+rr.getEstado().getClass().getSimpleName());
//        Bloco b = new Bloco(1);
//        b.setNome("bloco 1");
//        
//        List<Bloco> r = Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarTodos();
//        System.err.println("bloco "+r.get(0).getNome());
        sala0.setId(1);
        Material m =new Material();
        m.setDescricao("cabo");
        m.setTombamento(1000004);
        m.setLocal(sala0);
        //    Map  map = new HashMap();
        // map.put("estado","1");
        //  map.put("local", Integer.toString(1));
        // List l = Factoy.criarFactoy(Factoy.DAO_BD).criaMaterialDAO().buscarAtributos(map);
        // for (int j = 0; j < l.size(); j++)
//        // System.err.println("resultado mat "+l.get(j).toString());
    //    List<EventoDTO> s = Factoy.criarFactoy(Factoy.DAO_BD).criaEventoDAO().listarNaoFinalizados();
//
//        for (int j = 0; j < s.size(); j++) {
//            EventoDTO w = s.get(j);
//            System.err.println("resultado mat " + w.getSituacao());
//        }
//        
   }

}
