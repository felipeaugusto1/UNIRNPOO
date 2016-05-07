package br.com.unirn.poo.menu;

import java.util.Scanner;

public abstract class MenuGeneric {

	public Scanner scanner;

	public abstract void montarMenu();

	public MenuGeneric() {
		this.scanner = new Scanner(System.in);
	}

}
