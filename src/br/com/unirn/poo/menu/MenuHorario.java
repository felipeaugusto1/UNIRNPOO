package br.com.unirn.poo.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.unirn.poo.excecoes.HorarioInvalidoException;
import br.com.unirn.poo.modelo.DiaSemana;
import br.com.unirn.poo.modelo.Horario;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.modelo.Turno;
import br.com.unirn.poo.processadores.ProcessadorHorario;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author felipe
 *
 */
public class MenuHorario extends MenuGeneric<Horario> {

	private static boolean menu_turno_erro = false;
	private static boolean menu_dia_semana_erro = false;

	private String horaInicio;
	private String horaFim;
	private DiaSemana diaSemana;
	private Turno turno;
	private Turma turma;

	public MenuHorario() {
		super();
		processador = new ProcessadorHorario();

		if (ListasSingleton.getInstance().getListaTurma().isEmpty()) {
			System.out.println("É necessário pelomenos uma turma cadastrada para cadastrar um horário.");
			super.retornarMenuInicial();
		} else
			montarMenu();
			
		
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe a hora de início (ex: 08:00): ");
		horaInicio = scanner.nextLine();

		System.out.println("Informe a hora de término (ex: 08:40): ");
		horaFim = scanner.nextLine();

		montarMenuTurno();
		
		montarMenuTurmas();

		Horario horario = new Horario(turma, turno, horaInicio, horaFim, diaSemana);

		try {
			if (processador.validate(horario)) {
				processador.cadastrar(horario, ListasSingleton.getInstance().getListaHorario());

				System.out.println("Disciplina cadastrada com sucesso!");

				super.solicitarProximaAcao();
			}
		} catch (Exception e) {
			if (e instanceof HorarioInvalidoException) {
				System.out.println(e.getMessage());
				scanner = new Scanner(System.in);
				montarMenu();
			} else if (e instanceof NumberFormatException) {
				System.out.println("Horário inválido! Por favor, utilize somente números. Ex: 08:00");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		}

	}

	@Override
	public void opcaoInvalida() {
		System.out.println("\n Opção inválida. Tente novamente. \n");
		SistemaAcademicoUtils.esperarSegundos();
		scanner = new Scanner(System.in);

		if (menu_dia_semana_erro)
			montarMenuDiaSemana();
		else if (menu_turno_erro)
			montarMenuTurno();
	}

	private void montarMenuTurno() {
		int turnoInformado = 0;

		System.out.println("Turno: ");
		System.out.println("1 - Matutino");
		System.out.println("2 - Vespertino");
		System.out.println("3 - Noturno");

		try {
			turnoInformado = scanner.nextInt();
		} catch (InputMismatchException e) {
			menu_turno_erro = true;
			opcaoInvalida();
		}

		switch (turnoInformado) {
		case 1:
			turno = Turno.MATUTINO;
			break;
		case 2:
			turno = Turno.VESPERTINO;
			break;
		case 3:
			turno = Turno.NOTURNO;
			break;
		default:
			menu_turno_erro = true;
			opcaoInvalida();
			break;
		}
	}

	private void montarMenuDiaSemana() {
		int diaSemanaInformado = 0;

		System.out.println("Dia: ");
		System.out.println("1 - Segunda");
		System.out.println("2 - Terça");
		System.out.println("3 - Quarta");
		System.out.println("4 - Quinta");
		System.out.println("5 - Sexta");
		System.out.println("6 - Sábado");

		try {
			diaSemanaInformado = scanner.nextInt();
		} catch (InputMismatchException e) {
			menu_dia_semana_erro = true;
			opcaoInvalida();
		}

		switch (diaSemanaInformado) {
		case 1:
			diaSemana = DiaSemana.SEGUNDA;
			break;
		case 2:
			diaSemana = DiaSemana.TERCA;
			break;
		case 3:
			diaSemana = DiaSemana.QUARTA;
			break;
		case 4:
			diaSemana = DiaSemana.QUINTA;
			break;
		case 5:
			diaSemana = DiaSemana.SEXTA;
			break;
		case 6:
			diaSemana = DiaSemana.SABADO;
			break;
		default:
			menu_dia_semana_erro = true;
			opcaoInvalida();
			break;
		}
	}

	private void montarMenuTurmas() {
		System.out.println("Selecione uma turma: ");
		
		int indice = 0;
		for (Turma t : ListasSingleton.getInstance().getListaTurma()){
			System.out.println(++indice + " - " +  t.getCodigo() + " - " +t.getDisciplina().getNome());
		}
		
		
		int opcao;
		try {
			opcao = scanner.nextInt();
			turma = ListasSingleton.getInstance().getListaTurma().get(--opcao);
		} catch (InputMismatchException e) {
			scanner = new Scanner(System.in);
			System.out.println("Turma inválida, tente novamente.");
			montarMenuTurmas();
		} 
		
	}

}
