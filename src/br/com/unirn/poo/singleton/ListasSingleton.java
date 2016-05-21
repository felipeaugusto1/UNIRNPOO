package br.com.unirn.poo.singleton;

import java.util.ArrayList;
import java.util.List;

import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.modelo.Disciplina;
import br.com.unirn.poo.modelo.Horario;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.modelo.Usuario;

/**
 * Classe que utiliza padrão Singleton, para no final de todo o processamento,
 * recuperar todas as listas cadastradas dos outros processadores, e gravar em
 * um arquivo.
 * 
 * @author felipe
 *
 */
public class ListasSingleton {

	private List<Usuario> listaUsuario = new ArrayList<Usuario>();
	private List<Professor> listaProfessor = new ArrayList<Professor>();
	private List<Aluno> listaAluno = new ArrayList<Aluno>();
	private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	private List<Horario> listaHorario = new ArrayList<Horario>();
	private List<Turma> listaTurma = new ArrayList<Turma>();

	private static ListasSingleton listasSingleton = null;

	public static ListasSingleton getInstance() {
		if (listasSingleton == null)
			listasSingleton = new ListasSingleton();
		return listasSingleton;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public List<Professor> getListaProfessor() {
		return listaProfessor;
	}

	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public List<Horario> getListaHorario() {
		return listaHorario;
	}
	
	public List<Turma> getListaTurma() {
		return listaTurma;
	}

}
