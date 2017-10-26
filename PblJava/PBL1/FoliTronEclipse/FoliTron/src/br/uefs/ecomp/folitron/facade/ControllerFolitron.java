/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Washington Pagotto Batista>
 * Data:  <01/04/2014>
 * 
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */



package br.uefs.ecomp.folitron.facade;

import br.uefs.ecomp.folitron.model.Bloco;
import br.uefs.ecomp.folitron.model.Foliao;
import br.uefs.ecomp.folitron.model.Transporte;
import br.uefs.ecomp.folitron.util.Iterador;
import br.uefs.ecomp.folitron.util.ListaEncadeada;


public class ControllerFolitron
{
	
	/**
	 * Essa classe implementa o comportamento do ControllerFolitron. 
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
    public ListaEncadeada blocos;
  	public ListaEncadeada transportes;
    public ListaEncadeada folioes;
	
    /**
	 * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	 */
    public ControllerFolitron()
    {
		
	    blocos=new ListaEncadeada();
	    transportes=new ListaEncadeada();
	    folioes=new ListaEncadeada();
	
	}
	/**
	 * Esse método é utilizado para cadastrar os blocos. Sendo que ele chama o método insereFinal para fazer o cadastro
	 *
	 * 
	 * @param nome- do bloco
	 * @param local- a onde vai sair o bloco.
	 * @param saida- horario de saida do bloco
	 * @return b- retorna o objeto que foi cadastrado
	 */
	public Bloco cadastrarBloco(String nome, String local, int saida)
	{
	
		int x=blocos.tamanho();
		Bloco b=new Bloco(nome,local,saida);
		b.setId(x+1);
		blocos.insereFinal(b);
		
		return b;
	}
	
	/**
	 * O método obter bloco faz um busca por id do bloco usando outro método que é o recupera.
	 * 
	 * @param id- numeração do bloco
	 * @return b- retorna o bloco que deseja
	 */
	public Bloco obterBloco(int id)
	{
		
		Bloco b=(Bloco)blocos.recupera(id);
		return b;
	
	}
	/**
	 * Esse método lista
	 * @param local- a onde será realizado o bloco.
	 * @param dataInicio- horario de incio. 
	 * @param dataFim- horario de termino do pbl.
	 * @return
	 */
	public Iterador listarBlocos(String local, int dataInicio, int dataFim)
	{

		int x=blocos.tamanho();
		ListaEncadeada aux=new ListaEncadeada();
		
		for(int i=0; i<x; i++)
		{
		
			Bloco b=(Bloco)blocos.recupera(i);
			 if(local.equals(b.getLocal())&& dataInicio>=b.getSaida()&&
                dataFim<=b.getSaida())
			 {
				 aux.insereFinal(blocos.recupera(i));
			 }
		}
		
		return aux.iterador();	

	}
	
    /**
     * O método cadastra transporte, chama o metodo inserir transporte para o seu cadastro. E assim a cada cadastro vai 
     * gerando uma identificação que é o id
     * @param nome- nome do transporte
     * @param tipo- qual tipo de veiculo
     * @param valor- preço do transporte.
     * @param capacidade- quantas vagas existe
     * @param saida- horario de saida.
     * @param localSaida- a onde é localização para a saida do transporte
     * @param retorno- qual horario do retorno
     * @param localRetorno- a onde é a localização para o retorno do transporte.
     * @param chegada- que horas vai chegar.
     * @param localChegada- qual o local da chegada 
     * @param bloco
     * @return o objeto
     */
	public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, 
							int saida, String localSaida, int retorno, String localRetorno, 
							int chegada, String localChegada, Bloco bloco) 
	{
			
		 int x=transportes.tamanho();
		 Transporte t= new Transporte(nome,tipo,valor,capacidade,saida,localSaida,retorno,localRetorno,chegada,localChegada,bloco);
		
		 for(int i=0; i<x;i++)
		 {
			if(t.equals(transportes.recupera(i)))
			{
				return null;
			}
		
		 }
		 
		 t.setId(x+1);
		 bloco.insereTransporte(t);
		 return t;
	}
	/**
	 * Esse método busca pela em transporte através do id a celula desejada. Sendo assim ele utiliza do método recuperar e 
	 * retorna o objeto.
	 * @param id
	 * @return t- objeto
	 */
	public Transporte obterTransporte(int id) 
	{
	
		 Transporte t=(Transporte)transportes.recupera(id);
		 return t;
	}
	
	/**
	 * 
	 * @param bloco
	 * @return
	 */
	public Iterador listarTransportes(Bloco bloco)
	{
		return bloco.iteradorBloco();
	}
	
	/**
	 * Esse método cadastra foliao. Sendo assim ele chama o método insere final para fazer o seu cadastro.
	 * @param cpf-numero do cpf
	 * @param rg-numero do rg
	 * @param nome- nome do foliao
	 * @param idade- quantos anos tem 
	 * @return f-objeto
	 */
	public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade)
	{
	       
	    Foliao f=new Foliao(cpf,rg,nome,idade);
	    folioes.insereFinal(f);
	    return f;
	
	}
	
	/**
	 * Esse método obtem o foliao através do cpf, sendo assim ele usa o recuperar pra quando achar o foliao 
	 * retorna o mesmo.
	 * @param cpf-numero do cpf
	 * @return o foliao desejado
	 */
	public Foliao obterFoliao(String cpf) 
	{
     
        int x=folioes.tamanho();
		for(int i=0; i<x;i++)
		{
			if(((Foliao) folioes.recupera(i)).getCpf().equals(cpf))
			{
				return (Foliao)folioes.recupera(i) ;
			}
				
	    }
	
		return null;
	}
	
	/**
	 * Esse método regista os folioes em transporte, sendo que verifica a capacidade se não está lotado e também se o foliao 
	 * está cadastrado. Se as condições forem aceitas ele registra no transporte.
	 * @param foliao
	 * @param transporte
	 * @return boolean
	 */
	public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte){
		
		if(!transporte.verificaCapacidade() && !transporte.comparacaoFoliao(foliao))
		{
			transporte.insereFoliao(foliao);
			return true;
		}
		
		else
		{
		
			return false;
		}
		
	}
    /**
     * Método listar folioes, varre a estrutura de transporte para fazer registra o foliao.
     * @param transporte
     * @return
     */
	public Iterador listarFolioes(Transporte transporte)
	{
		
		return transporte.iteradorTransporte();
	}
	
	
	
}
