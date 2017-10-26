package br.uefs.ecomp.samu.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestOcorrencia {

	private Ocorrencia o;
	
	@Before
	public void setUp() throws Exception {
		
		o =new Ocorrencia(1,1);
	
	}

	@Test
	public void testBasic() {
		
		assertEquals(1, o.getId());
		
		assertEquals(1, o.getQtdAmbulancias());
		
		o.setId(2);
		
		o.setQtdAmbulancias(2);
		
		assertEquals(2,o.getId());
		
		assertEquals(2, o.getQtdAmbulancias());
		
		Ocorrencia nova= new Ocorrencia(3,4);
		
		assertFalse(nova.equals(o));
		
		o.setId(3);
		
		o.setQtdAmbulancias(4);
		
		
	}

}
