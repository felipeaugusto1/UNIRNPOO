package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Sala extends LocalAula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813550006864033457L;
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
