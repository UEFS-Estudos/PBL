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
import br.uefs.ecomp.visWarm.util.ArvoreAVL;
import br.uefs.ecomp.visWarm.util.Iterador;
import br.uefs.ecomp.visWarm.util.ListaEncadeada;

/**
 * Esta classe implementa o comportamento de um computador master. O computador
 * master implementa também os atributos de um computador normal.
 *
 * @author Kayo Costa e Washington Paggoto
 * @see br.uefs.ecomp.visWarm.model.Computador
 */
public class ComputadorMaster extends Computador {

    private static ListaEncadeada computadores = new ListaEncadeada();

    private static ArvoreAVL videos = new ArvoreAVL();

    /**
     * Construtor de ComputadorMaster.
     */
    public ComputadorMaster() {
        super(System.getProperty("user.name"), 0.5);
    }

    /**
     * Este método é responsável por inserir um novo computador na rede.
     *
     * @param computador Computador
     * @throws CadastroRepetidoException
     */
    public static void inserirComputador(Computador computador) throws CadastroRepetidoException {//testad
        for (int i = 0; i < computadores.tamanho(); i++) {
            if (computador.getNome().equals(((Computador) computadores.recupera(i)).getNome())) {
                throw new CadastroRepetidoException();//achou cadastro igual
            }
        }
        computadores.insereFinal(computador);//inserindo na lsita
    }

    /**
     * Este método é responsável por buscar um computador na rede.
     *
     * @param nome String
     * @return Computador || null
     */
    public static Computador buscarComputador(String nome) {
        Computador c;
        for (int i = 0; i < computadores.tamanho(); i++) {
            if (((Computador) computadores.recupera(i)).getNome().equals(nome)) {
                c = (Computador) computadores.recupera(i);
                return c;
            }
        }
        return null;
    }

    /**
     * Este método é responsável por remover um computador da rede.
     *
     * @param nome String
     * @throws PerdaDeDadosException se a remoção de um computador implicar em
     * perca de vídeos do sistema.
     * @throws DataNotFoundException se o computador não existir.
     * @throws CadastroRepetidoException
     */
    public static void removerComputador(String nome) throws PerdaDeDadosException, DataNotFoundException, CadastroRepetidoException {
        Computador c = buscarComputador(nome);
        if (c == null) {
            throw new DataNotFoundException();
        } else {

            try {
                Iterador it = listarVideosEmPc(c);//Alterar os parametros dos metodos para receber computadores...
                while (it.temProximo()) {
                    try {
                        distribuirVideo((Video) it.proximo());
                    } catch (CadastroRepetidoException a) {
                        throw new CadastroRepetidoException();//não entrará nessa exceção
                    }
                }
                computadores.removerMeio(c);
            } catch (CapacidadeMaximaException e) {
                throw new PerdaDeDadosException();
            }

        }
      //  buscarRemovendoNaArvoreVideosDoComputador(nome);
        // InserirNaLista();
        // InserirNaArvore();
        // IfReceberThrowsEspaçoIndisponivelLançaPerdaDeDadosException;
    }//testad

    /**
     * Este método é responsável por distribuir um vídeo entre os computadores.
     *
     * @param video Video
     * @throws CapacidadeMaximaException
     * @throws CadastroRepetidoException
     */
    public static void distribuirVideo(Video video) throws CapacidadeMaximaException, CadastroRepetidoException {
        int i;
        for (i = 0; i < computadores.tamanho(); i++) {
            if (((Computador) computadores.recupera(i)).getCapacidadeAtual() > video.getTamanho()) {
                video.setComputador((Computador) computadores.recupera(i));
                // System.out.println("leua");
                try {
                    videos.add(video);//System.out.println("leu");
                    ((Computador) computadores.recupera(i)).reduzirCapacidade(video.getTamanho());
                } catch (CadastroRepetidoException a) {
                    throw new CadastroRepetidoException();
                }
                break;
            }
        }
        if (computadores.tamanho() == i) {//percorreu a lista de computadores toda e não achou algum com espaço suficiente...
            throw new CapacidadeMaximaException();
        }
    //inserirArvore
        //
    }//testad

    /**
     * Este método é responsável por listar os videos em um dado computador.
     *
     * @param c Computador
     * @return Iterador
     */
    public static Iterador listarVideosEmPc(Computador c) {
        ListaEncadeada videosNoPc = new ListaEncadeada();
        Iterador it = videos.iterator();
        while (it.temProximo()) {
            Video v = ((Video) it.proximo());
            if (v.getComputador().getNome().equals(c.getNome())) {
                videosNoPc.insereFinal(v);
            }
        }
        return videosNoPc.iterador();
    }//testad

    /**
     * Este método é responsável por buscar um vídeo na árvore.
     *
     * @param video Video
     * @return Video
     * @throws DataNotFoundException
     */
    public static Video buscarVideo(Video video) throws DataNotFoundException {
        Video aux = null;
        try {
            aux = (Video) videos.search(video);
        } catch (DataNotFoundException e) {
            System.out.println("Video Não Existe");
        }//     if(aux.getNome().equals(nome)){
        return aux;
    }

    /**
     * Este método remove um vídeo da rede.
     *
     * @param video Video
     * @throws DataNotFoundException
     */
    public static void removerVideo(Video video) throws DataNotFoundException {
        Video v = buscarVideo(video);
        if (v == null) {
            throw new DataNotFoundException();
        }
        Computador aux = v.getComputador();
        for (int i = 0; i < computadores.tamanho(); i++) {
            if (aux.getNome().equals(((Computador) computadores.recupera(i)).getNome())) {
                ((Computador) computadores.recupera(i)).aumentarCapacidade(v.getTamanho());
                break;//para nao continuar o for desnecessariamente
            }
        }
        videos.remove((Comparable) v);

    }//testad

    /**
     * Este método lista todos os computadores da rede.
     *
     * @return Iterador
     */
    public static Iterador listarComputadores() {
        return computadores.iterador();
    }

    /**
     * Este método lista todos os videos da rede.
     *
     * @return Iterador
     */
    public static Iterador listarVideos() {
        return videos.iterator();
    }//testad

}
