package br.com.fiap.gs.apmd.posto.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.fiap.gs.apmd.posto.controller.PostoController;

public class Janela extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane abas = new JTabbedPane();
	
	private PostoController postoController = new PostoController(this);
	
	private PainelCadastroEdicao painelCadastroEdicao = new PainelCadastroEdicao(postoController);
	private PainelListagem painelListagem = new PainelListagem(postoController);
	
	public Janela() {
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public void init() {
		postoController.mockarDadosIniciais();
		
		painelCadastroEdicao.init();
		painelListagem.init();
		
		abas.add(painelCadastroEdicao, "Cadastro");
		abas.add(painelListagem, "Listagem" );
		
		add(abas);
		
		setVisible(true);
	}

	
	public PainelListagem getPainelListagem() { return painelListagem; 	}
	public PainelCadastroEdicao getPainelCadastroEdicao() { return painelCadastroEdicao; 	}

	
	

}
