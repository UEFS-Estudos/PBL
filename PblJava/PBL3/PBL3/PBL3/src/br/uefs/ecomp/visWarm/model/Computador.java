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
package br.uefs.ecomp.visWarm.model;

/**
 * Esta classe implementa o comportamento de um computador.
 *
 * @author Kayo Costa e Washington Paggoto
 */
public class Computador {

    private String nome;
    private final double capacidadeTotal;
    private double capacidadeAtual;

    /**
     * Construtor do computador.
     *
     * @param nome
     * @param capacidade
     */
    public Computador(String nome, double capacidade) {
        this.nome = nome;
        this.capacidadeTotal = capacidade;
        this.capacidadeAtual = capacidade;
    }

    /**
     * Este método retorna a capacidadeTotal de um computador.
     *
     * @return capacidadeTotal double
     */
    public double getCapacidadeTotal() {
        return capacidadeTotal;
    }

    /**
     * Este método retorna o nom de um computador.
     *
     * @return nome String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Este método retorna a capacidade atual de um computador.
     *
     * @return capacidadeAtual double
     */
    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }

    /**
     * Este método reduz a capacidade atual de um computador.
     *
     * @param valor double
     */
    public void reduzirCapacidade(double valor) {
        capacidadeAtual = capacidadeAtual - valor;
    }

    /**
     * Este método aumenta a capacidade atual de um computador.
     *
     * @param valor double
     */
    public void aumentarCapacidade(double valor) {
        capacidadeAtual = capacidadeAtual + valor;
    }

}
