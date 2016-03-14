package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa{

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String nome = req.getParameter("nome");
//		req.setAttribute("nome", nome);
//		Empresa empresa = new Empresa(nome );
//		EmpresaDAO dao = new EmpresaDAO();
//		dao.adiciona(empresa );
//		
//		RequestDispatcher dipatcher = req.getRequestDispatcher("/WEB-INF/paginas/NovaEmpresa.jsp");
//		dipatcher.forward(req, resp);
//		//PrintWriter saida = resp.getWriter();
//		//saida.println("Empresa " + nome + "adicionado com sucesso");
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		req.setAttribute("nome", nome);
		Empresa empresa = new Empresa(nome );
		EmpresaDAO dao = new EmpresaDAO();
		dao.adiciona(empresa );
		
		return "/WEB-INF/paginas/NovaEmpresa.jsp";
	}
	
}
