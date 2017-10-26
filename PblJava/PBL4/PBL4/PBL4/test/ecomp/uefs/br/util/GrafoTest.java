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
package ecomp.uefs.br.util;

import ecomp.uefs.br.model.Vertice;
import ecomp.uefs.br.model.Aresta;
import ecomp.uefs.br.util.Grafo;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Washington
 */
public class GrafoTest {
    
    private Grafo grafo;
    private Vertice Q1, Q2,Q3,Q4;
    private Aresta  w,x,c,v;
    private LinkedList arestas;
    private LinkedList vertices;
    
    @Before
    public void setUp() throws Exception{
        
        Q1= new Vertice("Q1");
        Q2= new Vertice("Q2");
        Q3= new Vertice("Q3");
        Q4= new Vertice("Q4");
        
        w= new Aresta(Q1,Q2,20);
        x= new Aresta(Q1,Q3,15);
        v= new Aresta(Q3, Q4, 10);
        c= new Aresta(Q3,Q2, 7);
        
       vertices= new LinkedList ();
       arestas= new LinkedList();
       
        vertices.add(Q1);
        vertices.add(Q2);
        vertices.add(Q3);
        vertices.add(Q4);
        
        
        arestas.add(w);
        arestas.add(x);
        arestas.add(v);
        arestas.add(c);
       // grafo.
        
        grafo= new Grafo(4,arestas,vertices);
       
    }
    @Test
    public void testBasic() {
        
       
      
       LinkedList aux=grafo.caminhoDistancia(Q4, Q2);
       
       
       assertTrue(aux.get(0)== Q4);
       assertTrue(aux.get(1)==Q3);
       assertTrue(aux.get(2) == Q2);
       
       assertTrue(aux.size() == 3);
       
       
      LinkedList h= grafo.calcularMenorNumeroNos(Q1, Q4);
      
      assertTrue(h.get(0) == Q1);
      assertTrue(h.get(1)== Q3);
      assertTrue(h.get(2)== Q4); 
      
      assertTrue(h.size() == 3);
      
      
      
      int m= grafo.distancia(Q2,Q4);
      
      assertEquals(m,17);
      
      
                      
      
   
       
    }
    
}
