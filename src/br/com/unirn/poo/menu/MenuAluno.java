package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.excecoes.CPFInvalidoException;
import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.processadores.ProcessadorAluno;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author felipe
 *
 */
public class MenuAluno extends MenuGeneric<Aluno> {

	private String nome;
	private String cpf;
	private String telefone;
	private String matricula;
	private String curso;

	public MenuAluno() {
		super();
		processador = new ProcessadorAluno();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome do aluno: ");
		nome = scanner.nextLine();

		System.out.println("Informe o CPF do aluno (sem caracteres especiais): ");
		cpf = scanner.nextLine();

		System.out.println("Informe o telefone do aluno: ");
		telefone = scanner.nextLine();

		System.out.println("Informe a matrícula do aluno: ");
		matricula = scanner.nextLine();
		
		System.out.println("Informe o curso do aluno: ");
		curso = scanner.nextLine();

		Aluno aluno = new Aluno(nome, cpf, telefone, matricula, curso);

		try {
			if (processador.validate(aluno)) {
				processador.cadastrar(aluno, ListasSingleton.getInstance().getListaAluno());

				System.out.println("Aluno cadastrado com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados do aluno.");
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
