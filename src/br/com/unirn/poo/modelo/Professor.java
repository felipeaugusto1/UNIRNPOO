package br.com.unirn.poo.modelo;

public class Professor extends Pessoa {

	private String matricula;

	public Professor(String matricula) {
		super();
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
