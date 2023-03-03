package app;

import dao.DAO;
import java.util.List;
import dao.JogoDAO;
import model.Jogo;
import MyIO.MyIO;

public class Aplicacao {
	
	public static void inserir() {
		
		int codigo = 0;
		String nome = "";
		String genero = "";
		Double preco = 0.0;
		
		JogoDAO jogoDAO = new JogoDAO();
		Jogo jogo = new Jogo();
		codigo = MyIO.readInt("Digite o codigo do jogo: ");
		nome = MyIO.readLine("Digite o nome do jogo");
		genero = MyIO.readLine("Digite o genero do jogo");
		preco = MyIO.readDouble("Digite o preco do jogo");
		jogo.setCodigo(codigo);
		jogo.setGenero(genero);
		jogo.setNome(nome);
		jogo.setPreco(preco);
		jogoDAO.insert(jogo);
		jogoDAO.close();
		
	}
	
	public static void listar() {
		
		JogoDAO jogoDAO = new JogoDAO();
		
		List<Jogo> jogos = jogoDAO.get();
		for (Jogo u: jogos) {
			MyIO.println(u.toString());
		}
		jogoDAO.close();
		
	}
	
	public static void atualizar() {
		
		int codigo = 0;
		String nome = "";
		String genero = "";
		Double preco = 0.0;
		
		JogoDAO jogoDAO = new JogoDAO();
		Jogo jogo = new Jogo();
		codigo = MyIO.readInt("Digite o codigo do jogo a ser alterado: ");
		nome = MyIO.readLine("Digite o nome do jogo");
		genero = MyIO.readLine("Digite o genero do jogo");
		preco = MyIO.readDouble("Digite o preco do jogo");
		jogo.setCodigo(codigo);
		jogo.setGenero(genero);
		jogo.setNome(nome);
		jogo.setPreco(preco);
		jogoDAO.update(jogo);
		
		jogoDAO.close();
		
	}
	
	public static void excluir() {
		
		int codigo = 0;

		JogoDAO jogoDAO = new JogoDAO();
		codigo = MyIO.readInt("Digite o codigo do jogo a ser apagado: ");

		jogoDAO.delete(codigo);
		
		jogoDAO.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		DAO dao = new DAO();
		dao.conectar();
		
		int opcao = 0;
		
		do {
			MyIO.println("Digite uma das opcoes abaixo:");
			MyIO.println("1) Inserir");
			MyIO.println("2) Listar");
			MyIO.println("3) Atualizar");
			MyIO.println("4) Excluir");
			MyIO.println("5) Sair");
			
			opcao = MyIO.readInt();
			
			switch (opcao) {

			case 1:

				inserir();
				
				break;

			case 2:

				listar();

				break;

			case 3:

				atualizar();

				break;
			
			case 4:

				excluir();

				break;
				
			case 5:


				break;

			default:

				MyIO.println("ERRO: Digite uma das opcoes!");

			}
		
		}while(opcao != 5);
		
	}
}