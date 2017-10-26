package br.uefs.ecomp.folitron.facade;

import br.uefs.ecomp.folitron.model.Bloco;
import br.uefs.ecomp.folitron.model.Foliao;
import br.uefs.ecomp.folitron.model.Transporte;
import br.uefs.ecomp.folitron.util.Iterador;

public class FolitronFacade {

	
	ControllerFolitron cf;

	public FolitronFacade() {
		this.cf = new ControllerFolitron();
	}


	public Bloco cadastrarBloco(String nome, String local, int saida) {
		return cf.cadastrarBloco(nome, local, saida);
	}

	public Bloco obterBloco(int id) {
		return cf.obterBloco(id);
	}

	public Iterador listarBlocos(String local, int dataInicio, int dataFim) {
		return this.cf.listarBlocos(local, dataInicio, dataFim);
	}				


	public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, 
							int saida, String localSaida, int retorno, String localRetorno, 
							int chegada, String localChegada, Bloco bloco) {
		return cf.cadastrarTransporte(nome, tipo, valor, capacidade, saida, localSaida, 
				retorno, localRetorno, chegada, localChegada, bloco);
	}

	public Transporte obterTransporte(int id) {
		return cf.obterTransporte(id);
	}

	public Iterador listarTransportes(Bloco bloco) {
		return this.cf.listarTransportes(bloco);
	}	


	public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade) {
		return cf.cadastrarFoliao(cpf, rg, nome, idade);
	}

	public Foliao obterFoliao(String cpf) {
		return cf.obterFoliao(cpf);
	}

	public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte) {
		return this.cf.registrarFoliaoEmTransporte(foliao, transporte);
	}

	public Iterador listarFolioes(Transporte transporte) {
		return this.cf.listarFolioes(transporte);
	}

}
