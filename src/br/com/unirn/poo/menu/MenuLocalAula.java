package br.com.unirn.poo.menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.modelo.Aplicativo;
import br.com.unirn.poo.modelo.Laboratorio;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Projetor;
import br.com.unirn.poo.modelo.Sala;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author ÍcaroCosta
 *
 */
public class MenuLocalAula extends MenuGeneric<LocalAula> {

	private static int SIM = 1;
	private static int NAO = 2;
	
	List<Aplicativo> aplicativosSalvos = null;
	List<Projetor> projetoresSalvos = ListasSingleton.getInstance().getListaProjetor();
	
	public MenuLocalAula() {
		super();
		//Criar processador
		montarMenu();
	}
	
	@Override
	public void montarMenu() {
		
		LocalAula local = null;
		boolean usaProjetor = false;
		boolean usaAplicativo = false;
		
		apresentarOpcao(Aplicativo.class);
		int opcaoEscolhida = lerInteiro();
		validarEscolha(opcaoEscolhida, Aplicativo.class);
		if (opcaoEscolhida == SIM)
			usaAplicativo = true;
		
		apresentarOpcao(Projetor.class);
		opcaoEscolhida = lerInteiro();
		validarEscolha(opcaoEscolhida, Projetor.class);
		if (opcaoEscolhida == SIM)
			usaProjetor = true;
		
		System.out.println("\nInforme o bloco da sala: ");
		String bloco = scanner.nextLine();
		
		System.out.println("\nInforme a capacidade de alunos: ");
		int capacidade = lerInteiro();
		
		if (usaProjetor || usaAplicativo){
			local = new Laboratorio();
			String nome = scanner.nextLine();
			local.setBloco(bloco);
			local.setCapacidadeAlunos(capacidade);
			((Laboratorio) local).setNome(nome);
		} else {
			local = new Sala();
			System.out.println("\nDigite o número da sala: ");
			int numero = lerInteiro();
			local.setBloco(bloco);
			local.setCapacidadeAlunos(capacidade);
			((Sala) local).setNumero(numero);
		}
		
		
	}

	@Override
	public void opcaoInvalida() {
		
		
	}
	
	private <T> void apresentarOpcao(Class<T> classe){
		System.out.println("-------------------");
		System.out.println("O local de aula usará " + classe.getName() + " \n " + SIM + " - Sim \n + " + NAO + " - Não \n");
		
	}
	
	private int lerInteiro(){
		try {
			int retorno = scanner.nextInt();
			return retorno;
		} catch (InputMismatchException e) {
			scanner = new Scanner(System.in);
			System.out.println("Número inválido, digite outra uma opção válida.");
			return lerInteiro();
		} 
	}
	
	private <T> void  validarEscolha(int escolha, Class<T> classe){
		if (escolha == SIM){
			if (aplicativosSalvos.isEmpty()){
				System.out.println("É necessário que já tenha um " +  classe.getName() + " cadastrado para continuar.");
				super.solicitarProximaAcao();
			}
		} else {
			if (escolha > NAO)
				System.out.println("Opção inválida.");
			super.solicitarProximaAcao();
		}
	}

}
