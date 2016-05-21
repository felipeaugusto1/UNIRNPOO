package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.modelo.Disciplina;
import br.com.unirn.poo.processadores.ProcessadorDisciplina;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author felipe
 *
 */
public class MenuDisciplina extends MenuGeneric<Disciplina> {

	private String nome;
	private String sigla;

	public MenuDisciplina() {
		super();
		processador = new ProcessadorDisciplina();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome da disciplina: ");
		nome = scanner.nextLine();

		System.out.println("Informe a sigla da disciplina: ");
		sigla = scanner.nextLine();

		Disciplina disciplina = new Disciplina(nome, sigla);

		try {
			if (processador.validate(disciplina)) {
				processador.cadastrar(disciplina, ListasSingleton.getInstance().getListaDisciplina());

				System.out.println("Disciplina cadastrada com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados da disciplina.");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			scanner = new Scanner(System.in);
			montarMenu();
		}

	}

	@Override
	public void opcaoInvalida() {
	}

}
