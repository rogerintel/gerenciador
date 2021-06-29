package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AutorizacaoFilter");
		String paramAcao = request.getParameter("acao");

		if (!(paramAcao.equals("Login") || paramAcao.equals("LoginForm"))
				&& ((HttpServletRequest) request).getSession().getAttribute("usuarioLogado") == null) {
			((HttpServletResponse) response).sendRedirect("entrada?acao=LoginForm");
			return;
		}

		chain.doFilter(request, response);
	}

}
