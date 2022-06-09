package br.com.fiap.gs.apmd.posto.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.gs.apmd.posto.controller.PostoController;
import br.com.fiap.gs.apmd.posto.model.Posto;

public class PainelListagem extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String[] colunas = {"id", "titulo", "sinopse", "genero", "ondeAssistir", "assistido", "qtde estrelas"};
	private DefaultTableModel tableModel = new DefaultTableModel(colunas , 0);
	private JTable tabela = new JTable(tableModel);
	private JScrollPane scrollPane = new JScrollPane(tabela);
	
	private JButton btnApagar = new JButton("Apagar");
	
	private PostoController filmeController;
	
	public PainelListagem(PostoController filmeController) {
		this.filmeController = filmeController;
	}
	
	public void init() {
		setLayout(null);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		 a = ;
		scrollPane.setBounds(0 ,0, 
				800, 300);
		this.add(scrollPane);
		
		btnApagar.setBounds(10, 300, 100, 30);
		btnApagar.addActionListener((ActionEvent e)->{
			String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
			filmeController.apagarFilme(Long.parseLong(id,10));
		});
		this.add(btnApagar);
		atualizarDados();
	}
	
	public void atualizarDados() {
		tableModel.setRowCount(0);
		List<Posto> lista = filmeController.listarTodos();
		lista.forEach(filme -> tableModel.addRow(filme.getDataArray()));
	}
	

}
