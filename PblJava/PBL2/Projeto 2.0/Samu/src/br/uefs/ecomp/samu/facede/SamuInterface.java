/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Componente Curricular: Módulo Integrado de Programação Autor: <Washington Pagotto Batista>
 * Data: <23/05/2014>
 *
 * Declaro que este código foi elaborado por mim de forma individual e não
 * contém nenhum trecho de código de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e páginas ou documentos eletrônicos da
 * Internet. Qualquer trecho de código de outra autoria que uma citação para o
 * não a minha está destacado com autor e a fonte do código, e estou ciente que
 * estes trechos não serão considerados para fins de avaliação. Alguns trechos
 * do código podem coincidir com de outros colegas pois estes foram discutidos
 * em sessões tutorias.
 */

package br.uefs.ecomp.samu.facede;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import br.uefs.ecomp.samu.model.Ambulancia;
import br.uefs.ecomp.samu.model.Atendente;
import br.uefs.ecomp.samu.model.Cidadao;
import br.uefs.ecomp.samu.model.Ocorrencia;
import br.uefs.ecomp.samu.model.Pessoa;
import br.uefs.ecomp.samu.model.exception.AmbulanciasInsifucienteException;
import br.uefs.ecomp.samu.model.exception.AtendenteIndisponivelException;
import br.uefs.ecomp.samu.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.samu.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.samu.model.exception.CidadaoNaoEncontradoException;
import br.uefs.ecomp.samu.model.exception.OcorrenciaNaoEncontradaException;
import br.uefs.ecomp.samu.model.exception.QuantidadeDiferenteAmbulanciasException;
import br.uefs.ecomp.samu.util.Console;
import br.uefs.ecomp.samu.util.Iterador;

/**
*
* @author Washington Pagotto Batista
*/
public class SamuInterface {

	static SamuFacade facade;
	static Console console;  

	public static void main(String[] args) throws IOException{

		//criando um objeto.
		facade=new SamuFacade();
		console= new Console();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//variavel
		int digitado;
		boolean repeticao=false;

		//estrutura de repetição, feita atraves de um boolean
		while(!repeticao){

			//opções que o menu oferece
			System.out.println("1-Cadastrar cidadão");
			System.out.println("2-Listar cidadões");
			System.out.println("3-Consultar Divida");
			System.out.println("4-Pagar divida");
			System.out.println("5-Cadastrar Atendente");
			System.out.println("6-Listar Atendentes");
			System.out.println("7-Listar Atendentes disponíveis");
			System.out.println("8-Cadastrar Ambulancia");
			System.out.println("9-Listar ambulancias disponíveis");
			System.out.println("10-Listar ambulâncias");
			System.out.println("11-Cadastrar ocorrência");
			System.out.println("12-Atender Ocorrência");
			System.out.println("13-Finalizar Ocorrência");
			System.out.println("14-Listar ocorrência");
			System.out.println("15-Consultar Ocorrência");
			System.out.println("16-Sair");

			System.out.println("Digita a opçao que deseja");
			digitado=console.readInt();

			switch(digitado){

			case 1:
				//Cadastrar cidadão
				try{
					//sendo executado pra pegar cpf, nome e endereço
					System.out.println("Digite seu cpf:");
					String cpf=console.readString();

					System.out.println("Digite o seu nome:");
					String nome = console.readString();
					//String cpf=console.readString();

					System.out.println("Digite seu endereço:");
					String endereco=console.readString();

					facade.cadastrarCidadao(cpf,nome,endereco);

				}
				catch(CadastroRepetidoException o)
				{
					System.out.println("Dados já cadastrados!");
				}

				break;


			case 2:
				/*
				 * Criando um iterador para listar os cidadoes
				 */
				Iterador at = facade.listarCidadaos();
				System.out.println("Lista de Cidadões!\n");
				
				while (at.temProximo()) //verificando se tem um proximo.
				{
					Cidadao temp =  (Cidadao) at.proximo(); //objeto do tipo cidadao recebendo o proximo
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endereço:"+temp.getEndereco());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 3:

				/*
				 * Tratando as exceções para consultar a divida.
				 */
				try
				{

					System.out.println("Digite o cpf:");
					String cpfCidadao=console.readString();

					System.out.println(facade.consultarDivida(cpfCidadao));
				}
				catch( CidadaoNaoEncontradoException o)//exceção caso não encontre o cpf.
				{

					System.out.println("Cidadão nao encontrado!");
				}
				break;

			case 4:
				/*
				 * Tratando as exceções para pagar divida
				 */
				try
				{
					System.out.println("Digite seu cpf:");
					String cpfCidadao= console.readString();

					System.out.println("Digite o valor a ser pago:");
					double valor = Console.readDouble();

					facade.pagarDivida(cpfCidadao, valor);
				}
				catch(CidadaoNaoEncontradoException o)//caso não encontre o cidadao
				{
					System.out.println("Dados não encotrado!");
				}

				break;

			case 5:

				/*
				 * Tratando as exceções para para cadastrar atendente.
				 */
				try
				{

					System.out.println("Digite seu cpf:");
					String cpf=console.readString();

					System.out.println("Digite o seu nome:");
					String nome = console.readString();
					//String cpf=console.readString();

					System.out.println("Digite seu endereço:");
					String endereco=console.readString();

					System.out.println("Digite o valor do salário:");
					double salario=console.readDouble();

					facade.cadastrarAtendente(cpf, nome, endereco, salario);

				}
				catch(CadastroRepetidoException e)// caso o cpf já exista.
				{
					System.out.println("Dados já cadastrados!");
				}
				catch(CapacidadeMaximaException m)//pois a capacidade maxima é 5 
				{
					System.out.println("já está com o maximo possivel de atendentes!");
				}
				break;

			case 6:
				/*
				 * Listando os atendentes, criando um iterador que recebe o metodo do facade.
				 */
				Iterador ut = facade.listarAtendentes();
				System.out.println("Lista de Atendentes!\n");
				while (ut.temProximo())//verificando se existe um proximo
				{
					Atendente temp = (Atendente)ut.proximo();//objeto recebendo um proximo
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endereço:"+temp.getEndereco());
					System.out.println("Salário:"+((Atendente) temp).getSalario());
					System.out.println("\n");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 7:

				/*
				 * Listando atendentes disponiveis.
				 */
				Iterador it = facade.listarAtendentesDisponiveis();
				System.out.println("Lista de Atendentes Disponiveis!\n");
				while (it.temProximo()) //verificando se tem um proximo.
				{
					Atendente temp = (Atendente) it.proximo();//recebendo um proximo do iterador
					System.out.println("Cpf:"+temp.getCpf());
					System.out.println("Nome:"+temp.getNome());
					System.out.println("Endereço:"+temp.getEndereco());
					System.out.println("Salário:"+((Atendente) temp).getSalario());
					System.out.println("\n");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;
			case 8:
				/*
				 * Tratando as exceções para cadastrar ambulancia
				 */
				try
				{
					System.out.println("Digite o numero da placa da ambulância:");
					String placa=console.readString();

					facade.cadastrarAmbulancia(placa);
				}
				catch(CadastroRepetidoException c)//caso a ambulancia já esteja cadastrada
				{
					System.out.println("Ambulância ja cadastrada!");

				}
				catch( CapacidadeMaximaException c)//caso a ambulancia o numero de ambulancias passe das 10.
				{
					System.out.println("Capacidade de ambulâncias maxima antingida!");
				}

				break;

			case 9:

				/*
				 * Listando ambulancias disponiveis para atendimento, criando um interador e imprimindo o mesmo
				 */
				Iterador rt = facade.listarAmbulanciasDisponiveis();
				System.out.println("Lista de Ambulâncias Disponiveis!\n");
				while (rt.temProximo())//verificando se existe um proximo
				{

					Ambulancia temp =  (Ambulancia) rt.proximo();//objeto ambulancia recebe um proximo
					System.out.println("Placa:"+temp.getPlaca());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 10:

				/*
				 * Lista ambulancias existentes.
				 */
				Iterador mt = facade.listarAmbulancias();
				System.out.println("Lista de ambulâncias!");
				while (mt.temProximo()) //verificando se existi um proximo
				{
					Ambulancia temp =  (Ambulancia) mt.proximo();//objeto do tipo ambulancia recebe o proximo
					System.out.println("Placa:"+temp.getPlaca());
					System.out.println("\n");

				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine();

				break;

			case 11:

				/*
				 * Tratando cadastrar ocorrencia.
				 */
				try{
					System.out.println("Digite o cpf:");
					String cpf=console.readString();

					System.out.println("Digite o numero de ambulâncias:");
					int qtdAmbulancias=console.readInt();
					facade.cadastrarOcorrencia(cpf, qtdAmbulancias);
				}
				catch(CidadaoNaoEncontradoException m)//caso o cidadao não esteje cadastrado.
				{
					System.out.println("Cidadão não encontrado no cadastro!");
				}

				catch(AtendenteIndisponivelException m)//todos atendentes estão ocupados.
				{
					System.out.println("Todos atendentes ocupados!");
				}
				break;

			case 12:

				/*
				 * Tratando atender ocorrencia.
				 */
				try{
					System.out.println("Digite o numero da Ocorrência:");
					int idOcorrencia=console.readInt();
					facade.atenderOcorrencia(idOcorrencia);
				}
				catch(AmbulanciasInsifucienteException o)
				{
					System.out.println("Ambulâncias insuficientes para atendimento!");
				}
				catch(OcorrenciaNaoEncontradaException a)//ocorrencia não encotrada
				{
					System.out.println("Ocorrencia não foi encontrada!");
				}
				catch(QuantidadeDiferenteAmbulanciasException q)// quantidade diferente.
				{
					System.out.println("Quantidade diferente!");
				}
				break;
			case 13:

				/*
				 * Tratando finalizar ocorrencia
				 */
				try
				{
					System.out.println("Digite o numero da Ocorrência:");
					int idOcorrencia=console.readInt();
					facade. finalizarOcorrencia(idOcorrencia);
				}

				catch(OcorrenciaNaoEncontradaException a)//ocorrencia não encontrada.
				{
					System.out.println("Ocorrência não foi encontrada!");
				}
				break;

			case 14:

				/*
				 * listando ocorrencias ativas
				 */
				Iterador ot = facade.listarOcorrenciasAtivas();
				System.out.println("Lista de Ocorrencias Ativas!\n");
				while (ot.temProximo()) //verifica se existe um proximo.
				{
					Ocorrencia temp =  (Ocorrencia) ot.proximo();//objeto do tipo ocorrencia recebe o proximo
					System.out.println("Id:"+temp.getId());
					System.out.println("Status:"+temp.getStatus());
					System.out.println("Quantidadade de ambulancias:"+temp.getQtdAmbulancias());
					System.out.println("\n");
				}
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;

			case 15:

				/*
				 * consultar ocorrencia.
				 */
				try
				{

					
					System.out.println("Digite a id da ocorrência que deseja recuperar:");
					int idOcorrencia = console.readInt();
					Ocorrencia a=facade.consultarOcorrencia(idOcorrencia);//objeto do tipo ocorrencia recebe o que deseja consultar

					System.out.println("Id: " + a.getId());
					System.out.println("Nome do cidadão que solicitou a ocorrência: " + a.getCidadao().getNome());                        
					System.out.println("Quantidades de ambulâncias solicitadas: " + a.getQtdAmbulancias());
					System.out.println("Status: " + a.getStatus());
					System.out.println("Nome da atendente que registrou a ocorrência: " + a.getAtendente().getNome()); 

				}

				catch(OcorrenciaNaoEncontradaException a)//caso não esteje cadastrado
				{
					System.out.println("Ocorrencia não foi encontrada!");
				}

				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine();
				break;

			case 16:
				//condição que sair do while.
				repeticao=true;
				break;
			
			default:

				System.out.println("Opçao só é de 1 à 16");
				System.out.println("Pressione qualquer tecla para continuar!");  
				in.readLine(); 
				break;
			}
		}
	}

}
