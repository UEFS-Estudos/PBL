/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Componente Curricular: M�dulo Integrado de Programa��o Autor: <Washington Pagotto Batista>
 * Data: <23/05/2014>
 *
 * Declaro que este c�digo foi elaborado por mim de forma individual e n�o
 * cont�m nenhum trecho de c�digo de outro colega ou de outro autor, tais como
 * provindos de livros e apostilas, e p�ginas ou documentos eletr�nicos da
 * Internet. Qualquer trecho de c�digo de outra autoria que uma cita��o para o
 * n�o a minha est� destacado com autor e a fonte do c�digo, e estou ciente que
 * estes trechos n�o ser�o considerados para fins de avalia��o. Alguns trechos
 * do c�digo podem coincidir com de outros colegas pois estes foram discutidos
 * em sess�es tutorias.
 */

package br.uefs.ecomp.samu.model;

/**
*
* @author Washington Pagotto Batista
*/

public class Cidadao extends Pessoa 
{

	//atributos da classe.
	private int qtdOcorrencias;
	private double dividaSamu;

	//construtor da classe.
	public Cidadao(String cpf, String nome, String endereco) {
		super(cpf, nome, endereco);

		// TODO Auto-generated constructor stub
	}


    /**
     * Esse metodo � usado para fazer a verifica��o do atributo NumOcorrenciasSolicitadas da classe cidadao
     * @return retorna o valor.
     */
	public int getNumOcorrenciasSolicitadas()
	{
		return qtdOcorrencias;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo DividaSamu da classe cidadao.
	 * @return retorna o valor.
	 */
	public double getDividaSamu()
	{
		return dividaSamu;
	}

 
	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo QtdOcorrencias da classe cidadao.
	 * @param alterar o valor recebido.
	 */
	public void setQtdOcorrencias(int qtdOcorrencias)
	{
		this.qtdOcorrencias=qtdOcorrencias;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo DividaSamu da classe cidadao.
	 * @param alterar o valor recebido.
	 */
	public void setDividaSamu(double dividaSamu)
	{
		this.dividaSamu=dividaSamu;
	}



}
