package br.com.unirn.poo.menu;

import java.util.Scanner;

/**
 * Classe abastrata de controle de menus
 *
 */
public abstract class MenuGeneric {

	/**
	 * Atributo para ler teclado do usu�rio.
	 */
	public Scanner scanner;

	public abstract void montarMenu();
	
	public void retornarMenuInicial() {
		Menu.montarMenuOpcoes();
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
			System.out.println("Volte sempre!");
			System.exit(0);
		default:
			break;
		}
	}

	public MenuGeneric() {
		this.scanner = new Scanner(System.in);
	}

}
