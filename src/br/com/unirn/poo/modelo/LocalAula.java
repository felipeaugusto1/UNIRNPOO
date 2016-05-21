package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class LocalAula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2857158367981949918L;
	private String bloco;
	private int capacidadeAlunos;

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getCapacidadeAlunos() {
		return capacidadeAlunos;
	}

	public void setCapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}

}
