package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.expcetions.CPFInvalidoException;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.modelo.Usuario;
import br.com.unirn.poo.processadores.ProcessadorProfessor;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author felipe
 *
 */
public class MenuProfessor extends MenuGeneric<Usuario> {

	private ProcessadorProfessor processadorProfessor;

	private String nome;
	private String cpf;
	private String telefone;
	private String matricula;

	public MenuProfessor() {
		super();
		processadorProfessor = new ProcessadorProfessor();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome do professor: ");
		nome = scanner.nextLine();

		System.out.println("Informe o CPF do professor (sem caracteres especiais): ");
		cpf = scanner.nextLine();

		System.out.println("Informe o telefone do professor: ");
		telefone = scanner.nextLine();

		System.out.println("Informe a matrícula do professor: ");
		matricula = scanner.nextLine();

		Professor professor = new Professor(nome, cpf, telefone, matricula);

		try {
			if (processadorProfessor.validate(professor)) {
				processadorProfessor.cadastrar(professor, ListasSingleton.getInstance().getListaProfessor());

				System.out.println("Professor cadastrado com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados do professor.");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		} catch (CPFInvalidoException e) {
			System.out.println(e.getMessage());
			scanner = new Scanner(System.in);
			montarMenu();
		}

	}

	@Override
	public void opcaoInvalida() {
	}

}
