package br.com.unirn.poo.modelo;

public class Aluno extends Pessoa {

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

}
