/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto
 * Data: 28/06/2014 Declaro que este código foi
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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.visWarm.facade.Facade;
import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import br.uefs.ecomp.visWarm.util.Iterador;

public class TestLeituraTexTo {

    LeituraDeTexto ler;
    ComputadorMaster Texto;
    Facade facade;

    @Before
    public void setUp() throws Exception {
        ler = new LeituraDeTexto();
        Texto = new ComputadorMaster();
        facade = new Facade();
    }

    @Test
    public void test() throws DataNotFoundException, CapacidadeMaximaException, CadastroRepetidoException {
        Computador a = null;
        assertNull(a);
        LeituraDeTexto.arquivoPC("Computadores.txt");
        Iterador it = ComputadorMaster.listarComputadores();
        a = ((Computador) it.proximo());
        assertNotNull(a);

        Video v = null;
        assertNull(v);
        LeituraDeTexto.arquivoVideos("videos.txt");
        Iterador at = ComputadorMaster.listarVideos();
        v = ((Video) at.proximo());
        assertNotNull(v);
    }

    @Test(expected = DataNotFoundException.class)
    public void ArquivoPCeVideoNãoExistente() throws CapacidadeMaximaException, CadastroRepetidoException, DataNotFoundException {
        LeituraDeTexto.arquivoPC("hueuheuehuehr.txt");
        LeituraDeTexto.arquivoVideos("kkkkkk.txt");
    }

    /*
     * Teste a conversão de unidadade.
     */
    @Test
    public void unidadeTest() {
        /*
         * Primeiramente veficamos qual unidade é convertida e de acordo com a tabela é
         * feita a conversão e a verificação, se está correta.
         */
        Object x = ler.unidade('M');
        double y = 1;

        assertTrue(x.equals(y));

        Object z = ler.unidade('G');
        double w = 1000;
        assertTrue(z.equals(w));

        Object p = ler.unidade('T');
        double b = 1000000;
        assertTrue(p.equals(b));

        Object a = ler.unidade('P');
        double c = 1000000000;
        assertTrue(a.equals(c));

        Object j = ler.unidade('B');
        double h = 1 / 1000000;
        assertTrue(j.equals(h));
    }
}
