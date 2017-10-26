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

public class Bloco 
{
	/**
	 * Essa classe implementa o comportamento do Bloco. Portando ela contém atributos de um Bloco
	 * id, nome,local e saida. Além disso, ela armazena uma referência para as sessões de Transporte.
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */

	   private ListaEncadeada BLOCOtransporte= new ListaEncadeada();
	   private int id;
	   private String nome;
	   private String local;
	   private int saida;
	   
	   /**
	    * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	    * 
	    * @param nome- nome do bloco.
	    * @param local- o lugar a onde vai sair.
	    * @param saida- horario de saida.
	    */
	   public Bloco(String nome, String local,int saida)
	   {
			  
		   this.nome=nome;
		   this.local=local;
		   this.saida=saida;
		  
	   }

       /**
        * Método para retorno de um id do bloco.
        * 
        * @return int- numero de id.
        */
	   public int getId()
	   {
		  return id;
	   }
       
	   /**
        * Método para retorno do nome.
        * @return String- nome.
        */
	   
	   public String getNome()
	   {
		 return nome;
	   }
       
	   /**
	    * Método para um retorno do local de saida do bloco.
	    * 
	    * @return String-local.
	    */
	   
	   public String getLocal()
	   {
		return local;
	   }
       /**
        * Método para retorno do horario de saida do bloc.
        * 
        * @return int-saida.
        */
	   public int getSaida()
	  {
		return saida;
	  }
      /**
       * Esse método é utilizado para modificação do atributo id. E assim como é um método void ele não
       * tem retorno.
       * 
       * @param id- id gerado pra identificação.
       */
	  public void setId(int id)
	  {
		this.id=id;
	  }
	  /**
       * Esse método é utilizado para modificação do atributo nome. E assim como é um método void ele não
       * tem retorno.
       * 
       * @param nome- nome do bloco.
       */
	  public void setNome(String nome)
	  {
		
		this.nome=nome;
	  }
      
	  /**
       * Esse método é utilizado para modificação do atributo local. E assim como é um método void ele não
       * tem retorno.
       * 
       * @param local- local da saida do bloco.
       */
	  
	  public void setLocal(String local)
	  {
		this.local=local;
	  }
	  /**
       * Esse método é utilizado para modificação do atributo saida. E assim como é um método void ele não
       * tem retorno.
       * 
       * @param saida- horario da saida.
       * 
       */
	  public void setSaida(int saida)
	  {
		
		this.saida=saida;
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
		
		if(obj instanceof Bloco)
		{
			
			Bloco b=(Bloco) obj;
			
			if(b.getNome().equals(getNome()) && b.getLocal().equals(getLocal()) && b.getSaida() == getSaida())
			{ 
				return true; 
			} 
		}
		
		return false;
	  }
	
	  /** Método utilizado para inserir transporte em bloco, sendo assim é chamado dentro do método
	   * o insereFinal para cadastrar.
	   * 
	   * @param Transporte- Transporte.
	   */
	
	  public void insereTransporte(Transporte Transporte)
	  {
		
		BLOCOtransporte.insereFinal(Transporte);
		
	  }

	  /**
	   * Método usado para utilização do iterador que varre a estrutura de dados do 
	   * bloco.
	   * 
	   * @return iterador-BlocoTransporte.
	   */
	  public Iterador iteradorBloco()
	  {
		
		return BLOCOtransporte.iterador();
		
	  }

}
