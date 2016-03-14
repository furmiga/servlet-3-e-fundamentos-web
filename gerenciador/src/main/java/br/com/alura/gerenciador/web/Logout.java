package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/logout")
public class Logout implements Tarefa{

	private static final long serialVersionUID = 697426254938121928L;

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		//PrintWriter writer = resp.getWriter();
//		//if(cookie!=null){
//		//	cookie.setMaxAge(0);
//		//	resp.addCookie(cookie);
//		//}
//		HttpSession session = req.getSession();
//		session.removeAttribute("usuarioLogado");
//		//writer.println("<html><body>Logout efetuado</body></html>");
//		//resp.sendRedirect("logout.html");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
//		dispatcher.forward(req, resp);
//	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}
	
}
