package gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CandidatoDao;
import entities.Candidato;
import service.CandidatoService;

public class TesteTela {

	public static void main(String[] args) throws SQLException, IOException {
		CandidatoWindow tela =  new CandidatoWindow();
		tela.setVisible(true);
		
		//CandidatoDao cands = new CandidatoDao();
		
		CandidatoDao candidatoDao = new CandidatoDao();
		
		CandidatoService cands = new CandidatoService();
		
									cands.buscarCandidatos();
		cands.mostrarCandidatos();
	
		
		//List<Candidato> candidatos = cands.listarCandidatos();
		
	
	}

}
