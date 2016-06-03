package br.com.unirn.poo.singleton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import br.com.unirn.poo.dao.DAO;
import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.modelo.Aplicativo;
import br.com.unirn.poo.modelo.Disciplina;
import br.com.unirn.poo.modelo.Horario;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.modelo.Projetor;
import br.com.unirn.poo.modelo.Reserva;
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
	private List<Projetor> listaProjetor = new ArrayList<Projetor>();
	private List<Aplicativo> listaAplicativo = new ArrayList<Aplicativo>();
	private List<LocalAula> listaLocalAula = new ArrayList<LocalAula>();
	private List<Reserva> listaReserva = new ArrayList<Reserva>();

	private static ListasSingleton listasSingleton = null;

	public static ListasSingleton getInstance() {
		if (listasSingleton == null)
			listasSingleton = new ListasSingleton();
		return listasSingleton;
	}

	public void salvarObjetos() {
		try {
			DAO<Usuario> arquivoDao = new DAO<Usuario>();
			arquivoDao.salvar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);

			DAO<Professor> professorDao = new DAO<Professor>();
			professorDao.salvar(ListasSingleton.getInstance().getListaProfessor(), Professor.class);
			
			DAO<Projetor> projetorDao = new DAO<Projetor>();
			projetorDao.salvar(ListasSingleton.getInstance().getListaProjetor(), Projetor.class);

			DAO<Aluno> alunoDao = new DAO<Aluno>();
			alunoDao.salvar(ListasSingleton.getInstance().getListaAluno(), Aluno.class);
			
			DAO<Turma> turmaDao = new DAO<Turma>();
			turmaDao.salvar(ListasSingleton.getInstance().getListaTurma(), Turma.class);
			
			DAO<Usuario> usuarioDao = new DAO<Usuario>();
			usuarioDao.salvar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);
			
			DAO<Horario> horarioDao = new DAO<Horario>();
			horarioDao.salvar(ListasSingleton.getInstance().getListaHorario(), Horario.class);
			
			DAO<Aplicativo> aplicativoDao = new DAO<Aplicativo>();
			aplicativoDao.salvar(ListasSingleton.getInstance().getListaAplicativo(), Aplicativo.class);
			
			DAO<LocalAula> localDao = new DAO<LocalAula>();
			localDao.salvar(ListasSingleton.getInstance().getListaLocalAula(), LocalAula.class);
			
			DAO<Reserva> reservaDao = new DAO<Reserva>();
			reservaDao.salvar(ListasSingleton.getInstance().getListaReserva(), Reserva.class);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void recuperarObjetos() {
		try {
			DAO<Usuario> arquivoDao = new DAO<Usuario>();
			arquivoDao.recuperar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);

			DAO<Professor> professorDao = new DAO<Professor>();
			professorDao.recuperar(ListasSingleton.getInstance().getListaProfessor(), Professor.class);
			
			DAO<Projetor> projetorDao = new DAO<Projetor>();
			projetorDao.recuperar(ListasSingleton.getInstance().getListaProjetor(), Projetor.class);

			DAO<Aluno> alunoDao = new DAO<Aluno>();
			alunoDao.recuperar(ListasSingleton.getInstance().getListaAluno(), Aluno.class);

			DAO<Turma> turmaDao = new DAO<Turma>();
			turmaDao.recuperar(ListasSingleton.getInstance().getListaTurma(), Turma.class);
			
			DAO<Usuario> usuarioDao = new DAO<Usuario>();
			usuarioDao.recuperar(ListasSingleton.getInstance().getListaUsuario(), Usuario.class);
			
			DAO<Horario> horarioDao = new DAO<Horario>();
			horarioDao.recuperar(ListasSingleton.getInstance().getListaHorario(), Horario.class);
			
			DAO<Aplicativo> aplicativoDao = new DAO<Aplicativo>();
			aplicativoDao.recuperar(ListasSingleton.getInstance().getListaAplicativo(), Aplicativo.class);
			
			DAO<LocalAula> localDao = new DAO<LocalAula>();
			localDao.recuperar(ListasSingleton.getInstance().getListaLocalAula(), LocalAula.class);
			
			DAO<Reserva> reservaDao = new DAO<Reserva>();
			reservaDao.recuperar(ListasSingleton.getInstance().getListaReserva(), Reserva.class);
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

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

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public List<Horario> getListaHorario() {
		return listaHorario;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public List<Projetor> getListaProjetor() {
		return listaProjetor;
	}

	public List<Aplicativo> getListaAplicativo() {
		return listaAplicativo;
	}

	public List<LocalAula> getListaLocalAula() {
		return listaLocalAula;
	}
	
	public List<Reserva> getListaReserva (){
		return listaReserva;
	}

}
