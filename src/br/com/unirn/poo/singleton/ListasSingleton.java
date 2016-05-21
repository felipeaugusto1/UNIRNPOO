package br.com.unirn.poo.singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.unirn.poo.dao.DAO;
import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.modelo.Professor;
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

	private static ListasSingleton listasSingleton = null;

	public static ListasSingleton getInstance() {
		if (listasSingleton == null)
			listasSingleton = new ListasSingleton();
		return listasSingleton;
	}
	
	
	public void salvarObjetos(){
		try {
			DAO<Usuario> arquivoDao = new DAO<Usuario>();
			arquivoDao.salvar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);
			
			
			DAO<Professor> professorDao = new DAO<Professor>();
			professorDao.salvar(ListasSingleton.getInstance().getListaProfessor(), Professor.class);
			
			DAO<Aluno> alunoDao =  new DAO<Aluno>();
			alunoDao.salvar(ListasSingleton.getInstance().getListaAluno(), Aluno.class);
		} catch (IOException e){
			System.err.println(e.getMessage());
		}
	}
	
	public void recupearObjetos (){
		try {
			DAO<Usuario> arquivoDao = new DAO<Usuario>();
			arquivoDao.recuperar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);
			
			
			DAO<Professor> professorDao = new DAO<Professor>();
			professorDao.recuperar(ListasSingleton.getInstance().getListaProfessor(), Professor.class);
			
			DAO<Aluno> alunoDao =  new DAO<Aluno>();
			alunoDao.recuperar(ListasSingleton.getInstance().getListaAluno(), Aluno.class);
			
		} catch (IOException e){
			
		} catch (ClassNotFoundException e){
			
		}
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

}
