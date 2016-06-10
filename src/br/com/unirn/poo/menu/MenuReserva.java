package br.com.unirn.poo.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.unirn.poo.helper.ReservaHelper;
import br.com.unirn.poo.modelo.LocalAula;
import br.com.unirn.poo.modelo.Reserva;
import br.com.unirn.poo.modelo.Turma;
import br.com.unirn.poo.processadores.ProcessadorReserva;
import br.com.unirn.poo.singleton.ListasSingleton;
import br.com.unirn.poo.util.SistemaAcademicoUtils;

/**
 * 
 * @author allan
 *
 */
public class MenuReserva extends MenuGeneric<Reserva>{
	
	private Integer idTurma;
	private Integer usaProjetor;
	private Integer idLocal;
	List<LocalAula>  locais = new ArrayList<LocalAula>();

	
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
		
		if (turmasSemReserva.isEmpty()){
			System.out.println("Todas as turmas já possuem reservas.");
			retornarMenuInicial();
		}
		
		obj.setUsaProjetor(false);
		obj.setData(new Date());
		obj.setAtivo(true);
		
		//Lista as turmas e dá opção de escolher.
		ReservaHelper.listarTurmas(turmasSemReserva);
		idTurma = SistemaAcademicoUtils.lerInteiro(scanner) -1;		
		obj.setTurma(turmas.get(idTurma));
		
		System.out.println("Escolha o tipo de sala de aula, digitando o nº da mesma:");
		System.out.println( " 1 - Laboratório ");
		System.out.println( " 2 - Sala ");
		
		idLocal = SistemaAcademicoUtils.lerInteiro(scanner);
		if (idLocal == 1){
			locais = ReservaHelper.getLaboratoriosSemReserva(obj.getTurma());
			if (locais.isEmpty()){
				System.out.println("Sistema não possui laboratórios disponíveis.");
				super.retornarMenuInicial();
			}
		} else {
			locais = ReservaHelper.getSalasSemReserva(obj.getTurma());
			if (locais.isEmpty()){
				System.out.println("Sistema não possui salas disponíveis.");
				super.retornarMenuInicial();
			}
			System.out.println("A sala usará projetor?");
			System.out.println( " 1 - Sim ");
			System.out.println( " 2 - Não ");
			usaProjetor = SistemaAcademicoUtils.lerInteiro(scanner);
			if (usaProjetor == 1){
				obj.setUsaProjetor(true);
			}
		}
		ReservaHelper.listarLocais(locais);
		idLocal = SistemaAcademicoUtils.lerInteiro(scanner) -1;
		obj.setLocalAula(locais.get(idLocal));
		
		try {
			if (processador.validate(obj)) {
				processador.cadastrar(obj, ListasSingleton.getInstance().getListaReserva());

				System.out.println("Reserva cadastrada com sucesso!");
				super.solicitarProximaAcao();
			}
		} catch(Exception e) {
			System.out.println("Ocorreu um erro durante a operação, tente novamente.");
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
