package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet(name = "novaEmpresa", urlPatterns = { "/novaEmpresa" })
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NovaEmpresaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");

		String nomeEmpresa = request.getParameter("nome");
		String dataCriacao = request.getParameter("data");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = format.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setData(data);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("listaEmpresas");

	}

}
