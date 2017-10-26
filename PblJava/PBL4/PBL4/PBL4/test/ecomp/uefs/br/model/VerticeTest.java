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

import ecomp.uefs.br.model.Funcionario;
import ecomp.uefs.br.model.Vertice;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Washington e kayo
 */
public class VerticeTest {
    
    private Vertice a,b,c;
    private Funcionario y,x;
    

  
    @Before
    public void setUp() throws Exception{
        a=new Vertice("Q1");
        b=new Vertice("Q2");
        c= new Vertice("Q3");
        
        y=new Funcionario("Tim");
        x= new Funcionario("Joao");
    }

    @Test
    public void testBasic() {
        
        assertSame("Q1",a.getNome());
        assertSame("Q2",b.getNome());
        assertSame("Q3",c.getNome());
        
        c.setFuncionario(y);
        b.setFuncionario(x);
        
        assertTrue(y == c.getFuncionario() );
        
        assertTrue(x ==  b.getFuncionario());
        
        assertTrue( null ==a.getFuncionario());
        
        assertTrue(c.temFuncionario());
        assertTrue(b.temFuncionario());
        assertFalse(a.temFuncionario());
        
        Vertice eu= new Vertice("Q1");
        
        assertTrue(a.equals(eu));
        assertFalse(b.equals(eu));
        assertFalse(c.equals(eu));
        
        c.removerFuncionario();
        b.removerFuncionario();
        
        assertTrue(null == c.getFuncionario());
        assertTrue(null == c.getFuncionario());
        
        Vertice t= new Vertice("Q");
        // será maior então vai retorna 1
        
        
        assertTrue(1 == c.compareTo(t));
        
    }

    
}
