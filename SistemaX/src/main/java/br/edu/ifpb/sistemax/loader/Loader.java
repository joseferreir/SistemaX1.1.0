/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.loader;

import br.edu.ifpb.sistemax.DAO.FeriadoDAO;
import br.edu.ifpb.sistemax.DAO.UsuarioAdmDAO;
import br.edu.ifpb.sistemax.DAO.sala.SalaDAO;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Feriado;
import br.edu.ifpb.sistemax.entidades.Sala;
import br.edu.ifpb.sistemax.entidades.Usuario;
import br.edu.ifpb.sistemax.enuns.PapelUser;
import br.edu.ifpb.sistemax.exeption.EmailExistenteException;
import br.edu.ifpb.sistemax.exeption.FeriadoException;
import br.edu.ifpb.sistemax.exeption.NomeUsuarioExistenteException;
import br.edu.ifpb.sistemax.model.BuscarFeriado;
import br.edu.ifpb.sistemax.model.CadastrarFeriadoBo;
import br.edu.ifpb.sistemax.model.CadastrarUsuarioBO;
import static java.awt.PageAttributes.MediaType.C;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//           CadastrarUsuarioBO bo = new CadastrarUsuarioBO();
//         Map<String, String> y = bo.addUsuario(u);
//         System.err.println("dddddddd"+y.get("passou"));
//         
         Sala sala0 = new Sala ("sala1",1,40, 1, 1);
         boolean sala1 = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO().addSala(sala0);
        System.out.println("Resultado: "+ sala1);
        
       
    }
    
}
