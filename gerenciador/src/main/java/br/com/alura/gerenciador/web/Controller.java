package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa==null)
			throw new IllegalArgumentException("Não foi passada a tarefa a ser executada");
		
		String nomeClasse = "br.com.alura.gerenciador.web." + tarefa;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			Tarefa tipo = (Tarefa)classe.newInstance();
			RequestDispatcher dispatcher = req.getRequestDispatcher(tipo.executa(req, resp));
			dispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
