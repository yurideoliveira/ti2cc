package model;

public class Jogo {
	private int codigo;
	private String nome;
	private String genero;
	private double preco;
	
	public Jogo() {
		this.codigo = -1;
		this.nome = "";
		this.genero = "";
		this.preco = 0.0;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Jogo(int codigo, String nome, String genero, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Jogo [codigo=" + codigo + ", nome=" + nome + ", genero=" + genero + ", preco=" + preco+ "]";
	}	
}
