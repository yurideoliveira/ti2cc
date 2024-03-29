package app;

import static spark.Spark.*;

import service.JogoService;


public class Aplicacao {
	
	private static JogoService jogoService = new JogoService();
	
    public static void main(String[] args) {
    	
        port(6789);
        
        staticFiles.location("/public");
        
        post("/jogo/insert", (request, response) -> jogoService.insert(request, response));

        get("/jogo/:id", (request, response) -> jogoService.get(request, response));
        
        get("/jogo/list/:orderby", (request, response) -> jogoService.getAll(request, response));

        get("/jogo/update/:id", (request, response) -> jogoService.getToUpdate(request, response));
        
        post("/jogo/update/:id", (request, response) -> jogoService.update(request, response));
           
        get("/jogo/delete/:id", (request, response) -> jogoService.delete(request, response));

    }
}