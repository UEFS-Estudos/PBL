/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto 
 * Data: 14/06/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias. Esta classe foi
 * reutilizada do PBL1.
 */
package br.uefs.ecomp.visWarm.util;

/**
 * Este método implementa o comportamento de um nó. Este nó será inserido ná
 * arvore AVL.
 *
 * @author Kayo Costa e Washington Paggoto
 * @see br.uefs.ecomp.visWarm.util.ArvoreAVL
 */
public class No {

    private No fEsquerdo;
    private No fDireito;
    private int altura;
    private Object objeto;

    /**
     * Construtor da classe No, resposável por instanciar um novo No.
     *
     * @param objeto
     */
    public No(Object objeto) {
        this.objeto = objeto;
        fEsquerdo = null;
        fDireito = null;
        altura = 0;
    }

    /**
     * Método responsável por retornar a referencia do filho esquerdo de um No.
     *
     * @return fEsquerdo No
     */
    public No getfEsquerdo() {
        return fEsquerdo;
    }

    /**
     * Método responsável por alterar o filho esquerdo de um No.
     *
     * @param fEsquerdo No
     */
    public void setfEsquerdo(No fEsquerdo) {
        this.fEsquerdo = fEsquerdo;
    }

    /**
     * Método responsável por retornar a referencia do filho direito de um No.
     *
     * @return fDireito No
     */
    public No getfDireito() {
        return fDireito;
    }

    /**
     * Método responsável por alterar o filho direito de um No.
     *
     * @param fDireito No
     */
    public void setfDireito(No fDireito) {
        this.fDireito = fDireito;
    }

    /**
     * Método responsável por retornar a altura do No.
     *
     * @return altura int
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Método responsável por alterar a altura do no.
     *
     * @param altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Método responsável por retornar o objeto armazenado em um No.
     *
     * @return Object
     */
    public Object getObjeto() {
        return objeto;
    }

    /**
     * Método responsável por alterar o objeto armazenado em um No.
     *
     * @param objeto
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}
