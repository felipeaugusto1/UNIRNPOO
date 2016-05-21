package br.com.unirn.poo.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5411960718334881345L;
	private int codigo;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private List<Professor> professores;
	
	public Turma(){
		
	}
	
	public Turma(int codigo, Disciplina disciplina, List<Aluno> alunos, List<Professor> professores) {
		this.codigo = codigo;
		this.disciplina = disciplina;
		this.alunos = alunos;
		this.professores = professores;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
