package br.com.unirn.poo.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.unirn.poo.helper.ReservaHelper;
import br.com.unirn.poo.modelo.Reserva;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.processadores.ProcessadorReserva;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

public class MenuReserva extends MenuGeneric<Reserva>{
	
	private Integer idTurma;
	private Integer usaProjetor;
	
	public MenuReserva() {
		super();
		obj = new Reserva();
		processador = new ProcessadorReserva();
	}

	@Override
	public void montarMenu() {
		System.out.println("-------------------");
		
		if (ListasSingleton.getInstance().getListaTurma().isEmpty()){
			System.out.println("É necessário existir no minimo uma turma cadastrada para criar uma reserva.");
			retornarMenuInicial();
		}
		
		if (ListasSingleton.getInstance().getListaLocalAula().isEmpty()){
			System.out.println("É necessário exisitr no minimo uma sala/laborátorio cadastrado para criar uma reserva.");
			retornarMenuInicial();
		}
		
		List<Turma> turmas = new ArrayList<Turma>(); 
		SistemaAcademicoUtils.clonarListaGeneric(ListasSingleton.getInstance().getListaTurma(), turmas);
		Collection<Reserva>  reservas = ListasSingleton.getInstance().getListaReserva();
		Collection<Turma> turmasSemReserva = ReservaHelper.getTurmasSemReserva(turmas, reservas);
		
		ReservaHelper.listarTurmas(turmasSemReserva);
		idTurma = SistemaAcademicoUtils.lerInteiro(scanner);		
		obj.setTurma(turmas.get(idTurma));
		
		System.out.println("A sala selecionada deverá ter um projetor? ");
		System.out.println(" 1 - SIM ");
		System.err.println(" 2 - NÃO ");
		usaProjetor = SistemaAcademicoUtils.lerInteiro(scanner);	
		
		
		
		System.out.println("Escolha uma das turmas listadas abaixo: ");
		
		
		// tem que validar aqui se já existe salas ou laboratorios
		
		System.out.println("Escolha o tipo de sala de aula, digitando o nº da mesma:");
		System.out.println( " 1 - Laboratório ");
		System.out.println( " 2 - Laboratório ");
	}

	@Override
	public void opcaoInvalida() {
		// TODO Auto-generated method stub
		
	}

}
