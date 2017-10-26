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

public class MenuIterador implements Iterador 

{
	/**
	 * Essa classe implementa o comportamento do MenuIterador. E ajuda a varrer a estrutura de dados.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	 private No novo;
	
	 /**
	  * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	  * @param novo-No
	  */
	 public MenuIterador(No novo)
	 {
		this.novo=novo;
		 
	 }
	 /**
	  * Método temProximo é usado para saber se existi um proximo ou ele é null, caso ele 
	  * for diferente de null ele retorna um true e se for igual a null retorna um false.
	  * 
	  * @return boolean
	  */
	@Override
	public boolean temProximo() 
	 {
		// TODO Auto-generated method stub
		if(novo!=null)
		{
			return true;
		}
		
		return false;
	 }

	/**
	 * O método proximo é utilizado para pegar o proximo objeto da lista.
	 * @return null- caso for diferente de temProximo
	 * @return retorna o proximo objeto da lista.
	 */
	@Override
	public Object proximo() 
	{
		// TODO Auto-generated method stub
		Object auxiliar;
				
		if(!temProximo())
		{
			return null;
		}
		
		else
		{
			auxiliar=novo;
			novo=novo.getNext();
			return ((No) auxiliar).getDados();
		}
			
	
		
	 }

}
