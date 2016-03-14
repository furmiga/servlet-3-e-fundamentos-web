package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;		
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		//Cookie usuario = getUsuario(req);
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		String mensagem;
		if(usuario == null){
			mensagem = "<DESLOGADO>";
		}else{
			//usuario.setMaxAge(60*10);
			//resp.addCookie(usuario);
			//mensagem = usuario.getValue();
			mensagem = usuario.getEmail();
		}
		System.out.println(" Usuario " + mensagem + "acessou a uri: " + uri);
		
		chain.doFilter(request, response);
	}

//	private Cookie getUsuario(HttpServletRequest req) {
//		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		return cookie;
//	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
