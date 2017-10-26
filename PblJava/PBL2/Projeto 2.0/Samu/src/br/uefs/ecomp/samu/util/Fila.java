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
public class Fila implements IFila {
    
	//Atributo da classe	
	private ListaEncadeada fila;
	
	//construtor da classe
	public Fila(){
		fila= new ListaEncadeada();
	}
	
	@Override
	/**
     * Verifica se a fila está vazia, usando o método da lista Encadeada.
     * @return verdadeiro, se a fila estiver vazia e falso caso contrário.
     */ 
	public boolean estaVazia() {
		//retornando a fila, atraves do metodo da Lista Encadeada.
		return fila.estaVazia();
	}

	@Override
	/**
     * Quantidade de objetos na fila, usando o método da lista Encadeada.
     * @return o tamanho da fila.
     */
	public int tamanho() {
		// TODO Auto-generated method stub
		return fila.tamanho();
	}

	@Override
	 /**
     * Insere um objeto no final da fila, usando o método da lista Encadeada.
     * @param o objeto a ser inserido no final da fila.
     */
	public void insereFinal(Object o) {
		fila.insereFinal(o);
	}

	@Override
	/**
     * Remove um objeto do início da fila, usando o método da lista Encadeada.
     * @return o objeto removido do início da fila.
     */
	public Object removeInicio() {
		return fila.removeInicio();
	}

	@Override
	/**
     * Faz uma busca recuperando um objeto do início da fila sem remover ele, 
     * utilizando o método da lista Encadeada.
     * @return o objeto armazenado no início da fila.
     */
	public Object recuperaInicio() {
		return fila.recupera(0);
	}
	
	/**
     * Esse metodo é responsavel pela criação de um iterador da fila. 
     * @return Nele é criado um novo objeto iterador e o mesmo é retornado.
     */
	public Iterador iterador() 
	{
		// TODO Auto-generated method stub
		
		Iterador iterador = new MeuIterador (fila.getAtual());
		return iterador;
	}

}
