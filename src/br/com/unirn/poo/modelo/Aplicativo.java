package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Aplicativo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8680639356628226062L;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
