package br.com.unirn.poo.modelo;

import java.io.Serializable;
import java.util.List;

public class Laboratorio extends LocalAula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8902643219076425286L;
	private String nome;
	private Projetor projetor;
	private List<Aplicativo> aplicativos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Projetor getProjetor() {
		return projetor;
	}

	public void setProjetor(Projetor projetor) {
		this.projetor = projetor;
	}

	public List<Aplicativo> getAplicativos() {
		return aplicativos;
	}

	public void setAplicativos(List<Aplicativo> aplicativos) {
		this.aplicativos = aplicativos;
	}

}
