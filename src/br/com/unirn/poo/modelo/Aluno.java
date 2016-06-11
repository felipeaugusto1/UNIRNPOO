package br.com.unirn.poo.modelo;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9113839496640855265L;
	private String matricula;
	private String curso;

	public Aluno(String nome, String cpf, String telefone, String matricula, String curso) {
		super(nome, cpf, telefone);
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", curso=" + curso + "]";
	}

}
