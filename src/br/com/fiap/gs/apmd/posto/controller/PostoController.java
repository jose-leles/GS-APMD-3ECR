package br.com.fiap.gs.apmd.posto.controller;

import java.util.Arrays;
import java.util.List;

import br.com.fiap.gs.apmd.posto.model.Posto;
import br.com.fiap.gs.apmd.posto.view.Janela;

public class PostoController {

	PostoDAO postoDAO;
	Janela view;
	
	public PostoController(Janela view) {
		postoDAO = new PostoDAO();
		this.view = view;
	}
	

	public void mockarDadosIniciais() {
		Posto f = new Posto();
		f.setNomeMarca("Shell");
		f.setLogradouro("R. Dr. Martinho da Vila");
		f.setNumero("62A");
		f.setEstado("SP");
		f.setCidade("Queluz");
		f.setAvaliacao(5);
		f.setPrecoKWh(100.5);
		f.setTiposPlug(Arrays.asList("tipo1","tipo2","CSS2","CHAdeMO"));
	
		postoDAO.inserir(f);
		
	}

	public List<Posto> listarTodos() {
		return postoDAO.listarTodos();
	}

	public void salvarPosto(String nomeMarca, String logradouro, String numero, String estado, String cidade, double precoKWh, int avaliacao, String[] tiposPlug) {
		Posto f = new Posto();
		f.setNomeMarca(nomeMarca);
		f.setLogradouro(logradouro);
		f.setNumero(numero);
		f.setEstado(estado);
		f.setCidade(cidade);
		f.setAvaliacao(avaliacao);
		f.setPrecoKWh(precoKWh);
		f.setTiposPlug(Arrays.asList(tiposPlug));
		
		postoDAO.inserir(f);
		view.getPainelListagem().atualizarDados();
	}
	
	public void apagarPosto(Long id) {
		Posto f = new Posto();
		f.setId(id);
		
		postoDAO.apagar(f);
		view.getPainelListagem().atualizarDados();
	}



}
