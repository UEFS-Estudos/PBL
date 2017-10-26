/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Paggoto Data: 23/07/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias..
 */
package ecomp.uefs.br.model;

/**
 * Essa classe implementa o comportamento de Aresta.
 *
 * @author Kayo e Washington
 */
public class Aresta {
    /*
    os nomes dos vertices foram colocados como origem e fim para não criar confusão na confecção do código,
    sabe-se que o grafo não é direcionado, ou seja , inicio poderia ser fim e fim inicio
    */
    private Vertice VerticeOrigem;//primeiro vertice que pega da aresta no txt
    private Vertice VerticeFim;//segundo vertice que pega da aresta no txt
    private int tempo; //peso da aresta

    /**
     * Este método altera o vertice fim.
     * @param VerticeFim Vertice
     */
    public void setVerticeFim(Vertice VerticeFim) {
        this.VerticeFim = VerticeFim;
    }

    /**
     * Este método altera o vertice de origem
     * @param VerticeOrigem Vertice
     */
    public void setVerticeOrigem(Vertice VerticeOrigem) {
        this.VerticeOrigem = VerticeOrigem;
    }

    /**
     * Este método altera o tempo
     * 
     * @param tempo int
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    
    /**
     * Este método retorna o valor do tempo.
     * @return tempo int
     */
    public int getTempo() {
        return tempo;
    }
    
    /**
     * Construtor da classe
     * @param o Vertice
     * @param f Vertice
     * @param p int
     */
    public Aresta (Vertice o, Vertice f, int p){
    tempo=p;
    VerticeOrigem = o;
    VerticeFim = f;
    }

    /**
     * Este método retorna o vertice de origem.
     * @return the VerticeOrigem Vertice
     */
    public Vertice getVerticeOrigem() {
        return VerticeOrigem;
    }

    /**
     * Este método retorna o vertice fim.
     * @return the VerticeFim Vertice
     */
    public Vertice getVerticeFim() {
        return VerticeFim;
    }
    
   
}
