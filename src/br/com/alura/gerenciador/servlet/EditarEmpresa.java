package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarEmpresa
 */
@WebServlet(name = "editarEmpresa", urlPatterns = { "/editarEmpresa" })
public class EditarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataCriacao = request.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);
		Date data = null;
		SimpleDateFormat format =  new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			data = format.parse(dataCriacao);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		empresa.setData(data);
		
		Banco banco = new Banco();
		banco.editarEmpresaPorId(empresa);
		response.sendRedirect("listaEmpresas");
	}

}
