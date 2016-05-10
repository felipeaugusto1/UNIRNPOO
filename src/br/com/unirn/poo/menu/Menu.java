package br.com.unirn.poo.menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.unirn.poo.arquivo.Arquivo;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author felipe
 *
 */
public class Menu {

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

	private static int opcao;

	public static void montarMenuOpcoes() {
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

	private static void listenerUsuario() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Selecione uma opção: ");
		try {
			opcao = scanner.nextInt();
		} catch (InputMismatchException e) {
			opcaoInvalida();
		}

		switch (opcao) {
		case ID_MENU_CADASTRAR_USUARIO:
			new MenuUsuario();
			scanner.close();
			break;
		case ID_MENU_CADASTRAR_PROFESSOR:
			new MenuProfessor();
			scanner.close();
			break;
		case ID_MENU_SAIR:
			try {
				Arquivo.salvarObjetos();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			System.out.println("Volte sempre!");
			System.exit(0);
		default:
			opcaoInvalida();
			break;
		}
	}

	private static void opcaoInvalida() {
		System.out.println("\n Opção inválida. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		montarMenuOpcoes();
	}

}
