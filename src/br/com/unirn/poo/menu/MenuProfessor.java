package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.processadores.ProcessadorProfessor;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.ValidadorCPF;

/**
 * 
 * @author felipe
 *
 */
public class MenuProfessor extends MenuGeneric<Professor> {

	private String nome;
	private String cpf;
	private String telefone;
	private String matricula;

	public MenuProfessor() {
		super();
		processador = new ProcessadorProfessor();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome do professor: ");
		nome = scanner.nextLine();

		System.out.println("Informe o CPF do professor (sem caracteres especiais): ");
		cpf = scanner.nextLine();
		
		while (!ValidadorCPF.isCPF(cpf)) {
			System.out.println("CPF Inválido. Informe novamente:");
			cpf = scanner.nextLine();
		}

		System.out.println("Informe o telefone do professor: ");
		telefone = scanner.nextLine();

		System.out.println("Informe a matrícula do professor: ");
		matricula = scanner.nextLine();

		Professor professor = new Professor(nome, cpf, telefone, matricula);

		try {
			if (processador.validate(professor)) {
				processador.cadastrar(professor, ListasSingleton.getInstance().getListaProfessor());

				System.out.println("Professor cadastrado com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados do professor.");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		} catch (Exception e) {
			if (e instanceof CPFInvalidoException) {
				System.out.println(e.getMessage());
				scanner = new Scanner(System.in);
				montarMenu();
			}
		}

	}

	@Override
	public void opcaoInvalida() {
	}

}
