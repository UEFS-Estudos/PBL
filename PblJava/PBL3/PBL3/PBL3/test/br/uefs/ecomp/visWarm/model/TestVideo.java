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

public class TestVideo {

    private Video v;
    private Computador c;

    @Before
    public void setUp() throws Exception {
        v = new Video("skate", 100);
        c = new Computador("Acer", 350);
    }

    @Test
    public void testVideoBasic() {
        /*
         * Verifica se realmente o objeto criado, corresponde o nome e ao tamanho.
         * Sendo assim, alteramos o local a onde est� o video para o novo computador e verificamos
         * se foi para ele.
         */
        assertSame("skate", v.getNome());
        assertTrue(100 == v.getTamanho());

        v.setComputador(c);
        assertSame(c, v.getComputador());

        Computador novo = new Computador("Acer2", 400);

        assertFalse(novo.equals(c));

    }

}
