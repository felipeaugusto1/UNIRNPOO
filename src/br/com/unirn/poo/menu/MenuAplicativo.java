package br.com.unirn.poo.menu;

import java.util.Scanner;

import br.com.unirn.poo.modelo.Aplicativo;
import br.com.unirn.poo.processadores.ProcessadorAplicativo;
import br.com.unirn.poo.singleton.ListasSingleton;

public class MenuAplicativo  extends MenuGeneric<Aplicativo>{
	
	public MenuAplicativo() {
		super();
		obj = new Aplicativo();
		processador  = new ProcessadorAplicativo();
	}
	
	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		System.out.println("Informe o nome do aplicativo: ");
		obj.setNome(scanner.nextLine());
		
		try{
		if (processador.validate(obj)){
			processador.cadastrar(obj, ListasSingleton.getInstance().getListaAplicativo());
			
			System.out.println("Aplicativo cadastrado com sucesso!");
			
			super.solicitarProximaAcao();
		} else {
			System.out.println("Aplicativo já informado anteriormente..");
			scanner = new Scanner(System.in);
			montarMenu();
		}
		} catch (Exception e){
			System.out.println(e.getMessage());
			scanner = new Scanner(System.in);
			montarMenu();
		}
	}

	@Override
	public void opcaoInvalida() {
		// TODO Auto-generated method stub
		
	}

}
