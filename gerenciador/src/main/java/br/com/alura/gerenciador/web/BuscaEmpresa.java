package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa {
	
	private static final long serialVersionUID = -5640846148829616329L;

	
	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}
	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		System.out.println("Criando uma Servlet do tipo BuscaEmpresa " + this);
//	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String valor = req.getParameter("filtro");
//		EmpresaDAO dao = new EmpresaDAO();
//		Collection<Empresa> empresas = dao.buscaPorSimilaridade(valor);
//		req.setAttribute("empresas", empresas);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
//		dispatcher.forward(req, resp);
//
//	}
	
//	@Override
//	public void destroy() {
//		super.destroy();
//		System.out.println("Destruindo uma Servlet do tipo BuscaEmpresa " + this);
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String valor = req.getParameter("filtro");
		EmpresaDAO dao = new EmpresaDAO();
		Collection<Empresa> empresas = dao.buscaPorSimilaridade(valor);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
