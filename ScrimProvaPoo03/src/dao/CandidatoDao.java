package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Candidato;
import service.CandidatoService;

public class CandidatoDao extends BancoDeDados{

	
	public 	List<Candidato> listarCandidatos() throws SQLException, IOException {
		
		PreparedStatement st;
		super.Conectar();
		st = super.conn.prepareStatement("select * from candidato");
		ResultSet rs = st.executeQuery();
		
		
		List<Candidato> resultado = new ArrayList<Candidato>();
		while(rs.next()) {
			Candidato cand = new Candidato(rs.getString("nome").toString(), rs.getString("senha").toString(), rs.getString("email").toString());
			
			
			resultado.add(cand);
		}
		return resultado;
		
		
		
	}
	
	public void cadastrarCandidato(String nome, String senha, String email) throws IOException, SQLException {
		PreparedStatement st;
		super.Conectar();
		st = super.conn.prepareStatement("Insert into candidato(nome,email,senha) values (?,?,?)");
		st.setString(1, nome);
		st.setString(2, senha);
		st.setString(3, email);
		st.executeUpdate();
	}
	
	
}
