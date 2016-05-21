package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 213920099976873015L;
	private String matricula;

	public Professor(String nome, String cpf, String telefone, String matricula) {
		super(nome, cpf, telefone);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
