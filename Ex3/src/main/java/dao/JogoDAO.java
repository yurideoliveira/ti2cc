package dao;

import model.Jogo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JogoDAO extends DAO {	
	public JogoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Jogo jogo) {
		boolean status = false;
		try {
			String sql = "INSERT INTO jogo (nome, genero, preco, quantidade) "
		               + "VALUES ('" + jogo.getNome() + "', '" 
					   + jogo.getGenero()+ "', " 
		               + jogo.getPreco() + ", " + jogo.getQuantidade() + ");";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Jogo get(int id) {
		Jogo jogo = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	jogo = new Jogo(rs.getInt("id"), rs.getString("nome"),rs.getString("genero"), (float)rs.getDouble("preco"), 
	                				   rs.getInt("quantidade"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogo;
	}
	
	
	public List<Jogo> get() {
		return get("");
	}

	
	public List<Jogo> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Jogo> getOrderByGenero() {
		return get("genero");		
	}
	
	
	public List<Jogo> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Jogo> getOrderByPreco() {
		return get("preco");		
	}
	
	public List<Jogo> getOrderByQuantidade() {
		return get("quantidade");		
	}
	
	
	private List<Jogo> get(String orderBy) {
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Jogo p = new Jogo(rs.getInt("id"), rs.getString("nome"),rs.getString("genero"), (float)rs.getDouble("preco"), 
     				   rs.getInt("quantidade"));
	            jogos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogos;
	}
	
	
	public boolean update(Jogo jogo) {
		boolean status = false;
		try {  
			String sql = "UPDATE jogo SET nome = '" + jogo.getNome() + "', '"
					   + "genero = " + jogo.getGenero() + "', "
					   + "preco = " + jogo.getPreco() + ", " 
					   + "quantidade = " + jogo.getQuantidade() + " WHERE id = " + jogo.getID();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM jogo WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}