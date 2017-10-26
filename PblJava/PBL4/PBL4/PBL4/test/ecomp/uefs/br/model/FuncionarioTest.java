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

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Washington e kayo
 */
public class FuncionarioTest {
    
   private Funcionario a,b;

       
    @Before
    public void setUp()throws Exception {
        a= new Funcionario("Joao");
        b= new Funcionario("Washington");
    }

    @Test
    public void testBasic() {
        
        assertSame("Joao" ,a.getNome());
        assertSame("Washington",b.getNome());
        a.setNome("Tim");
        
        assertSame("Tim",a.getNome());
       
        assertFalse("tim" ==a.getNome());
        assertFalse("timy"== b.getNome());
    }
}
