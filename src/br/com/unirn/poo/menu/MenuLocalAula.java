package br.com.unirn.poo.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.modelo.Aplicativo;
import br.com.unirn.poo.modelo.Laboratorio;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Projetor;
import br.com.unirn.poo.modelo.Sala;
import br.com.unirn.poo.processadores.ProcessadorLocalAula;
import br.com.unirn.poo.processadores.ProcessadorTurma;
import br.com.unirn.poo.singleton.ListasSingleton;

/**
 * 
 * @author ÍcaroCosta
 *
 */
public class MenuLocalAula extends MenuGeneric<LocalAula> {

	private static int SIM = 1;
	private static int NAO = 2;
	
	List<Aplicativo> aplicativosSalvos = ListasSingleton.getInstance().getListaAplicativo();
	List<Projetor> projetoresSalvos = ListasSingleton.getInstance().getListaProjetor();
	
	public MenuLocalAula() {
		super();
		processador = new ProcessadorLocalAula();
		montarMenu();
	}
	
	@Override
	public void montarMenu() {
		
		LocalAula local = null;
		boolean usaProjetor = false;
		boolean usaAplicativo = false;
		
		apresentarOpcao(Aplicativo.class);
		int opcaoEscolhida = lerInteiro();
		validarEscolha(opcaoEscolhida, Aplicativo.class, aplicativosSalvos);
		if (opcaoEscolhida == SIM)
			usaAplicativo = true;
		
		apresentarOpcao(Projetor.class);
		opcaoEscolhida = lerInteiro();
		validarEscolha(opcaoEscolhida, Projetor.class, projetoresSalvos);
		if (opcaoEscolhida == SIM)
			usaProjetor = true;
		
		System.out.println("\nInforme o bloco da sala: ");
		String bloco;
		bloco = scanner.nextLine();
		
		System.out.println("\nInforme a capacidade de alunos: ");
		int capacidade = lerInteiro();
		
		if (usaProjetor || usaAplicativo){
			
			List<Projetor> projetoresSalvos = new ArrayList<Projetor>();
			List<Aplicativo> aplicativosSalvos = new ArrayList<Aplicativo>();
			local = new Laboratorio();
						
			clonarListaGeneric(projetoresSalvos, ListasSingleton.getInstance().getListaProjetor());
			clonarListaGeneric(aplicativosSalvos, ListasSingleton.getInstance().getListaAplicativo());
			
			if (usaProjetor){
				
				if (projetoresSalvos.isEmpty()){
					System.out.println("É necessário que haja pelo menos um projetor para cadastrar turma.");
					super.retornarMenuInicial();
				}
				
				Projetor projetorEscolhido;
				
				System.out.println("Escolha um projetor pelo seu número: ");
				
				int indice = 0;
				for (Projetor p : projetoresSalvos){
					System.out.println(++indice + " - " +  p.getMarca() + "/" + p.getModelo() );
				}
				System.out.println();
				
				int opcao = lerInteiro();
				projetorEscolhido = ListasSingleton.getInstance().getListaProjetor().get(--opcao);
				
				((Laboratorio) local).setProjetor(projetorEscolhido);
			}
			
			if (usaAplicativo){
				if (aplicativosSalvos.isEmpty()){
					System.out.println("É necessário que haja pelo menos um aplicativo para cadastrar turma.");
					super.retornarMenuInicial();
				}
				
				List<Aplicativo> aplicativosEscolhidos;
				
				int indice = 1;
				System.out.println("Escolha um aplicativo pelo número ou 0(zero) pra sair: ");
				
				
				aplicativosEscolhidos = new ArrayList<Aplicativo>();
				int opcao;
				
				do {
					indice = 1;
					System.out.println(0 + " - Sair");
					for (Aplicativo a : aplicativosSalvos){
						System.out.println(indice++ + " - " + a.getNome() );
					}
					System.out.println();
					
					opcao = lerInteiro();
					
					if (opcao > (aplicativosSalvos.size()) || opcao < 0){
						System.out.println("Opção inválida, tente um valor válido");
						indice--;
						continue;
					}
					
					if (opcao > 0) {
						aplicativosEscolhidos.add(aplicativosSalvos.get(opcao-1));
						aplicativosSalvos.remove(opcao-1);
					} else {
						if (aplicativosEscolhidos.isEmpty()){
							System.out.println("Adicione pelo menos um aplicativo");
						}
					}
					
				} while (opcao != 0 && !aplicativosEscolhidos.isEmpty());
				
				((Laboratorio) local).setAplicativos(aplicativosEscolhidos);
			}
			
			scanner = new Scanner(System.in);
			System.out.println("\nEscolha um nome para o laboratório:");
			String nome;
			nome = scanner.nextLine();
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
		
		try {
			if (processador.validate(local)) {
				processador.cadastrar(local, ListasSingleton.getInstance().getListaLocalAula());

				if (local instanceof Laboratorio)
					System.out.println("Laboratorio cadastrado com sucesso!");
				else
					System.out.println("Sala cadastrada com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados do Local.");
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
	
	private <T> void apresentarOpcao(Class<T> classe){
		String nomeClasse = classe.getName();
		String[] divisoes = nomeClasse.split("\\.");
		String nome = divisoes[divisoes.length-1];
		System.out.println("-------------------");
		System.out.println("O local de aula usará " + nome + "? \n " + SIM + " - Sim \n " + NAO + " - Não \n");
		
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
	
	private <T> void  validarEscolha(int escolha, Class<T> classe, List<T> lista){
		String nomeClasse = classe.getName();
		String[] divisoes = nomeClasse.split("\\.");
		String nome = divisoes[divisoes.length-1];
		if (escolha == SIM){
			if (lista.isEmpty()){
				System.out.println("É necessário que já tenha um " +  nome + " cadastrado para continuar.");
				super.solicitarProximaAcao();
			}
		} else {
			if (escolha > NAO){
				System.out.println("Opção inválida. Tente de novo: ");
				validarEscolha(lerInteiro(), classe, lista);
			}
		}
		scanner = new Scanner(System.in);
	}
	
	private <T> void clonarListaGeneric(List<T> origem, List<T> destino){
		if (destino != null){
			for (T t : destino) {
				origem.add(t);
			}
		}
	}

}
