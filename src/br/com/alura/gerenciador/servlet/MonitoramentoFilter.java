package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");
		long antes = System.currentTimeMillis();
		String acao = request.getParameter("acao");
		chain.doFilter(request, response);
		long depois = System.currentTimeMillis();
		System.out.println("A ação " + acao + " durou " + (depois - antes) + " milisegundos.");
	}
}
