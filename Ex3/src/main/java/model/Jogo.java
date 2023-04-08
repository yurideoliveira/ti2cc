package model;

public class Jogo {
	private int id;
	private String genero;
	private String nome;
	private float preco;
	private int quantidade;
	
	public Jogo() {
		id = -1;
		genero = "";
		nome = "";
		preco = 0.00F;
		quantidade = 0;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jogo(int id, String genero, String nome, float preco, int quantidade) {
		setId(id);
		setGenero(genero);
		setNome(nome);
		setPreco(preco);
		setQuantidade(quantidade);

	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Jogo: " + nome + "	Gênero: " + genero + "   Preço: R$" + preco + "   Quantidade.: " + quantidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Jogo) obj).getID());
	}	
}