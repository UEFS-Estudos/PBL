/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Paggoto Data: 23/07/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias..
 */
package ecomp.uefs.br.model;

import ecomp.uefs.br.model.Vertice;
import ecomp.uefs.br.model.Aresta;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Washington e kayo
 */
public class ArestaTest {
    
    private Aresta z,x,c,v;
    private Vertice Q1,Q2,Q3,Q4;
   
    
    @Before
    public void setUp()throws Exception {
        Q1= new Vertice("Q1");
        Q2= new Vertice("Q2");
        Q3= new Vertice("Q3");
        Q4= new Vertice("Q4");
        
        z= new Aresta(Q1,Q2,20);
        x= new Aresta(Q1,Q3,15);
        v= new Aresta(Q3, Q4, 10);
        c= new Aresta(Q3,Q2, 7);
    }

    @Test
    public void testBasic() {
        
        assertSame(20, z.getTempo());
        assertSame(15,x.getTempo());
        assertSame(10, v.getTempo());
        assertSame(7,c.getTempo());
        
        assertTrue(Q1 == z.getVerticeOrigem());
        assertTrue(Q2 == z.getVerticeFim());
        assertTrue(Q1== x.getVerticeOrigem());
        assertTrue(Q3 == x.getVerticeFim());
        
        assertTrue(Q3 == v.getVerticeOrigem());
        assertTrue(Q4 == v.getVerticeFim());
        assertTrue(Q3== c.getVerticeOrigem());
        assertTrue(Q2== c.getVerticeFim());
        
        assertFalse(Q2 == z.getVerticeOrigem());
        assertFalse(Q3 == x.getVerticeOrigem());
    }

    
}
