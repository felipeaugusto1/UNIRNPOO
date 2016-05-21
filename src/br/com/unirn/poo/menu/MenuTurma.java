package br.com.unirn.poo.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.modelo.Aluno;
import br.com.unirn.poo.modelo.Disciplina;
import br.com.unirn.poo.modelo.Professor;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.processadores.ProcessadorTurma;
import br.com.unirn.poo.singleton.ListasSingleton;

public class MenuTurma extends MenuGeneric<Turma> {
	
	private int codigo;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private List<Professor> professores;
	
	public MenuTurma() {
		super();
		processador = new ProcessadorTurma();
		montarMenu();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");

		List<Disciplina> disciplinas = ListasSingleton.getInstance().getListaDisciplina();
		if (disciplinas.isEmpty()){
			System.out.println("É necessário que haja uma disciplina para cadastrar turma.");
			super.retornarMenuInicial();
		}
		
		List<Professor> professoresSalvos = new ArrayList<Professor>();
		clonarListaGeneric(professoresSalvos, ListasSingleton.getInstance().getListaProfessor());
		if (professoresSalvos.isEmpty()){
			System.out.println("É necessário que haja pelo menos um professor para cadastrar turma.");
			super.retornarMenuInicial();
		}
		
		List<Aluno> alunosSalvos = new ArrayList<Aluno>();
		clonarListaGeneric(alunosSalvos, ListasSingleton.getInstance().getListaAluno());
		if (alunosSalvos.isEmpty()){
			System.out.println("É necessário que haja pelo menos um aluno para cadastrar turma.");
			super.retornarMenuInicial();
		}
		
		System.out.println("Informe o código da turma: ");
		codigo = lerInteiro();

		System.out.println("Escolha uma disciplina pelo seu número: ");
		
		int indice = 0;
		for (Disciplina d : disciplinas){
			System.out.println(++indice + " - " +  d.getNome());
		}
		System.out.println();
		
		int opcao = lerInteiro();
		disciplina = ListasSingleton.getInstance().getListaDisciplina().get(--opcao);
		
		indice = 1;
		System.out.println("Escolha um professor pelo número ou 0(zero) pra sair: ");
		
		
		professores = new ArrayList<Professor>();
		
		do {
			System.out.println(0 + " - Sair");
			for (Professor p : professoresSalvos){
				System.out.println(indice++ + " - " + p.getNome() );
			}
			System.out.println();
			
			opcao = lerInteiro();
			
			if (opcao > (professoresSalvos.size()) || opcao < 0){
				System.out.println("Opção inválida, tente um valor válido");
				indice--;
				continue;
			}
			
			if (opcao > 0) {
				professores.add(professoresSalvos.get(opcao-1));
				professoresSalvos.remove(opcao-1);
			} else {
				if (professores.isEmpty()){
					System.out.println("Adicione pelo menos um professor");
				}
			}
			
		} while (opcao != 0 && !professoresSalvos.isEmpty());
		
		indice = 1;
		System.out.println("Escolha um aluno pelo número ou 0(zero) pra sair: ");
		
		
		alunos = new ArrayList<Aluno>();
		
		do {
			System.out.println(0 + " - Sair");
			for (Aluno a : alunosSalvos){
				System.out.println(indice++ + " - " + a.getNome() );
			}
			System.out.println();
			
			opcao = lerInteiro();
			
			if (opcao > (alunosSalvos.size()) || opcao < 0){
				System.out.println("Opção inválida, tente um valor válido");
				indice--;
				continue;
			}
			
			if (opcao > 0) {
				alunos.add(alunosSalvos.get(opcao-1));
				alunosSalvos.remove(opcao-1);
			} else {
				if (alunos.isEmpty()){
					System.out.println("Adicione pelo menos um aluno");
				}
			}
			
		} while (opcao != 0 && !alunosSalvos.isEmpty());
		
		Turma turma = new Turma(codigo, disciplina, alunos, professores);
		
		try {
			if (processador.validate(turma)) {
				processador.cadastrar(turma, ListasSingleton.getInstance().getListaTurma());

				System.out.println("Turma cadastrada com sucesso!");

				super.solicitarProximaAcao();
			} else {
				System.out.println("Informe todos os dados da Turma.");
				scanner = new Scanner(System.in);
				montarMenu();
			}
		} catch (Exception e) {
			
		}
	}

	@Override
	public void opcaoInvalida() {
		
		
	}
	
	private <T> void clonarListaGeneric(List<T> origem, List<T> destino){
		if (destino != null){
			for (T t : destino) {
				origem.add(t);
			}
		}
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

}
