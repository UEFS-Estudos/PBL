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
package br.uefs.ecomp.visWarm.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.visWarm.model.Video;
import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;

public class TestArvoreAVL {

    private ArvoreAVL a;

    @Before
    public void setUp() throws Exception {
        a = new ArvoreAVL();
    }

    /*
     * Testando o m�todo add, que adiciona o elemento na �rvore.
     */
    @Test
    public void testADD() throws CadastroRepetidoException, DataNotFoundException {

        /*
         * Primeiro usamos o add, pra inserir o elemento. Como o primeiro a ser inserido
         * � sempre raiz, � feita uma verifica��o se � a raiz. Sendo assim toda inser��o � feito 
         * uma busca pra ver se o item foi realmente inserido.
         */
        a.add(50);
        Object x = a.getRaiz().getObjeto();
        assertTrue(x.equals(50));

        a.add(30);
        Object b = a.search(30);
        assertTrue(b.equals(30));

        a.add(70);
        Object c = a.search(70);
        assertTrue(c.equals(70));

        a.add(60);
        Object d = a.search(60);
        assertTrue(d.equals(60));

    }
    /*
     * Teste de inser��o de elemento repetido.
     */

    @Test(expected = CadastroRepetidoException.class)
    public void testADDCadastroRepetido() throws CadastroRepetidoException {
        a.add(90);//� cadastrado duas vezes o mesmo para que assim ele lan�ar a exce��o.
        a.add(90);

    }
    /*
     * Teste de buscar, que o elemento n�o foi encontrado dentro da �rvore.
     */

    @Test(expected = DataNotFoundException.class)
    public void testBuscarNaoEncontrada() throws DataNotFoundException {
        a.search(120);//sendo assim o elemento n�o existe, ele lan�a uma exce��o.
    }

    /*
     * Teste de buscar, do elemento que deseja na �rvore.
     */
    public void testBuscar() throws CadastroRepetidoException, DataNotFoundException {
        /*
         * Primeiro adicionamos o elemento, para depois fazer a verifica��o se o elemento foi
         * realmente encontrado
         */
        a.add(90);
        Object u = a.search(90);
        assertTrue(u.equals(90));

        Object c = a.getRaiz().getObjeto();
        assertTrue(c.equals(90));

        a.add(18);
        Object y = a.search(18);
        assertTrue(y.equals(18));

        a.add(30);
        Object b = a.search(30);
        assertTrue(b.equals(30));

        Object m = a.getRaiz().getObjeto();//verificando o balanceamento est� correto.
        assertTrue(c.equals(30));

        Object h = a.search(85);
        assertFalse(h.equals(85));

    }
    /*
     * Esse Teste verifica �rvore foi balanceada.
     */

    @Test
    public void testBalanceamento() throws CadastroRepetidoException, DataNotFoundException {
        /*
         * Primeiro inserimos o elemento e verficando se ele � a raiz, pois � a primeira inser��o.
         * Sendo adicionamos mais dois elementos 50 e 60. A �rvore dever� ser rotacionada e assim
         * a raiz ser� 50.
         */

        a.add(40);
        Object k = a.search(40);
        assertTrue(k.equals(40));
        Object c = a.getRaiz().getObjeto();
        assertTrue(c.equals(40));

        a.add(50);
        Object i = a.search(50);
        assertTrue(i.equals(50));

        a.add(60);
        Object e = a.search(60);
        assertTrue(e.equals(60));
        Object d = a.getRaiz().getObjeto();
        assertFalse(d.equals(40));
        assertTrue(d.equals(50));
    }
    /*
     * Testand o remover elemento da árvore.
     */

    @Test
    public void testRemover() throws CadastroRepetidoException, DataNotFoundException {
        /*
         * Primeiramente inserimos os elementos 60,70 e 80.Ao termino da inserção a raiz será 70,
         * sendo assim ela ser� removida e a nova raiz será 60.Com isso verificamos se a raiz realmente 
         * � 60. E assim obtemos sucesso pois o elemento 70 foi removido 
         */

        a.add(60);
        Object k = a.search(60);
        assertTrue(k.equals(60));
        Object c = a.getRaiz().getObjeto();
        assertTrue(c.equals(60));

        a.add(70);
        Object b = a.search(70);
        assertTrue(b.equals(70));

        a.add(80);
        Object u = a.search(80);
        assertTrue(u.equals(80));
        Object t = a.getRaiz().getObjeto();
        assertTrue(t.equals(70));

        a.remove(70);

        Object x = a.getRaiz().getObjeto();
        assertTrue(x.equals(60));

    }

}
