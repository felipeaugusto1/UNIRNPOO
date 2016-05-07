package br.com.unirn.poo.modelo;

public class Professor extends Pessoa {

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
