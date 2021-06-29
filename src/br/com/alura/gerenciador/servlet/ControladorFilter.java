package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws ServletException, IOException {

		System.out.println("ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAcao = request.getParameter("acao");

		String nome = null;

		try {
			Acao acao = (Acao) Class.forName("br.com.alura.gerenciador.acao." + paramAcao).getDeclaredConstructor()
					.newInstance();
			nome = acao.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}

		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}

}
