package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CandidatoDao;
import entities.Candidato;

public class CandidatoService {
	
	private List<Candidato> Candidatos = new ArrayList<Candidato>();
	private CandidatoDao candidatoDao;
	

	
	public void buscarCandidatos() throws SQLException, IOException {
		this.candidatoDao = new CandidatoDao();
		this.Candidatos = candidatoDao.listarCandidatos();
	}
	
	public void mostrarCandidatos() {
		for(Candidato cand : Candidatos ) {
			System.out.println(cand.getNome()+ "  " + cand.getSenha()+ "  " + cand.getEmail());
		} 
	}
	
	public List<Candidato> listarCandidatos(){
		return Candidatos;
	}
	
	public void cadastrarCandidato(String nome, String email, String senha) throws IOException, SQLException {
		this.candidatoDao = new CandidatoDao();
		this.candidatoDao.cadastrarCandidato(nome, senha, email);
		this.buscarCandidatos();
	}
}
