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

	private JLabel imgFilme = new JLabel(new ImageIcon("src/img/capaPosto.jpg"));
	
	private DefaultLabel lblNomePosto = new DefaultLabel("NomePosto:");
	private DefaultTextField txtNomePosto = new DefaultTextField();
	
	private DefaultLabel lblLogradouro = new DefaultLabel("Logradouro:");
	private DefaultTextField txtLogradouro = new DefaultTextField();
	
	private DefaultLabel lblNumero = new DefaultLabel("Numero:");
	private DefaultTextField txtNumero = new DefaultTextField();
	
	private DefaultLabel lblCidade = new DefaultLabel("Cidade:");
	private DefaultTextField txtCidade = new DefaultTextField();

	private DefaultLabel lblTipoPlugs = new DefaultLabel("Tipos de plug:");

	private DefaultLabel lblStarRatingLabel = new DefaultLabel("Avaliação:");
	StarRater starRatingField = new StarRater(5);
	
	JCheckBox[] jCheckboxsTipoPlug = new JCheckBox[] {
		new JCheckBox("tipo1"),
		new JCheckBox("tipo2"),
		new JCheckBox("CSS2"),
		new JCheckBox("CHAdeMO")
	};
	
	private DefaultLabel lblEstado = new DefaultLabel("Estado:");
	//todos os 27 estados
	private JComboBox<String> cbEstado = new JComboBox<String>(new String[]{
			"Selecione",
			"AC","AL","AP","AM","BA","CE","DF","ES",
			"GO","MA","MT","MS","MG","PA","PB","PR",
			"PE","PI","RJ","RN","RS","RO","RR","SC",
			"SP","SE","TO"
	});
	
	private JButton btnSalvar = new JButton();
	private JButton btnCancelar = new JButton();
	
	private PostoController filmeController;
	
	public PainelCadastroEdicao(PostoController filmeController) {
		setLayout(null);
		this.filmeController = filmeController;
	}
	
	public void init() {
	    
		imgFilme.setBounds(20, 50, 250, 250);
		redimensionarImagem(imgFilme);
		this.add(imgFilme);
		
		/*
		 * Parte do form central 
		*/
		lblNomePosto.setBounds(
				imgFilme.getX() + imgFilme.getWidth() + 25,
				20,
				100,
				15);
		this.add(lblNomePosto);
		txtNomePosto.setBounds(
				lblNomePosto.getX(),
				lblNomePosto.getY()+lblNomePosto.getHeight()+10,
				250,
				29);
		this.add(txtNomePosto);

		lblLogradouro.setBounds(
				txtNomePosto.getX(),
				txtNomePosto.getY()+txtNomePosto.getHeight()+15,
				100,
				15);
		this.add(lblLogradouro);
		txtLogradouro.setBounds(
				lblLogradouro.getX(),
				lblLogradouro.getY()+lblLogradouro.getHeight()+10,
				180,
				29);
		this.add(txtLogradouro);
		
		lblNumero.setBounds(
				lblLogradouro.getX() + txtLogradouro.getWidth()+10,
				lblLogradouro.getY(),
				100,
				15);
		this.add(lblNumero);
		txtNumero.setBounds(
				txtLogradouro.getX() + txtLogradouro.getWidth()+10,
				txtLogradouro.getY(),
				60,
				29);
		this.add(txtNumero);

		lblEstado.setBounds(
				txtLogradouro.getX(),
				txtLogradouro.getY()+txtLogradouro.getHeight()+20,
				100,
				15);
		this.add(lblEstado);
		cbEstado.setBounds(
				lblEstado.getX(),
				lblEstado.getY()+lblEstado.getHeight()+10,
				250,
				29);

		cbEstado.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(cbEstado);
		
		lblCidade.setBounds(
				cbEstado.getX(),
				cbEstado.getY()+cbEstado.getHeight()+15,
				100,
				15);
		this.add(lblCidade);
		txtCidade.setBounds(
				lblCidade.getX(),
				lblCidade.getY()+lblCidade.getHeight()+10,
				250,
				29);
		this.add(txtCidade);
		
		btnSalvar.setBounds(
				txtCidade.getX(),
				txtCidade.getY()+txtCidade.getHeight()+20,
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
		
		lblTipoPlugs.setBounds(
				txtNomePosto.getX() + txtNomePosto.getWidth() + 50,
				lblNomePosto.getY(),
				150,
				15);
		this.add(lblTipoPlugs);
		
		ButtonGroup generoGroup = new ButtonGroup();
		
        for(int i=0; i< jCheckboxsTipoPlug.length; i++) {
        	jCheckboxsTipoPlug[i].setBounds(
        			lblTipoPlugs.getX(),
        			lblTipoPlugs.getY() + lblTipoPlugs.getHeight() + 15 +( 25 * i), // um embaixo do outro
    				150,
    				15);
        	jCheckboxsTipoPlug[i].setFont(new Font("Arial", Font.BOLD, 15));
        	this.add(jCheckboxsTipoPlug[i]);
        }
        int lastIndex = jCheckboxsTipoPlug.length-1; 
        lblStarRatingLabel.setBounds(
        		jCheckboxsTipoPlug[lastIndex].getX(),
        		jCheckboxsTipoPlug[lastIndex].getY() + jCheckboxsTipoPlug[lastIndex].getHeight() + 20,
				150,
				15);
        this.add(lblStarRatingLabel);
        
        starRatingField.setBounds(
        		lblStarRatingLabel.getX(),
        		lblStarRatingLabel.getY() + lblStarRatingLabel.getHeight() + 15,
				150,
				15);
        this.add(starRatingField);


		btnSalvar.addActionListener((ActionEvent e)->{
//			boolean invalido = txtNomePosto.getText().equalsIgnoreCase("");
//			invalido = invalido || txtLogradouro.getText().equalsIgnoreCase("");
//			invalido = invalido || ((String)cbEstado.getSelectedItem()).equalsIgnoreCase("");
//			invalido = invalido || !( jRadioGenero1.isSelected() 
//					|| jRadioGenero2.isSelected() 
//					|| jRadioGenero3.isSelected());
//			invalido = invalido || starRatingField.getSelection() == 0;
//			
//			if(invalido) {
//				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
//				return;
//			}
//			filmeController.salvarFilme(
//					txtTitulo.getText(),
//					txtLogradouro.getText().trim(),
//					(String)cbEstado.getSelectedItem(),
//					jRadioGenero1.isSelected() ? jRadioGenero1.getText()
//							: jRadioGenero2.isSelected() ? jRadioGenero2.getText()
//							: jRadioGenero3.isSelected() ? jRadioGenero3.getText() 
//							: "Nenhum",
//					assistido.isSelected(),
//					starRatingField.getSelection()
//					);	
		});
		btnCancelar.addActionListener((ActionEvent e)->{
			txtNomePosto.setText("");
			txtLogradouro.setText("");
			cbEstado.setSelectedIndex(0);
			generoGroup.clearSelection();
			starRatingField.setSelection(0);
//			assistido.setSelected(false);
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
