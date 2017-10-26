/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Washington Pagotto Batista>
 * Data:  <28/03/2014>
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

package br.uefs.ecomp.folitron.model;

import br.uefs.ecomp.folitron.util.Iterador;
import br.uefs.ecomp.folitron.util.ListaEncadeada;

public class Transporte 
{
	/**
	 * Essa classe implementa o comportamento do Transporte. Portando ela contém atributos de um Transporte
	 * id, nome,tipo, valor, capacidade,saida, localSaida, retorno, chegada,localChegada. 
	 * Além disso, ela armazena uma referência para as sessões de Folioes.
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	private ListaEncadeada TRANSPORTEfolioes=new ListaEncadeada();
	private int id;
	private String nome;
	private String tipo;
	private double valor;
	private int capacidade;
	private int saida;
	private String localSaida;
	private int retorno;
	private String localRetorno;
	private int chegada;
	private String localChegada;
	private Bloco b1;
	
	
	/**
	 * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	 * 
	 * @param nome
	 * @param tipo
	 * @param valor
	 * @param capacidade
	 * @param saida
	 * @param localSaida
	 * @param retorno
	 * @param localRetorno
	 * @param chegada
	 * @param localChegada
	 * @param b1
	 */
	
	public Transporte(String nome, String tipo, double valor, int capacidade,int saida, 
			String localSaida,int retorno,String localRetorno, int chegada, String localChegada,Bloco b1)
	{
		
		
		this.nome=nome;
		this.tipo=tipo;
		this.valor=valor;
		this.capacidade=capacidade;
		this.saida=saida;
		this.localSaida=localSaida;
		this.retorno=retorno;
		this.localRetorno=localRetorno;
		this.chegada=chegada;
		this.localChegada=localChegada;
		this.b1=b1;
	}
	
	 /**
     * Método para retorno de um id do transporte.
     * 
     * @return int- numero de id.
     */
	public int getId()
	{
		return id;
	}
	 /**
     * Método para retorno de um nome do transporte.
     * 
     * @return String- nome 
     * 
     */
	public String getNome()
	{
		return nome;
	}
	 /**
     * Método para retorno de um tipo do transporte.
     * 
     * @return String- tipo do transporte utilizado.
     */
	public String getTipo()
	{
		return tipo;
	}
	 /**
     * Método para retorno de um valor do transporte.
     * 
     * @return double- valor do transporte utilizado.
     */
	public double getValor()
	{
		return valor;
	}
	 /**
     * Método para retorno de uma capacidade do transporte.
     * 
     * @return int- capacidade de vagas no transporte.
     */
	public int getCapacidade()
	{
		return capacidade;
	}
	 /**
     * Método para retorno de uma saida do transporte.
     * 
     * @return int- horario da saida do transporte.
     */
	public int getSaida()
	{
		return saida;
	}
	 /**
     * Método para retorno de um localSaida do transporte.
     * 
     * @return String- lugar a onde vai sair o transporte.
     */
	public String getLocalSaida()
	{
		return localSaida;
	}
	 /**
     * Método para retorno de um transporte.
     * 
     * @return int- horario de retorno do transporte
     */
	public int getRetorno()
	{
		return retorno;
	}
	 /**
     * Método para retorno de um localRetorno do transporte.
     * 
     * @return String- localizaçao de onde vai retorna o transporte.
     */
	public String getLocalRetorno()
	{
		return localRetorno;
	}
	 /**
     * Método para retorno de uma chegada do transporte.
     * 
     * @return int- horario da chegada do transporte.
     */
	public int getChegada()
	{
		return chegada;
	}
	/**
	 * Esse método é utilizado para modificação do atributo localChegada. E assim como é um método void ele não
	 * tem retorno
	 * @param localChegada- local a onde vai chegar o transporte
	 */
	public String getLocalChegada()
	{
		return localChegada;
	}
	/**
	 * Esse método é utilizado para modificação do atributo bloco. E assim como é um método void ele não
	 * tem retorno
	 * @param bloco- b1
	 */
	public Object getBloco()
	{
		return b1;
	}
	/**
	 * Esse método é utilizado para modificação do atributo cpf. E assim como é um método void ele não
	 * tem retorno
	 * @param id- numero de identificação do transporte.
	 */
	public void setId(int id)
	{
		this.id=id;
		
	}
	/**
	 * Esse método é utilizado para modificação do atributo nome. E assim como é um método void ele não
	 * tem retorno
	 * @param nome- pra onde o transporte vai
	 */
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	/**
	 * Esse método é utilizado para modificação do atributo tipo. E assim como é um método void ele não
	 * tem retorno
	 * @param tipo- qual o tipo de transporte utilizado
	 */
	public void setTipo(String tipo)
	{
		this.tipo=tipo;
	}
	/**
	 * Esse método é utilizado para modificação do atributo valor. E assim como é um método void ele não
	 * tem retorno
	 * @param valor- preço da utilização do transporte
	 */
	public void setValor(double valor)
	{
		this.valor=valor;
	}
	/**
	 * Esse método é utilizado para modificação do atributo capacidade. E assim como é um método void ele não
	 * tem retorno
	 * @param capacidade- quantas vagas tem no transporte.
	 */
	public void setCapacidade(int capacidade)
	{
		this.capacidade=capacidade;
		
	}
	/**
	 * Esse método é utilizado para modificação do atributo saida. E assim como é um método void ele não
	 * tem retorno
	 * @param saida- horario da saida do transporte
	 */
	public void setSaida(int saida)
	{
		this.saida=saida;
	}
	/**
	 * Esse método é utilizado para modificação do atributo localSaida. E assim como é um método void ele não
	 * tem retorno
	 * @param localSaida- de onde vai sair o transporte.
	 */
	public void setLocalSaida(String localSaida)
	{
		this.localSaida=localSaida;
	}
	/**
	 * Esse método é utilizado para modificação do atributo retorno. E assim como é um método void ele não
	 * tem retorno
	 * @param retorno- qual o horario de retorno do transporte.
	 */
	public void setRetorno(int retorno)
	{
		this.retorno=retorno;
	}
	/**
	 * Esse método é utilizado para modificação do atributo LocalRetorno. E assim como é um método void ele não
	 * tem retorno
	 * @param localRetorno- qual o local de retorno.
	 */
	public void setLocalRetorno(String localRetorno)
	{
		this.localRetorno=localRetorno;
	}
	/**
	 * Esse método é utilizado para modificação do atributo chegada. E assim como é um método void ele não
	 * tem retorno
	 * @param chegada- horario da chegada do transporte.
	 */
	public void setChegada(int chegada)
	{
		this.chegada=chegada;
	}
	/**
	 * Esse método é utilizado para modificação do atributo localChegada. E assim como é um método void ele não
	 * tem retorno
	 * @param localChegada- a onde o transporte vai chegar.
	 */
	public void setLocalChegada(String localChegada)
	{
		this.localChegada=localChegada;
	}
	
	/**
	 * Esse método é utilizado para modificação do atributo bloco. E assim como é um método void ele não
	 * tem retorno
	 * @param bloco-b1
	 */
    public void setBloco(Bloco b1)
    {
    	this.b1=b1;
    }
    /**
	   * Esse método é utilizado na comparação de atributos, e assim ele recebe como parametro um object
	   * do tipo obj. Sendo assim faz a verificação das comparações pra ver se são iguais e retorna um boolean.
	   * 
	   * @param obj- Object.
	   * @return boolean
	   */
    public boolean equals(Object obj) 
    {
        //instanceof = verifica se o obj é da mesma classe usada
        if(obj instanceof Transporte)
        {
            Transporte t = (Transporte) obj;
            if(t.getNome().equals(getNome()) && t.getTipo().equals(getTipo()) && t.getValor() == getValor()
                    && t.getCapacidade() == getCapacidade() && t.getSaida() == getSaida() 
                    && t.getLocalSaida().equals(getLocalSaida()) && t.getRetorno() == getRetorno()
                    && t.getLocalRetorno().equals(getLocalRetorno()) && t.getChegada() == getChegada()
                    && t.getLocalChegada().equals(getLocalChegada()) && t.getBloco().equals(getBloco()))
            {
                
            	return true;
            }
        }
        
        return false;
        
     }
    
    /**
     * Esse método compara os folioes e seus demais atributos caso exista dados duplicados ele retorna true ou se não
     * existir retorna false.
     * 
     * @param foliao
     * @return boolean.
     */
     public boolean comparacaoFoliao(Foliao foliao)
     {
		
		int x=TRANSPORTEfolioes.tamanho();
		
		for(int i=0; i<x;i++)
		{
			if(TRANSPORTEfolioes.recupera(i).equals(foliao))
			{
				return true;
			}
				
	    }
		return false;
	
     }

    /**
     * Esse método serve para ver se a capacidade do transporte já está lotada, e se caso já esteje ele
     * retorna true.
     * 
     * @return boolean
     */
     public boolean verificaCapacidade()
     {
	
	    int total=TRANSPORTEfolioes.tamanho();
	
	    if(capacidade==total)
	    {
		   return true;
	    }
	
	    return false;
     
     }
     /**
      * Esse método insere foliao em Transportes.
      * 
      * @param foliao
      */
     public void insereFoliao(Foliao foliao)
     {
	
	    TRANSPORTEfolioes.insereFinal(foliao);
	
     }
     /**
      * Esse método serve para varrer os dados
      * @return iterador
      */
     public Iterador iteradorTransporte()
    {
	    
	   return TRANSPORTEfolioes.iterador();
	
    }

}
