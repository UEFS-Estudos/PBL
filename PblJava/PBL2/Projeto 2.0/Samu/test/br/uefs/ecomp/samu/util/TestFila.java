package br.uefs.ecomp.samu.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFila {
  
	
	private Fila f;
	private Object F1,F2;
	
	
	@Before
	public void setUp() throws Exception {
	f=new Fila();
	F1= new String("Joao");
	F2= new String("Washington");
	
	}

	@Test
	public void testEstaVazia() {
		assertTrue(f.estaVazia());
		
	}

	@Test
	public void testTamanho(){
		assertEquals(0,f.tamanho());
		f.insereFinal(F1);
		assertEquals(1,f.tamanho());
		
		f.insereFinal(F2);
		assertEquals(2,f.tamanho());
		
		f.removeInicio();
		assertEquals(1,f.tamanho());
		
		f.removeInicio();
		assertEquals(0,f.tamanho());
	}
	
	@Test
	public void testInsereFinal(){
		
		f.insereFinal(F2);
		assertFalse(f.estaVazia());
		assertEquals("Washington",F2);
		
		assertSame(F2,f.removeInicio());
		assertTrue(f.estaVazia());
		
		f.insereFinal(F1);
		f.insereFinal(F2);
		
		assertEquals("Joao",F1);
		assertEquals("Washington",F2);
		
		assertFalse(f.estaVazia());
		
		Object x =f.removeInicio();
		
		assertTrue(x.equals("Joao"));
		assertFalse(f.estaVazia());
		
		
	}
	
	@Test
	public void testRemoveInicio(){
	
		f.insereFinal(F2);
		assertFalse(f.estaVazia());
		
		assertEquals("Washington",F2);
		
		f.removeInicio();
		assertTrue(f.estaVazia());
		
		f.insereFinal(F1);
		f.insereFinal(F2);
		
		Object x=f.removeInicio();
		assertTrue(x.equals("Joao"));		
		assertEquals(1, f.tamanho());
		assertFalse(f.estaVazia());
	}
	@Test
	
	public void testRecuperaInicio(){
		
		f.insereFinal(F1);
		f.insereFinal(F2);
		
		assertEquals(F1,f.recuperaInicio());
		f.recuperaInicio();
		f.removeInicio();
		assertEquals(F2,f.recuperaInicio());
		
		
		assertFalse(f.estaVazia());
		
		f.removeInicio();
		assertTrue(f.estaVazia());
	}
}
