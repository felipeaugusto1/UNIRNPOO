package br.com.unirn.poo.menu;

import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.processadores.ProcessadorGeneric;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * Classe abstrata de controle de menus.
 *
 */
public abstract class MenuGeneric<T> {

	/**
	 * Atributo para ler teclado do usuario.
	 */
	public Scanner scanner;
	public List<T> lista;
	public ProcessadorGeneric<T> processador;
	public T obj;

	public MenuGeneric() {
		this.scanner = new Scanner(System.in);
	}

	public abstract void montarMenu();
	public abstract void opcaoInvalida();

	public void retornarMenuInicial() {
		SistemaAcademicoUtils.esperarSegundos();
		new Menu();
	}
	
	public static void sairAplicacao() {		
		ListasSingleton.getInstance().salvarObjetos();
		System.out.println("Volte sempre!");
		System.exit(0);
	}

	public void solicitarProximaAcao() {
		int opcao;

		System.out.println("\n");
		System.out.println("Sair do aplicativo ou realizar uma nova operação? ");
		System.out.println("1 - Nova operação");
		System.out.println("2 - Sair");

		opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			retornarMenuInicial();
			break;
		case 2:
			sairAplicacao();
		default:
			System.out.println("\n Opção inválida. Tente novamente. \n" );
			SistemaAcademicoUtils.esperarSegundos();
			solicitarProximaAcao();
			break;
		}
	}

}
