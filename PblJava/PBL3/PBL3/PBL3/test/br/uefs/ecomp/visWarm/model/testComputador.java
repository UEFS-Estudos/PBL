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

public class testComputador {

    private Computador c;

    @Before
    public void setUp() throws Exception {
        c = new Computador("Man", 100.0);
    }

    /*
     * Testa  os metodos da classe Computador
     */
    @Test
    public void testBasic() {
        /*
         * Primeiramente verificamos se Objeto criado, realmente apresenta nome e  tamanho que 
         * deseja.Proximo teste reduzimos a capacidade do Computador. Entretando tem duas 
         * capacidades uma a do proprio computador e a atual.
		
         */
        assertSame("Man", c.getNome());
        assertTrue(100 == c.getCapacidadeAtual());
        assertTrue(100 == c.getCapacidadeTotal());

        c.reduzirCapacidade(80);

        assertTrue(20 == c.getCapacidadeAtual());
        assertTrue(100 == c.getCapacidadeTotal());

        c.aumentarCapacidade(70);

        assertTrue(90 == c.getCapacidadeAtual());
        assertTrue(100 == c.getCapacidadeTotal());

        Computador novo = new Computador("IBM2", 150);
        assertFalse(novo.equals(c));

    }
}
