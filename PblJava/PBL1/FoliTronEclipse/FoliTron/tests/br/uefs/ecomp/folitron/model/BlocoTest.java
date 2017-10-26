package br.uefs.ecomp.folitron.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Bloco}
 */
public class BlocoTest {

	private Bloco b;	
	
	/**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	b = new Bloco("Spanta Bebê", "Salvador - Farol da Barra", 10);
    }

    /**
     * Teste de unidade que verifica se os atributos de um bloco são atribuidos e 
     * modificados corretamente. Além disso, ele checa se o método equals que 
     * compara dois blocos foi implementado corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Spanta Bebê", b.getNome());
        assertEquals("Salvador - Farol da Barra", b.getLocal());
        assertEquals(10, b.getSaida());
        
        b.setNome("Dormir é o Melhor Remédio");
        b.setLocal("Feira de Santana");        
        b.setSaida(15);
        assertEquals("Dormir é o Melhor Remédio", b.getNome());
        assertEquals("Feira de Santana", b.getLocal());
        assertEquals(15, b.getSaida());
        
        Bloco temp = new Bloco("Dormir é o Melhor Remédio", "Feira de Santana", 15);
        assertTrue(temp.equals(b));
        
        b.setNome("XYZ");        
        assertFalse(temp.equals(b));
        
        b.setLocal("Recife - Marco Zero");
        b.setNome("Dormir é o Melhor Remédio");        
        assertFalse(temp.equals(b));
        
        b.setSaida(20);  
        b.setLocal("Feira de Santana");              
        assertFalse(temp.equals(b));
    }
    
}
