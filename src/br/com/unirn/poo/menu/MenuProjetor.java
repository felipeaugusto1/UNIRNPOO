package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.modelo.Projetor;
import br.com.unirn.poo.processadores.ProcessadorProjetor;

/**
 * 
 * @author felipe
 *
 */
public class MenuProjetor extends MenuGeneric<Projetor> {

	private String marca;
	private String modelo;
	private String tombo;

	public MenuProjetor() {
		super();
		processador = new ProcessadorProjetor();

		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe a marca do projetor: ");
		marca = scanner.nextLine();

		System.out.println("Informe o modelo do projetor: ");
		modelo = scanner.nextLine();
		
		System.out.println("Informe o tombo do projetor: ");
		tombo = scanner.nextLine();

		Projetor projetor = new Projetor(marca, modelo, tombo);

		try {
			if (processador.validate(projetor)) {
				//processador.cadastrar(projetor, ListasSingleton.getInstance().getListaDisciplina());

				System.out.println("Projetor cadastrado com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados do projetor.");
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
