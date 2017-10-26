/** 
 * Componente Curricular: M�dulo Integrado de Programa��o 2
 * Autor: Kayo Costa de Santana 
 * Data: 22/03/2014
 * Declaro que este c�digo foi elaborado por mim de forma individual e 
 * n�o cont�m nenhum trecho de c�digo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p�ginas ou documentos 
 * eletr�nicos da Internet. Qualquer trecho de c�digo de outra autoria que 
 * uma cita��o para o n�o a minha est� destacado com autor e a fonte do 
 * c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins 
 * de avalia��o. Alguns trechos do c�digo podem coincidir com de outr'  qaos 
 * colegas pois estes foram discutidos em sess�es tutorias. 
 * Esta classe foi reutilizada do PBL1.
 */

package br.uefs.ecomp.visWarm.util;

/**
 * Nesta classe ser�o criados os atributos necess�rios para a implementa��o das estruturas de dados.
 * @author Kayo Costa de Santana
 *
 */
class Link {
    private Object celula;
    private Link anterior, proximo;
    
    /**
     * O m�todo � respons�vel por instanciar um novo Link.
     * @param celula Object 
     */
    public Link(Object celula) {
    this.celula=celula;
    anterior = null;
    proximo = null;
    }
    
          
    /**
     * O metodo � utilizado para retornar objeto presente no Link.
     * @return  celula Object
     */
    public Object getCelula() {
        return celula;
    }

    /**
     * O metodo � respons�vel por alterar o objeto presente no Link.
     * @param celula Object
     */
    public void setCelula(Object celula) {
        this.celula = celula;
    }

    /**
     * O metodo � utilizado para retornar a referencia de um elemento anterior.
     * @return anterior Link
     */
    public Link getAnterior() {
        return anterior;
    }

    /**
     * O metodo respons�vel por alterar o elemento anterior.
     * @param anterior Link
     */
    public void setAnterior(Link anterior) {
        this.anterior = anterior;
    }

    /**
     * O m�todo � ultilizado para retornar a referencia de um elemento posterior.
     * @return proximo Link
     */
    public Link getProximo() {
        return proximo;
    }

    /**
     * O metodo � respons�vel por alterar o elemento posterior.
     * @param proximo Link
     */
    public void setProximo(Link proximo) {
        this.proximo = proximo;
    }

    
}
