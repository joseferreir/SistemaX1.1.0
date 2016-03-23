
package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.FeriadoDAO;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Feriado;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 
 *
 * @author Aluisio
 */
public class BuscarFeriado {

    private FeriadoDAO dao = null;

    /**
     * Método que pesquisa se um feriado já existe.
     *
     * @param feriado Feriado a ser pesquisado
     * @return <code>true</code> se o feriado já existir, <code>false</code>
     * caso contrário
     */
    public boolean feriadoIsRepetido(Feriado feriado) {

        boolean repetido = false;

        Map<String, String> map = new HashMap<String, String>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        map.put("data", feriado.getData().format(DateTimeFormatter.ISO_DATE));

        if (dao == null) {
            dao = new FeriadoDAO();
        }

        if (dao.busbarPorData(feriado.getData())!=null) {
            repetido = true;
        }

        return repetido;
    }

    public Feriado buscarData(LocalDate data) {
        if (dao == null) {
            dao = new FeriadoDAO();
        }
      return dao.busbarPorData(data);
    }

    public Feriado buscarnome(String nome) {
     return dao.buscarPorNome(nome);
    }

    public List<Feriado> buscarTodos() {

        if (dao == null) {
            dao = new FeriadoDAO();
        }

        return dao.buscarTodos();
    }

}
