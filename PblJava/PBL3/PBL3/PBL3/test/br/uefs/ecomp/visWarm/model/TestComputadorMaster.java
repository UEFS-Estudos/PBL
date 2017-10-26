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

import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import br.uefs.ecomp.visWarm.model.exception.PerdaDeDadosException;

public class TestComputadorMaster {

    private Computador IBM, ACER, CEE;
    private Video Casa;
    private ComputadorMaster PC;

    @Before
    public void setUp() throws Exception {
        IBM = new Computador("IBM", 400);
        ACER = new Computador("ACER", 500);
        CEE = new Computador("CEE", 600);
        PC = new ComputadorMaster();
        Casa = new Video("EU", 1700);

    }

    /*
     *testando o método inserirComputador.
     */
    @Test
    public void testInserirComputador() throws CadastroRepetidoException {
        /*
         * Primeiro criamos o Objeto que será inserido, e apó s buscamos o mesmo 
         * para verificar se foi realmente inserido. E também  é feita a verificão
         * se o tamanho e nome corresponde ao Objecto inserido.
         */

        Computador c = new Computador("EU", 300);

        PC.inserirComputador(c);
        Object x = PC.buscarComputador("EU");
        assertTrue(x.equals(c));
        assertEquals("EU", c.getNome());
        assertTrue(300 == c.getCapacidadeTotal());

    }
    /*
     * testando a exceção se foi inserido duas vezes o mesmo.
     */

    @Test(expected = CadastroRepetidoException.class)
    public void testInserirComputadorCadastroRepetido() throws CadastroRepetidoException {
        Computador a = new Computador("IBM", 400);
        PC.inserirComputador(IBM);
        PC.inserirComputador(a);
    }

    /*
     * Testando a busca de computadores.
     */
    @Test
    public void testBuscarComputador() throws CadastroRepetidoException {
        /*
         * Primeiramente inserimos, elementos e depois fazemos a busca. Logo ap�s ser 
         * feita verificamos se est� correta.
         */
        PC.inserirComputador(ACER);
        Object y = PC.buscarComputador("ACER");
        assertTrue(y.equals(ACER));

        PC.inserirComputador(CEE);
        Object z = PC.buscarComputador("CEE");
        assertTrue(z.equals(CEE));
    }
    /*
     * Testando remover computador.
     */

    @Test
    public void TestRemoverComputador() throws CadastroRepetidoException, PerdaDeDadosException, DataNotFoundException {
        /*� inserido o computador e assim verificando se foi realmente feito.
         * logo ap�s removemos o mesmo e � feita a verifica��o.
         */
        Computador PCC = new Computador("PCC", 600);
        PC.inserirComputador(PCC);
        Object x = PC.buscarComputador("PCC");
        assertTrue(x.equals(PCC));

        PC.removerComputador("PCC");
        Object z = PC.buscarComputador("PCC");
        Object a = PCC;
        assertFalse(a.equals(z));

    }

    /*
     *  Testando quando deseja remover o computador mas ele n�o encontrado.Sendo assim
     *  ele lan�a exce��o
     */
    @Test(expected = DataNotFoundException.class)
    public void testRemoverComputadorDataNotFoundException() throws PerdaDeDadosException, DataNotFoundException, CadastroRepetidoException {
        PC.removerComputador("Naruto");

    }
    /*
     * Testando quando deseja remover um computador, mas n�o tem como distribuir os videos que
     * est�o no mesmo. E assim � lan�ada exce��o
     */

    @Test(expected = PerdaDeDadosException.class)
    public void testRemoverComputadorPerdaDeDados() throws PerdaDeDadosException, DataNotFoundException, CadastroRepetidoException, CapacidadeMaximaException {
        Video Brasil = new Video("Batista", 999);
        Computador EUA = new Computador("NASA", 1000);
        PC.inserirComputador(EUA);
        PC.distribuirVideo(Brasil);
        PC.removerComputador("NASA");

    }
    /*
     * testando se est� distribuindo os videos nos computadores.
     */

    @Test
    public void testDistribuirVideo() throws CapacidadeMaximaException, CadastroRepetidoException {
        Computador PC1 = new Computador("TIM", 600);
        Computador PC2 = new Computador("Monte", 2000);
        PC.inserirComputador(PC1);
        PC.inserirComputador(PC2);
        PC.distribuirVideo(Casa);

    }

    /*
     * Quando n�o � possivel distribuir os videos por falta, de capacidade dos computadores
     * que est�o inseridos.
     */
    @Test(expected = CapacidadeMaximaException.class)
    public void testDistribuirVideoCapacidadeMaximaException() throws CapacidadeMaximaException, CadastroRepetidoException {
        Video novo = new Video("SEMANA", 1000);
        PC.distribuirVideo(novo);

    }


    /*
     * Distribuindo video, mas o video est� repetindo.
     */
    @Test(expected = CadastroRepetidoException.class)
    public void testDistribuirVideoCadastroRepetidoExceptionParaVideo() throws CapacidadeMaximaException, CadastroRepetidoException {
        Video was = new Video("One Piace", 100);//objetos iguais para serem inseridos
        Video meu = new Video("One Piace", 100);
        PC.distribuirVideo(was);
        PC.distribuirVideo(meu);

    }

    /*
     * Testando se est� removendo videos.
     */
    @Test
    public void removerVideoTest() throws CadastroRepetidoException, CapacidadeMaximaException, DataNotFoundException {
        /*
         * � distribuido o video, e faz a verifca��o se o video foi realmente distribuido.
         * Logo ap�s � feita  a remo��o e feita a verifica��o
         */
        Computador nacional = new Computador("nacional", 500);
        Video v = new Video("Casa", 400);
        PC.inserirComputador(nacional);
        PC.distribuirVideo(v);

        Object a = PC.buscarVideo(v);
        assertTrue(a.equals(v));

        PC.removerVideo(v);
        Object n = PC.buscarVideo(v);
        Object b = Casa;
        assertFalse(b.equals(n));
    }

}
