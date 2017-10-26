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

import br.uefs.ecomp.samu.util.ListaEncadeada;

/**
*
* @author Washington Pagotto Batista
*/
public class Ocorrencia 
{

	//Atributos da classe.
	private int id;
	private String status;
	private int qtdAmbulancias;
	private Cidadao cidadao;
	private Atendente atendente;
	private ListaEncadeada ambulanciasSolicitadas;

	
	//construtor da classe.
	public Ocorrencia(int id, int qtdAmbulancias)
	{

		this.id=id;
		this.qtdAmbulancias=qtdAmbulancias;
		status=("Aberta");
		ambulanciasSolicitadas= new ListaEncadeada();

	}
	
    /**
     * Esse metodo � usado para fazer a verifica��o do atributo id da classe Ocorrencia.
     * @return verifica e retorna o mesmo.
     */
	
	public int getId()
	{
		return id;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo Status da classe Ocorrencia.
	 * @return verifica e retorna o mesmo
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo QtdAmbulancias da classe Ocorrencia.
	 * @return verifica e retorna o mesmo
	 */
	public int getQtdAmbulancias()
	{
		return qtdAmbulancias;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo id da classe Ocorrencia
	 * @param recebe um inteiro e altera o seu valor
	 */
	public void setId(int id)
	{
		this.id=id;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo Status da classe Ocorrencia
	 * @param recebe uma String e altera ela.
	 */
	public void setStatus(String status)
	{
		this.status=status;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo qtdAmbulancias da classe Ocorrencia
	 * @param recebe um inteiro e altera ela.
	 */
	public void setQtdAmbulancias(int qtdAmbulancias)
	{
		this.qtdAmbulancias=qtdAmbulancias;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo cidadao da classe Ocorrencia.
	 * @return o que est� contido no atributo.
	 */
	public Cidadao getCidadao()
	{
		return cidadao;
	}

	/**
	 * Esse metodo � usado para fazer a verifica��o do atributo Atendente da classe Ocorrencia.
	 * @return o que est� contido no atributo.
	 */
	public Atendente getAtendente()
	{
		return atendente;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo cidadao da classe Ocorrencia
	 * @param recebe um objeto do tipo cidadao e altera o mesmo.
	 */
	public void setCidadao(Cidadao cidadao)
	{
		this.cidadao=cidadao;
	}

	/**
	 * Esse metodo � usado para fazer a modifica��o do atributo placa da classe Ocorrencia.
	 * @param recebe um um objeto do tipo object e altera ele.
	 */
	public void setAtendente(Object atendente)
	{
		this.atendente=(Atendente) atendente;
	}

	

	/**
	 * M�todo que verifica o Status da Ocorrencia, se ainda est� ativa.
	 * @return caso esteje ativa retorna um true, se n�o false.
	 */
	public boolean estaAtiva()
	{
		if(status.equals("Aberta") || status.equals("Em Atendimento"))
			return true;
		return false;
	}

	/**
	 * M�todo que insere Ambulancia em uma lista pois ela est� sendo solicitada.
	 * @param recebe um objeto do tipo Ambulancia.
	 */
	public void insereAmbulancia(Ambulancia a)
	{
		ambulanciasSolicitadas.insereFinal(a);
	}

	/**
	 * M�todo que remove Ambulancia da lista.
	 * @return a ambulancia que est� sendo removida.
	 */
	public Object removeAmbulancia()
	{
		return ambulanciasSolicitadas.removeInicio();
	}
}
