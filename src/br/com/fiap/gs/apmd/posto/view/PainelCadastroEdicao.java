package br.com.fiap.gs.apmd.posto.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.com.fiap.gs.apmd.posto.controller.PostoController;

public class PainelCadastroEdicao extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel imgFilme = new JLabel(new ImageIcon("src/img/capaFilme.jpg"));
	
	private DefaultLabel lblTitulo = new DefaultLabel("Titulo:");
	private DefaultTextField txtTitulo = new DefaultTextField();
	
	private DefaultLabel lblSinopse = new DefaultLabel("Sinopse:");
	private DefaultTextArea txtSinopse = new DefaultTextArea();

	private DefaultLabel lblGenero = new DefaultLabel("Genero:");
	private JComboBox<String> cbGenero = new JComboBox<String>(new String[]{
			"Selecione",
			"Terror",
			"Aventura",
			"Animacao",
			"Suspense"
		});
	

	private DefaultLabel lblOndeAssLabel = new DefaultLabel("Onde assistir:");

	private DefaultLabel lblStarRatingLabel = new DefaultLabel("Avaliação:");
	
	private JButton btnSalvar = new JButton();
	private JButton btnCancelar = new JButton();
	
	private PostoController filmeController;
	
	public PainelCadastroEdicao(PostoController filmeController) {
		setLayout(null);
		this.filmeController = filmeController;
	}
	
	public void init() {
	    
		imgFilme.setBounds(40, 35, 180, 250);
		redimensionarImagem(imgFilme);
		this.add(imgFilme);
		
		/*
		 * Parte do form central 
		*/
		lblTitulo.setBounds(
				imgFilme.getX() + imgFilme.getWidth() + 50,
				28,
				100,
				15);
		this.add(lblTitulo);
		txtTitulo.setBounds(
				lblTitulo.getX(),
				lblTitulo.getY()+lblTitulo.getHeight()+10,
				250,
				29);
		this.add(txtTitulo);

		lblSinopse.setBounds(
				txtTitulo.getX(),
				txtTitulo.getY()+txtTitulo.getHeight()+20,
				100,
				15);
		this.add(lblSinopse);
		txtSinopse.setBounds(
				lblSinopse.getX(),
				lblSinopse.getY()+lblSinopse.getHeight()+10,
				250,
				60);
		this.add(txtSinopse);

		lblGenero.setBounds(
				txtSinopse.getX(),
				txtSinopse.getY()+txtSinopse.getHeight()+20,
				100,
				15);
		this.add(lblGenero);
		cbGenero.setBounds(
				lblGenero.getX(),
				lblGenero.getY()+lblGenero.getHeight()+10,
				250,
				29);

		cbGenero.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(cbGenero);
		
		btnSalvar.setBounds(
				cbGenero.getX(),
				cbGenero.getY()+cbGenero.getHeight()+20,
				100,
				38);
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalvar.setText("Salvar");
		this.add(btnSalvar);
		
		btnCancelar.setBounds(
				btnSalvar.getX()+btnSalvar.getWidth()+15,
				btnSalvar.getY(),
				140,
				38);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setText("Cancelar");
		this.add(btnCancelar);
		
		/*
		 * Parte do form lateral 
		*/
		
		lblOndeAssLabel.setBounds(
				txtTitulo.getX() + txtTitulo.getWidth() + 50,
				lblTitulo.getY(),
				150,
				15);
		this.add(lblOndeAssLabel);
		
		ButtonGroup generoGroup = new ButtonGroup();
		
        JRadioButton jRadioGenero1 = new JRadioButton();
        jRadioGenero1.setText("Netflix");
        jRadioGenero1.setBounds(
        		lblOndeAssLabel.getX(),
        		lblOndeAssLabel.getY() + lblOndeAssLabel.getHeight() + 15,
				150,
				15);

        jRadioGenero1.setFont(new Font("Arial", Font.BOLD, 15));
        
        generoGroup.add(jRadioGenero1);
        
        JRadioButton jRadioGenero2 = new JRadioButton();
        jRadioGenero2.setText("Prime Video");
        jRadioGenero2.setBounds(
        		jRadioGenero1.getX(),
        		jRadioGenero1.getY() + jRadioGenero1.getHeight() + 10,
				150,
				15);

        jRadioGenero2.setFont(new Font("Arial", Font.BOLD, 15));
        
        generoGroup.add(jRadioGenero2);
        
        JRadioButton jRadioGenero3 = new JRadioButton();
        jRadioGenero3.setText("Pirate Bay");
        jRadioGenero3.setBounds(
        		jRadioGenero2.getX(),
        		jRadioGenero2.getY() + jRadioGenero2.getHeight() + 10,
				150,
				15);

        jRadioGenero3.setFont(new Font("Arial", Font.BOLD, 15));
        
        generoGroup.add(jRadioGenero3);
        
        this.add(jRadioGenero1);
        this.add(jRadioGenero2);
        this.add(jRadioGenero3);
        
        JCheckBox assistido = new JCheckBox("Assistido");
        assistido.setBounds(
        		jRadioGenero3.getX(),
        		jRadioGenero3.getY() + jRadioGenero3.getHeight() + 20,
				150,
				15);
        assistido.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(assistido);
        

        lblStarRatingLabel.setBounds(
        		assistido.getX(),
        		assistido.getY() + assistido.getHeight() + 20,
				150,
				15);
        this.add(lblStarRatingLabel);
        
        StarRater starRatingField = new StarRater(5);
        starRatingField.setBounds(
        		lblStarRatingLabel.getX(),
        		lblStarRatingLabel.getY() + lblStarRatingLabel.getHeight() + 15,
				150,
				15);
        this.add(starRatingField);


		btnSalvar.addActionListener((ActionEvent e)->{
			boolean invalido = txtTitulo.getText().equalsIgnoreCase("");
			invalido = invalido || txtSinopse.getText().equalsIgnoreCase("");
			invalido = invalido || ((String)cbGenero.getSelectedItem()).equalsIgnoreCase("");
			invalido = invalido || !( jRadioGenero1.isSelected() 
					|| jRadioGenero2.isSelected() 
					|| jRadioGenero3.isSelected());
			invalido = invalido || starRatingField.getSelection() == 0;
			
			if(invalido) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				return;
			}
			filmeController.salvarFilme(
					txtTitulo.getText(),
					txtSinopse.getText().trim(),
					(String)cbGenero.getSelectedItem(),
					jRadioGenero1.isSelected() ? jRadioGenero1.getText()
							: jRadioGenero2.isSelected() ? jRadioGenero2.getText()
							: jRadioGenero3.isSelected() ? jRadioGenero3.getText() 
							: "Nenhum",
					assistido.isSelected(),
					starRatingField.getSelection()
					);	
		});
		btnCancelar.addActionListener((ActionEvent e)->{
			txtTitulo.setText("");
			txtSinopse.setText("");
			cbGenero.setSelectedIndex(0);
			generoGroup.clearSelection();
			starRatingField.setSelection(0);
			assistido.setSelected(false);
		});
		setVisible(true);
	}
	
	public void redimensionarImagem(JLabel imagem) {
		imagem.setBounds(imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight());
		ImageIcon myImage = (ImageIcon) imagem.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(imagem.getWidth(), imagem.getHeight(),Image.SCALE_SMOOTH);
        imagem.setIcon( new ImageIcon(newImg) );
	}
}
