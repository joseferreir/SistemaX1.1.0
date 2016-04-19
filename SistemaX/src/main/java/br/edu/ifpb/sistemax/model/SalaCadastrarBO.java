package br.edu.ifpb.sistemax.model;

import br.edu.ifpb.sistemax.DAO.SalaDAOIF;
import br.edu.ifpb.sistemax.Factoy.Factoy;
import br.edu.ifpb.sistemax.entidades.Sala;
import java.util.Map;

/**
 *
 * @author Aluísio
 */
public class SalaCadastrarBO {

    public Map<String, String> cadastrat(Sala sala) {
        SalaValidar validar = new SalaValidar();
        Map<String, String> erros = validar.validarSala(sala);
        SalaDAOIF dao = Factoy.criarFactoy(Factoy.DAO_BD).criaSalaDAO();
        if (!erros.get("passou").equalsIgnoreCase("true") && dao.addSala(sala)) {
            erros.put("passou", "false");
        }
        return erros;

    }
}
