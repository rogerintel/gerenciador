package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.dominio.Banco;
import br.com.alura.gerenciador.dominio.Empresa;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String header = request.getHeader("Accept");

		if (header.contains("json")) {

			response.setContentType("application/json");
			response.getWriter().print(new Gson().toJson(new Banco().getEmpresas()));
		} else if (header.contains("xml")) {

			response.setContentType("application/xml");
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			response.getWriter().print(xstream.toXML(new Banco().getEmpresas()));
		} else {

			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	}

}
