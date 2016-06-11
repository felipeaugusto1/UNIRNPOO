package br.com.unirn.poo.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

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
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author felipe
 *
 */
public class MenuListarObjetos extends MenuGeneric<Usuario> {

	private static final int ID_LISTAR_ALUNOS = 1;
	private static final int ID_LISTAR_APLICATIVOS = 2;
	private static final int ID_LISTAR_DISCIPLINAS = 3;
	private static final int ID_LISTAR_HORARIOS = 4;
	private static final int ID_LISTAR_LOCAIS_DE_AULA = 5;
	private static final int ID_LISTAR_PROFESSORES = 6;
	private static final int ID_LISTAR_PROJETORES = 7;
	private static final int ID_LISTAR_RESERVAS = 8;
	private static final int ID_LISTAR_TURMAS = 9;
	private static final int ID_LISTAR_USUARIOS = 10;
	private static final int ID_MENU_VOLTAR = 11;

	private int opcao;

	public MenuListarObjetos() {
		super();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println(ID_LISTAR_ALUNOS + " - Listar Alunos");
		System.out.println(ID_LISTAR_APLICATIVOS + " - Listar Aplicativos");
		System.out.println(ID_LISTAR_DISCIPLINAS + " - Listar Disciplinas");
		System.out.println(ID_LISTAR_HORARIOS + " - Listar Horários");
		System.out.println(ID_LISTAR_LOCAIS_DE_AULA + " - Listar Locais de Aula");
		System.out.println(ID_LISTAR_PROFESSORES + " - Listar Professores");
		System.out.println(ID_LISTAR_PROJETORES + " - Listar Projetores");
		System.out.println(ID_LISTAR_RESERVAS + " - Listar Reservas");
		System.out.println(ID_LISTAR_TURMAS + " - Listar Turmas");
		System.out.println(ID_LISTAR_USUARIOS + " - Listar Usuários");

		listenerUsuario();
	}

	private void listenerUsuario() {
		System.out.println("Selecione uma opção: ");
		try {
			opcao = scanner.nextInt();
		} catch (InputMismatchException e) {
			opcaoInvalida();
		}

		switch (opcao) {
		case ID_LISTAR_ALUNOS:
			for (Aluno aluno : ListasSingleton.getInstance().getListaAluno()) {
				System.out.println(aluno);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_APLICATIVOS:
			for (Aplicativo aplicativo : ListasSingleton.getInstance().getListaAplicativo()) {
				System.out.println(aplicativo);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_DISCIPLINAS:
			for (Disciplina disciplina : ListasSingleton.getInstance().getListaDisciplina()) {
				System.out.println(disciplina);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_HORARIOS:
			for (Horario horario : ListasSingleton.getInstance().getListaHorario()) {
				System.out.println(horario);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_LOCAIS_DE_AULA:
			for (LocalAula localAula : ListasSingleton.getInstance().getListaLocalAula()) {
				System.out.println(localAula);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_PROFESSORES:
			for (Professor professor : ListasSingleton.getInstance().getListaProfessor()) {
				System.out.println(professor);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_PROJETORES:
			for (Projetor projetor : ListasSingleton.getInstance().getListaProjetor()) {
				System.out.println(projetor);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_RESERVAS:
			for (Reserva reserva : ListasSingleton.getInstance().getListaReserva()) {
				System.out.println(reserva);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_TURMAS:
			for (Turma turma : ListasSingleton.getInstance().getListaTurma()) {
				System.out.println(turma);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_LISTAR_USUARIOS:
			for (Usuario usuario : ListasSingleton.getInstance().getListaUsuario()) {
				System.out.println(usuario);
			}
			
			super.solicitarProximaAcao();
			break;
		case ID_MENU_VOLTAR:
			new Menu();
			break;
		default:
			opcaoInvalida();
		}
	}

	@Override
	public void opcaoInvalida() {
		System.out.println("\n Opção inválida. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		scanner = new Scanner(System.in);
		montarMenu();
	}

}
