package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dominio.Banco;
import br.com.alura.gerenciador.dominio.Usuario;

public class Login implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"));
		if (new Banco().existeUsusario(usuario)) {
			request.getSession().setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		return "redirect:entrada?acao=LoginForm";
	}

}
