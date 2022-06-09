package br.com.fiap.gs.apmd.posto.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.gs.apmd.posto.controller.PostoController;
import br.com.fiap.gs.apmd.posto.model.Posto;

public class PainelListagem extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String[] colunas = {"id", "nomeMarca", "logradouro", "numero", "estado","cidade", "avaliacao", "tiposPlug", "precoKWh"};
	private DefaultTableModel tableModel = new DefaultTableModel(colunas , 0);
	private JTable tabela = new JTable(tableModel);
	private JScrollPane scrollPane = new JScrollPane(tabela);
	
	private JButton btnApagar = new JButton("Apagar");
	
	private PostoController postoController;
	
	public PainelListagem(PostoController postoController) {
		this.postoController = postoController;
	}
	
	public void init() {
		setLayout(null);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setBounds(0 ,0, 
				800, 300);
		this.add(scrollPane);
		
		btnApagar.setBounds(10, 300, 100, 30);
		btnApagar.addActionListener((ActionEvent e)->{
			int option = JOptionPane.showConfirmDialog(null, "Certeza que deseja apagar?");
			if(option == JOptionPane.YES_OPTION) {
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
				postoController.apagarFilme(Long.parseLong(id,10));				
			}
		});
		this.add(btnApagar);
		atualizarDados();
	}
	
	public void atualizarDados() {
		tableModel.setRowCount(0);
		List<Posto> lista = postoController.listarTodos();
		lista.forEach(filme -> tableModel.addRow(filme.getDataArray()));
	}
	

}
