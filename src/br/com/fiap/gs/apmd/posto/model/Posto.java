package br.com.fiap.gs.apmd.posto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeMarca;
	private String logradouro;
	private String numero; //exemplo 23A
	private String estado;
	private String cidade;
	private int avaliacao;
	private String tiposPlug;
	private double precoKWh;
	
	
	
	public Vector<String> getDataArray() {
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(nomeMarca);
		data.add(logradouro);
		data.add(numero);
		data.add(estado);
		data.add(cidade);
		data.add(avaliacao+"");
		data.add(tiposPlug);
		data.add(precoKWh+"");
		
		return data;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNomeMarca() { return nomeMarca; }
	public void setNomeMarca(String nomeMarca) { this.nomeMarca = nomeMarca; }
	
	public String getLogradouro() { return logradouro; }
	public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

	public String getNumero() { return numero; }
	public void setNumero(String numero) { this.numero = numero; }

	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
	
	public String getCidade() { return cidade; }
	public void setCidade(String cidade) { this.cidade = cidade; }

	public List<String> getTiposPlug() { return Arrays.asList(tiposPlug.split(", ")); }
	public void setTiposPlug(List<String> tiposPlug) { this.tiposPlug = String.join(", ", tiposPlug); }
	
	public double getPrecoKWh() { return precoKWh; }
	public void setPrecoKWh(double precoKWh) { this.precoKWh = precoKWh; }

	public int getAvaliacao() { return avaliacao; }
	public void setAvaliacao(int avaliacao) { this.avaliacao = avaliacao; }
	
	

}
