/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto Data: 14/06/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias. Esta classe foi
 * reutilizada do PBL1.
 */
package br.uefs.ecomp.visWarm.facade;

import br.uefs.ecomp.visWarm.model.Controller;
import br.uefs.ecomp.visWarm.model.Video;
import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import br.uefs.ecomp.visWarm.model.exception.PerdaDeDadosException;
import br.uefs.ecomp.visWarm.util.Iterador;

public class Facade {

    Controller controller = new Controller();

    public void cadastrarComputador(String nome, double capacidade) throws CadastroRepetidoException {
        controller.cadastrarComputador(nome, capacidade);
    }

    public void cadastrarVideo(String nome, double tamanho) throws CapacidadeMaximaException, CadastroRepetidoException {
        controller.cadastrarVideo(nome, tamanho);
    }

    public void cadastrarComputadorViaTxt(String nome) throws DataNotFoundException, CadastroRepetidoException {
        controller.cadastrarComputadorViaTxt(nome);
    }

    public void cadastrarVideoViaTxt(String nome) throws DataNotFoundException, CapacidadeMaximaException, CadastroRepetidoException {
        controller.cadastrarVideoViaTxt(nome);
    }

    public Iterador listarComputadores() {
        return controller.listarComputadores();
    }

    public Iterador listarVideosEmPc(String nome) throws DataNotFoundException {
        return controller.listarVideosEmPc(nome);
    }

    public Video buscarVideo(String nome) throws DataNotFoundException {
        return controller.buscarVideo(nome);
    }

    public void excluirComputador(String nome) throws PerdaDeDadosException, DataNotFoundException, CadastroRepetidoException {
        controller.excluirComputador(nome);
    }

    public void excluirVideo(String nome) throws DataNotFoundException {
        controller.excluirVideo(nome);
    }
}
