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


public class Foliao 
{
	/**
	 * Essa classe implementa o comportamento do Foliao. Portando ela contém atributos de um Foliao
	 * cpf, rg,nome e idade. 
	 *  
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
	 
	   private String cpf;
	   private String rg;
	   private String nome;
	   private int idade;
	   
	   /**
	    * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	    * 
	    * @param cpf- numero do cpf
	    * @param rg- numero do rg
	    * @param nome- nome do foliao
	    * @param idade- quantos anos ele tem
	    */
	   public Foliao(String cpf, String rg,String nome, int idade)
	   {
		   
		   this.cpf=cpf;
		   this.rg=rg;
		   this.nome=nome;
		   this.idade=idade;
		   
	   }
		/**
		 * Método que retorna o numero do cpf
		 * 
		 * @return String-cpf
		 */
		public String getCpf()
		{
			return cpf;
		}
		/**
		 * Método que retorna o numero do rg
		 * 
		 * @return String- Rg
		 */
		public String getRg()
		{
			return rg;
		}
		
		/**
		 * Método que retorna o nome do foliao
		 * @return String-Nome
		 */
		public String getNome()
		{
			return nome;
		}
        /**
         * Método que retorna a idade do foliao
         * @return int- idade
         */
		public int getIdade()
		{
			return idade;
		}

		/**
		 * Esse método é utilizado para modificação do atributo cpf. E assim como é um método void ele não
		 * tem retorno
		 * @param cpf- numero do cpf
		 */
		public void setCpf(String cpf)
		{
			this.cpf=cpf;
		}

        /**
         * Esse método é utilizado para modificação do atributo rg. E assim como é um método void ele não
         * tem retorno  
         * @param rg- numero do rg
         */
		public void setRg(String rg)
		{
			
			this.rg=rg;
		}
        /**
         * Esse método é utilizado para modificação do atributo nome. E assim como é um método void ele não
         * tem retorno
         * @param nome
         */
		public void setNome(String nome)
		{
			this.nome=nome;
		}

	    /**
	     * Esse método é utilizado para modificação do atributo idade. E assim como é um método void ele não
	     * tem retorno
	     * @param idade- quantos anos o foliao tem.
	     */
		public void setIdade(int idade)
		{
			this.idade=idade;
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
			
			if(obj instanceof Foliao)
			{ 
				
				Foliao f = (Foliao) obj; 
				
				if(f.getCpf().equals(getCpf()) && f.getRg().equals(getRg()) && f.getNome().equals(getNome()) 
						&& f.getIdade() == getIdade())
				{ 
					
					return true; 
				} 
			} 
			
			return false;
		}
		
}
