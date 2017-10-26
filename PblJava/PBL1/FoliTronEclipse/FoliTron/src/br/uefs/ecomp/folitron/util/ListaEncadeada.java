/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Washington Pagotto Batista>
 * Data:  <30/03/2014>
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

package br.uefs.ecomp.folitron.util;

public class ListaEncadeada implements ILista 
{
	
	/**
	 * Essa classe implementa o comportamento do ListaEncadeada.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	private int tamanho=0;
	private No atual;
	private No anterior;
	private No ultimo;
	
	/**
	 * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	 */
	public ListaEncadeada()
	{
		
		atual=null;
		anterior=null;
		ultimo=null;
	}
	
	/**
	 * Esse metodo verifica se a lista encadeada está vazia caso o tamanho seje zero ele retorna false, se for diferente
	 * retorna true.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean estaVazia()
	{
		// TODO Auto-generated method stub
		if(tamanho!=0)
		{
			return false;
		}
		
		return true;
	}
    
	/**
     * Esse método verifica o tamanho da lista encadeada.
     * 
     * @return int- tamanho da lista encadeada.
     */
	@Override
	public int tamanho() 
	{
		// TODO Auto-generated method stub
		
		return tamanho;
	}
    
	/**
	 * Esse método é do tipo void, portando não retorna nada. Serve para inserir no incio da lista
	 * o objeto.
	 * 
	 * @param object
	 */
	@Override
	public void insereInicio(Object o) 
	{
		// TODO Auto-generated method stub
		No novo=new No(o);
		novo.setNext(atual);
		atual=novo;
		
		if(this.tamanho==0)
		{
			this.ultimo=atual;
		}
		
		tamanho++;
		
	}
    
	/**
     * Esse método insere o objeto no final da lista, sendo assim como ela é void não apresenta retorno. Com isso a primeira
     * condição é se o a lista já foi criada caso não ela chamará o método insereInicio.
     * 
     * @param object
     */
	
	@Override
	public void insereFinal(Object o) 
	{
		// TODO Auto-generated method stub
		
		if (tamanho == 0) 
		{
	         this.insereInicio(o);
	    } 
		
		else 
		{
	         No nova = new No(o);
	         nova.setNext(null);
	         while(atual==null)
	         {
	        	 this.ultimo = nova;
		         this.atual=nova;
	         }
	        
	         ultimo.setNext(nova);
	         this.ultimo=nova;
	         tamanho++;
	     }
	    
	   
	}
    
	/**
     * Este método remove incio da lista, sendo assim a primeira verificação é caso a lista esteje vazia.Com isso
     * a lista será apontada pro proximo sempre decrementando.
     * 
     * @return apontando pro primeiro da lista
     */
	@Override
	public Object removeInicio() 
	{
		// TODO Auto-generated method stub
		No novo=atual;
		if( estaVazia())
		{
			return null;
		}
		
		atual=atual.getNext();
		tamanho--;
		return novo.getObject(); 
		
	}
    
	/**
     * Esse método remove o ultimo elemento da lista encadeada. A primeira verificação é se a lista está vazia e caso verdade
     * ele retorna um null. A segunda verificação é caso só exista uma celula na lista.
     * @return que está vazia
     * @return retorna a instância do objeto 
     */
	@Override
	public Object removeUltimo() 
	{
		// TODO Auto-generated method stub
		
		No novo=atual;
		if(estaVazia())
		{
			return null;
		}
		
		if(tamanho==1)
		{
			novo=atual;
			atual=null;
			
		}
		
		while(novo.getNext()!=null)
		{
			anterior=novo;
			novo=novo.getNext();
		}
		anterior.setNext(null);
		tamanho--;
		return novo.getObject();
		
	}
    
	/**
     * Método recupera serve pra buscar uma celula que ele deseja. Sendo que essa celula é buscada na lista através do index
     * que passa a posição que deseja.
     * @param int-index 
     * 
     */
	@Override
	public Object recupera(int index) 
	{
		// TODO Auto-generated method stub
		int auxiliar=0;
		No novo=atual;
		
		while((auxiliar!=index))
		{
			if(novo!=null)
			{ 
			novo=novo.getNext();
		    auxiliar++;
			}
		}
		
		return novo.getObject();
	}
    
	/**
     * Esse método serve para varrer uma estrutura de dados.
     * @return iterador recebe atual e retorna o mesmo
     */
	@Override
	public Iterador iterador() 
	{
		// TODO Auto-generated method stub
		
		Iterador iterador = new MenuIterador (atual);
		return iterador;
	}

}
