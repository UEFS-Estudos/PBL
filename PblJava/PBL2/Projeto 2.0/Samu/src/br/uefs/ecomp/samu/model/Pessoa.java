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

package br.uefs.ecomp.samu.model;

/**
*
* @author Washington Pagotto Batista
*/

public class Pessoa 
{

	//atributos da classe.
	private String cpf;
	private String nome;
	private String endereco;

	//construtor da classe.
	public Pessoa(String cpf,String nome,String endereco)
	{
		this.cpf=cpf;
		this.nome=nome;
		this.endereco=endereco;
	}

	/**
	 * Esse metodo é usado para fazer a verificação do atributo Cpf da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getCpf()
	{
		return cpf;
	}

	/**
	 * Esse metodo é usado para fazer a verificação do atributo Nome da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * Esse metodo é usado para fazer a verificação do atributo endereco da classe Pessoa
	 * @return retorna o valor verificado.
	 */
	public String getEndereco()
	{
		return endereco;
	}

	/**
	 * Esse metodo é usado para fazer a modificação do atributo cpf da classe Pessoa
	 * @param altera o atributo recebido.
	 */
	public void setCpf(String cpf)
	{
		this.cpf=cpf;
	}

	/**
	 * Esse metodo é usado para fazer a modificação do atributo nome da classe Pessoa.
	 * @param altera o atributo recebido
	 */
	public void setNome(String nome)
	{
		this.nome=nome;
	}

	/**
	 * Esse metodo é usado para fazer a modificação do atributo endereco da classe Pessoa.
	 * @param altera o atributo recebido
	 */
	public void setEndereco(String endereco)
	{
		this.endereco=endereco;
	}

	/**
	 * Esse metodo é utilizado para fazer a comparação de uma string ou outro
	 * tipo de atributo.
	 * @param recebe o objeto
	 */
	public boolean equals(Object obj) 
	{ 
		/**
		 * Recebendo como parametro um objeto de tipo
		 * object, é verificado se o objeto que foi recebido é do tipo ambulancia. Caso
		 * entre na condição é feita a comparação para verificar se os objetos sao
		 * iguais. Esse metodo apresenta um retorno boolean, ou seja, retorna um
		 * valor verdadeiro ou um falso.
		 */

		if(obj instanceof Pessoa)
		{

			Pessoa p=(Pessoa) obj;

			if(p.getNome().equals(getNome()) && p.getCpf().equals(getCpf()) && 
					p.getEndereco().equals(getEndereco()))
			{ 
				return true; 
			} 
		}

		return false;
	}

/**
 * Método que compara os nomes.
 * @param object
 * @return a nome.
 */
	public int compareTo(Object obj)
	{  
		return this.getNome().compareTo(((Pessoa) obj).getNome());  
	}  

}
