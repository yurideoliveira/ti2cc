package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogoDAO extends DAO{
	
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
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO jogo (codigo, nome, genero, preco) "
				       + "VALUES ("+jogo.getCodigo()+ ", '" + jogo.getNome() + "', '"  
				       + jogo.getGenero() + "', " + jogo.getPreco() + ");";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean update(Jogo jogo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE jogo SET nome = '" + jogo.getNome() + "', genero = '"  
					   + jogo.getGenero() + "', preco = '" + jogo.getPreco() + "'"
					   + " WHERE codigo = " + jogo.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM jogo WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Jogo> get() {	
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogo ORDER BY codigo";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Jogo u = new Jogo(rs.getInt("codigo"), rs.getString("nome"), rs.getString("genero"), rs.getDouble("preco"));
	            jogos.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogos;
	}

}
