package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {

	private static final long serialVersionUID = -5640846148829616329L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String valor = req.getParameter("filtro");
		EmpresaDAO dao = new EmpresaDAO();
		Collection<Empresa> empresas = dao.buscaPorSimilaridade(valor);
		PrintWriter writer = resp.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<ul>");
		for (Empresa empresa : empresas) {
			writer.print("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		writer.print("</ul>");
		writer.print("</body>");
		writer.print("</html>");
	}

}
