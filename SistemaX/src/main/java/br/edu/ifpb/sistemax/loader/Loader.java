/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.loader;

import br.edu.ifpb.sistemax.DAO.EventoDAO;
import br.edu.ifpb.sistemax.DAO.FeriadoDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.DAO.SalaDAO;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Bloco;
import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Feriado;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.FeriadoException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.model.FeriadoBuscar;
import br.edu.ifpb.sistemax.model.CadastrarFeriadoBo;
import br.edu.ifpb.sistemax.model.UsuarioCadastrarBO;
import static java.awt.PageAttributes.MediaType.C;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpFactory;
import jdk.nashorn.internal.runtime.regexp.joni.constants.TokenType;
import sun.security.krb5.internal.ccache.CCacheInputStream;

/**
 *
 * @author José
 */
public class Loader {

    public static void main(String[] args) throws EmailExistenteException, NomeUsuarioExistenteException, FeriadoException, IOException, FileNotFoundException, ParseException {
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
        boolean sala1 = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().atualizarSala(sala0);
       System.out.println("Resultado: " + sala1);
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
                e.setResponsavel("Administrador");
                
                e.emAndatento();
                EventoDAO dao = new EventoDAO();
        Evento p;
        p = dao.buscaPorId(1);
                  System.err.println("resultado "+p.getId());
//                UsuarioAdmDAO s = new UsuarioAdmDAO();
//        Usuario u = s.buscaPorId(1);
//       // System.err.println("uuu "+u.getNome());
     //   Evento rr = dao.buscaPorId(1);
//        System.err.println("eeee  "+rr.getEstado().getClass().getSimpleName());
//        Bloco b = new Bloco(1);
//        b.setNome("bloco 1");
//        
//        List<Bloco> r = Factoy.criarFactoy(Factoy.DAO_BD).criaBlocoDAO().buscarTodos();
//        System.err.println("bloco "+r.get(0).getNome());
   }

}
