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
 * Esta classe implementa o comportamento de um video. A classe vídeo implementa
 * a interface do java Comparable.
 *
 * @author Kayo Costa e Washington Paggoto
 */
public class Video implements Comparable<Video> {

    private String nome;
    private double tamanho;
    private Computador computador = null;

    /**
     * Construtor da classe vídeo
     *
     * @param nome
     * @param tamanho
     */
    public Video(String nome, double tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    /**
     * Este método retorna o nome de um vídeo.
     *
     * @return nome String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Este método retorna o tamanho de um vídeo.
     *
     * @return tamanho double
     */
    public double getTamanho() {
        return tamanho;
    }

    /**
     * Esta método retorna uma referencia para o computador que armazena o
     * video.
     *
     * @return Computador
     */
    public Computador getComputador() {
        return computador;
    }

    /**
     * Este método altera o computador responsável por armazenar o vídeo.
     *
     * @param computador Computador
     */
    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    /**
     * Este método implementa o método da interface comparable.
     *
     * @param video Video
     * @return int
     */
    @Override
    public int compareTo(Video video) {
        return (video.getNome().compareTo(this.nome));
    }

}
