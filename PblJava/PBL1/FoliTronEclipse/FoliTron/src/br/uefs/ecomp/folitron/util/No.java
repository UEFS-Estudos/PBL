/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: <Washington Pagotto Batista>
 * Data:  <29/03/2014>
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

public class No 
{
	/**
	 * Essa classe implementa o comportamento do No.
	 *   
	 * @author <Washington Pagotto Batista>
	 * 
	 * 
	 */
	
	private Object dados;
	private No next;
	
	/**
	 * O construtor é chamado na criação de um objeto. E assim inicializa seus dados de forma organizada.
	 * @param dados- informaçoes do objeto
	 */
	public No(Object dados)
	{
		this.dados=dados;
		next=null;
	}
    /**
     * Método para retorno de dados.
     * @return object-dados.
     */
	public Object getDados()
	{
		return dados;
	}
	/**
	 * Método para retorno do next do No
	 * @return No- next
	 */
	public No getNext()
	{
		return next;
	}
	/**
	 * Esse método é utilizado para modificação do object dados. E assim como é um método void ele não
	 * retorna nada.
	 * @param dados
	 */
	public void setDados(Object dados)
	{
		this.dados=dados;
	}
	/**
	 * Esse método é utilizado para modificação do atributo cpf. E assim como é um método void ele não
	 * retorna nada.
	 * @param next
	 */
	public void setNext(No next)
	{
		this.next=next;
	}
	/**
	 * Esse método é utilizado para modificação do atributo cpf. E assim como é um método void ele não
	 * retorna nada.
	 * @return
	 */
	public Object getObject()
	{
		return dados;
	}
}
