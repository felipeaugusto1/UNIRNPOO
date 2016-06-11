package br.com.unirn.poo.modelo;

import java.io.Serializable;
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
	private Horario horario;

	public Turma() {

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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", disciplina=" + disciplina + ", alunos=" + alunos + ", professores="
				+ professores + ", horario=" + horario + "]";
	}

}
