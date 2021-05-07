package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	private static int sequence = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(sequence++);
		empresa.setNome("Impacto Virtual");
		lista.add(empresa);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(sequence++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresaPorId(Integer id) {
		Iterator<Empresa> iterator = lista.iterator();

		while (iterator.hasNext()) {
			if (iterator.next().getId() == id)
				iterator.remove();
		}
	}
	
	public void editarEmpresaPorId(Empresa emp) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == emp.getId()) {
				empresa.setNome(emp.getNome());
				empresa.setData(emp.getData());
			}
				
		}
	}

	public Empresa getEmpresa(int id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) 
				return empresa;
		}
		return null;
		
	}

}
