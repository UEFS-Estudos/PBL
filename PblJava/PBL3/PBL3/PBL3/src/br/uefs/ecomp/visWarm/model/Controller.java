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

import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import br.uefs.ecomp.visWarm.model.exception.PerdaDeDadosException;
import br.uefs.ecomp.visWarm.util.Iterador;

/**
 * Esta classe realiza algumas operações necessárias para o funcionamento do
 * sistema.
 *
 * @author Kayo Costa e Washington Paggoto
 *
 */
public class Controller {

    /**
     * Este método cadastra um novo computador que será inserido na rede.
     *
     * @param nome
     * @param capacidade
     * @throws CadastroRepetidoException
     */
    public void cadastrarComputador(String nome, double capacidade) throws CadastroRepetidoException {
        Computador c = new Computador(nome, capacidade);
        try {
            ComputadorMaster.inserirComputador(c);
        } catch (CadastroRepetidoException a) {
            throw new CadastroRepetidoException();
        }
    }

    /**
     * Este método cadastra um novo video que será inserido em um computador da
     * rede.
     *
     * @param nome
     * @param tamanho
     * @throws CapacidadeMaximaException
     * @throws CadastroRepetidoException
     */
    public void cadastrarVideo(String nome, double tamanho) throws CapacidadeMaximaException, CadastroRepetidoException {
        Video v = new Video(nome, tamanho);
        try {
            ComputadorMaster.distribuirVideo(v);
        } catch (CapacidadeMaximaException e) {
            throw new CapacidadeMaximaException();
        } catch (CadastroRepetidoException a) {
            throw new CadastroRepetidoException();
        }
    }

    /**
     * Este método cadastra computador através da leitura de um arquivo de
     * texto.
     *
     * @param nome String
     * @throws DataNotFoundException
     * @throws CadastroRepetidoException
     */
    public void cadastrarComputadorViaTxt(String nome) throws DataNotFoundException, CadastroRepetidoException {
        try {
            LeituraDeTexto.arquivoPC(nome);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException();
        }
    }

    /**
     * Este método cadastra um novo vídeo através da leitura de um arquivo de
     * texto.
     *
     * @param nome String
     * @throws DataNotFoundException
     * @throws CapacidadeMaximaException
     * @throws CadastroRepetidoException
     */
    public void cadastrarVideoViaTxt(String nome) throws DataNotFoundException, CapacidadeMaximaException, CadastroRepetidoException {
        try {
            LeituraDeTexto.arquivoVideos(nome);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException();
        } catch (CapacidadeMaximaException e) {
            throw new CapacidadeMaximaException();
        } catch (CadastroRepetidoException a) {
            throw new CadastroRepetidoException();
        }
    }

    /**
     * Este método retorna todos os computadores cadastrados.
     *
     * @return Iterador
     */
    public Iterador listarComputadores() {
        return ComputadorMaster.listarComputadores();
    }

    /**
     * Este métodos retorna todos os videos de um computador
     *
     * @param nome String
     * @return Iterador
     * @throws DataNotFoundException
     */
    public Iterador listarVideosEmPc(String nome) throws DataNotFoundException {
        Computador aux = ComputadorMaster.buscarComputador(nome);//recebe o computador
        return ComputadorMaster.listarVideosEmPc(aux);
    }

    /**
     * Este método busca um vídeo no sistema
     *
     * @param nome
     * @return Video
     * @throws DataNotFoundException
     */
    public Video buscarVideo(String nome) throws DataNotFoundException {
        Video aux = new Video(nome, 0);//criando um video auxiliar para fazer a busca ná arvore, pois o compareTo recebe um video 
        try {
            return ComputadorMaster.buscarVideo(aux);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException();
        }
    }

    /**
     * Este método é responsável por excluir um computador da rede.
     *
     * @param nome String
     * @throws PerdaDeDadosException
     * @throws DataNotFoundException
     * @throws CadastroRepetidoException
     */
    public void excluirComputador(String nome) throws PerdaDeDadosException, DataNotFoundException, CadastroRepetidoException {
        try {
            ComputadorMaster.removerComputador(nome);
        } catch (PerdaDeDadosException e) {
            throw new PerdaDeDadosException();
        } catch (DataNotFoundException a) {
            throw new DataNotFoundException();
        }
    }

    /**
     * Este método é responsável por excluir um video da rede.
     *
     * @param nome String
     * @throws DataNotFoundException
     */
    public void excluirVideo(String nome) throws DataNotFoundException {
        try {
            Video aux = new Video(nome, 0);
            ComputadorMaster.removerVideo(aux);
        } catch (DataNotFoundException a) {
            throw new DataNotFoundException();
        }
    }

}
