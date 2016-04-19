package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.FeriadoDAO;
import br.edu.ifpb.sistemax.entidades.Feriado;
import br.edu.ifpb.sistemax.exeption.FeriadoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/* 
 * Aluisio
 *
 **/
public class FeriadoCadastrarBO {

    private FeriadoDAO dao;
    private FeriadoBuscar busca;

    public boolean adicionarFeriado(Feriado feriado, boolean sobrescrever) throws FeriadoException {

        if (FeriadoVerifica.verificarFeriado(feriado)) {
            if (dao == null) {
                dao = new FeriadoDAO();
            }

            if (sobrescrever) {

                if (busca == null) {
                    busca = new FeriadoBuscar();
                }

                if (busca.feriadoIsRepetido(feriado)) {
                    dao.remover(feriado.getNome());
                    if (!dao.adiciona(feriado)) {
                        throw new FeriadoException();
                    }
                }
            }

            return dao.adiciona(feriado);
        } else {
            throw new FeriadoException();
        }

    }

    public boolean adicionarFeriados(InputStream iSferiados, boolean sobrescrever) throws FeriadoException {
        Scanner in = new Scanner(iSferiados, "UTF-8");
        String s;
        List<Feriado> feriados = new ArrayList<>();

        while (in.hasNext()) {
            String linha = in.nextLine();
            String[] dados = linha.split(",");

            Feriado feriado = new Feriado();

            try {
                feriado.setData(LocalDate.parse(dados[0], DateTimeFormatter.ISO_DATE));
                feriado.setNome(dados[1]);
                feriados.add(feriado);
            } catch (Exception ex) {
                throw new FeriadoException();
            }
            if (!FeriadoVerifica.verificarFeriado(feriado)) {
                throw new FeriadoException();
            }

        }

        for (Feriado f : feriados) {
            adicionarFeriado(f, sobrescrever);
        }

        return true;
    }

    public boolean adicionarFeriados(String pathArquivoFeriados, boolean sobrescrever) throws FileNotFoundException, IOException, ParseException, FeriadoException {
        int taman = pathArquivoFeriados.length();
        String extensao = pathArquivoFeriados.substring(taman - 3);
        if (extensao.equalsIgnoreCase("csv")) {

            return FeriadoCadastrarBO.this.adicionarFeriados(new FileInputStream(pathArquivoFeriados), sobrescrever);
        }else
            throw new FeriadoException();
            
    }

}
