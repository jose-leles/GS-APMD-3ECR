package br.com.fiap.gs.apmd.posto.controller;

import java.util.List;

import br.com.fiap.gs.apmd.posto.model.Posto;
import br.com.fiap.gs.apmd.posto.view.Janela;

public class PostoController {

	PostoDAO filmeDAO;
	Janela view;
	
	public PostoController(Janela view) {
		filmeDAO = new PostoDAO();
		this.view = view;
	}
	

	public void mockarDadosIniciais() {
		Posto f = new Posto();
		f.setTitulo("Wanda Vision");
		f.setAssistido(true);
		f.setGenero("Comedia");
		f.setOndeAssistir("Prime Video");
		f.setAvaliacao(5);
	
		filmeDAO.inserir(f);
		
	}

	public List<Posto> listarTodos() {
		return filmeDAO.listarTodos();
	}

	public void salvarFilme(String titulo, String sinopse, String genero, String ondeAssistiu, boolean assistido, int avaliacao) {
		Posto f = new Posto();
		f.setTitulo(titulo);
		f.setSinopse(sinopse);
		f.setAssistido(assistido);
		f.setGenero(genero);
		f.setOndeAssistir(ondeAssistiu);
		f.setAvaliacao(avaliacao);
		
		filmeDAO.inserir(f);
		view.getPainelListagem().atualizarDados();
	}
	
	public void apagarFilme(Long id) {
		Posto f = new Posto();
		f.setId(id);
		
		filmeDAO.apagar(f);
		view.getPainelListagem().atualizarDados();
	}



}
