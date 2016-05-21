package br.com.unirn.poo.menu;

import java.util.InputMismatchException;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author felipe
 *
 */
public class Menu extends MenuGeneric<Object> {

	private static final int ID_MENU_CADASTRAR_USUARIO = 1;
	private static final int ID_MENU_CADASTRAR_PROFESSOR = 2;
	private static final int ID_MENU_CADASTRAR_ALUNO = 3;
	private static final int ID_MENU_CADASTRAR_DISCIPLINA = 4;
	private static final int ID_MENU_CADASTRAR_TURMA = 5;
	private static final int ID_MENU_CADASTRAR_HORARIO = 6;
	private static final int ID_MENU_CADASTRAR_SALA = 7;
	private static final int ID_MENU_CADASTRAR_LABORATORIO = 8;
	private static final int ID_MENU_CADASTRAR_APLICATIVO = 9;
	private static final int ID_MENU_CADASTRAR_PROJETOR = 10;
	private static final int ID_MENU_CADASTRAR_RESERVA = 11;
	private static final int ID_MENU_SAIR = 12;

	private int opcao;
	
	public Menu() {
		super();
		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-----------------------------------------------------");
		System.out.println("----------------- SISTEMA ACADÊMICO -----------------");
		System.out.println("----------------------------------------------------- \n");
		System.out.println(ID_MENU_CADASTRAR_USUARIO + " - Cadastrar Usuário");
		System.out.println(ID_MENU_CADASTRAR_PROFESSOR + " - Cadastrar Professor");
		System.out.println(ID_MENU_CADASTRAR_ALUNO + " - Cadastrar Aluno");
		System.out.println(ID_MENU_CADASTRAR_DISCIPLINA + " - Cadastrar Disciplina");
		System.out.println(ID_MENU_CADASTRAR_TURMA + " - Cadastrar Turma");
		System.out.println(ID_MENU_CADASTRAR_HORARIO + " - Cadastrar Horário");
		System.out.println(ID_MENU_CADASTRAR_SALA + " - Cadastrar Sala");
		System.out.println(ID_MENU_CADASTRAR_LABORATORIO + " - Cadastrar Laboratório");
		System.out.println(ID_MENU_CADASTRAR_APLICATIVO + " - Cadastrar Aplicativo");
		System.out.println(ID_MENU_CADASTRAR_PROJETOR + " - Cadastrar Projetor");
		System.out.println(ID_MENU_CADASTRAR_RESERVA + " - Realizar Reserva");
		System.out.println(ID_MENU_SAIR + " - Sair");

		listenerUsuario();
	}

	@Override
	public void opcaoInvalida() {
		System.out.println("\n Opção inválida. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		montarMenu();
	}
	
	private void listenerUsuario() {
		System.out.println("Selecione uma opção: ");
		try {
			opcao = scanner.nextInt();
		} catch (InputMismatchException e) {
			opcaoInvalida();
		}

		switch (opcao) {
		case ID_MENU_CADASTRAR_USUARIO:
			new MenuUsuario();
			break;
		case ID_MENU_CADASTRAR_PROFESSOR:
			new MenuProfessor();
			break;
		case ID_MENU_CADASTRAR_ALUNO:
			new MenuAluno();
			break;
		case ID_MENU_CADASTRAR_DISCIPLINA:
			new MenuDisciplina();
			break;
		case ID_MENU_CADASTRAR_HORARIO:
			new MenuHorario();
			break;
		case ID_MENU_CADASTRAR_TURMA:
			new MenuTurma();
			break;
		case ID_MENU_SAIR:
			SistemaAcademicoUtils.sairAplicacao();
		default:
			opcaoInvalida();
			break;
		}
	}

}
