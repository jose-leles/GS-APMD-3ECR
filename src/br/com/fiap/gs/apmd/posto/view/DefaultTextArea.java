package br.com.fiap.gs.apmd.posto.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class DefaultTextArea extends JTextArea{


	private static final long serialVersionUID = 1L;
	
	private int colunas = 30;
	private int linhas = 5;

	public DefaultTextArea() {
		init();
	}

	private void init() {
		this.setColumns(colunas);
		this.setRows(linhas);
		this.setBorder(new LineBorder(new Color(50, 50, 50)));
		this.setFont(new Font("Arial", Font.BOLD, 16));
		
	}
}
