package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 793876315367594414L;
	private String nome;
	private String sigla;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
