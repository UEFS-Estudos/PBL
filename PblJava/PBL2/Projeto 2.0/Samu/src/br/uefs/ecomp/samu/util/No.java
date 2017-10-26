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
package br.uefs.ecomp.samu.util;

/**
*
* @author Washington Pagotto Batista
*/

public class No 
{

	//atributos da classe
	private Object dados;
	private No next;

	//construtor da classe
	public No(Object dados)
	{
		this.dados=dados;
		next=null;
	}

	/**
	 * Esse metodo é usado para fazer verificação do atributo dados da classe No.
	 *@return verifica o valor do objeto e retorna.
	 * 
	 */
	public Object getDados()
	{
		return dados;
	}

	/**
	 * Esse metodo é usado para verificar o campo next da classe No.
	 * @return verifica o valor do objeto e retorna
	 * 
	 */
	public No getNext()
	{
		return next;
	}

	/**
	 * Esse metodo é usado para fazer a modificação do atributo dados da classe No.
	 * @param recebe  novo valor.
	 */
	public void setDados(Object dados)
	{
		this.dados=dados;
	}

	/**
	 * Esse metodo é usado para fazer a modificação do atributo next da classe No.
	 * @param recebe um novo valor.
	 */
	public void setNext(No next)
	{
		this.next=next;
	}

	/**
	 * Esse metodo é usado para verificar o campo dados da classe No, como ele
	 * @return verifica um valor do objeto.
	 */
	public Object getObject()
	{
		return dados;
	}
}


