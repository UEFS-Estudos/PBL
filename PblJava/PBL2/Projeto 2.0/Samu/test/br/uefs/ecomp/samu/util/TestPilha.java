package br.uefs.ecomp.samu.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPilha {

	private Pilha p;
	private Object P1,P2;
	@Before
	public void setUp() throws Exception {
	p=new Pilha();
	P1=new String("Tim");
	P2=new String("Batista");
	
	}

	@Test
	public void testEstaVazia() {
		
		assertTrue(p.estaVazia());
	}
	
	@Test
	public void testTamanho(){
		p.insereTopo(P1);
		
		assertFalse(p.estaVazia());
		assertEquals(1,p.tamanho());
		
		p.insereTopo(P2);
		
		assertEquals(2,p.tamanho());
		
		p.removeTopo();
		
		assertEquals(1,p.tamanho());
		
		p.removeTopo();
		
		assertEquals(0,p.tamanho());
		assertTrue(p.estaVazia());
		
	}
	@Test
	public void testRemoveTopo(){
		
		p.insereTopo(P1);
		p.insereTopo(P2);
		
		assertFalse(p.estaVazia());
		assertEquals(2, p.tamanho());
		
		Object x= p.removeTopo();
		assertTrue(x.equals("Batista"));
		assertEquals(1,p.tamanho());
		
		p.removeTopo();
		
		assertTrue(p.estaVazia());
	}
	

	@Test
	public void testInsereTopo(){
		
		
		p.insereTopo(P1);
		assertEquals("Tim",P1);
		assertFalse(p.estaVazia());
		
		p.insereTopo(P2);
		assertFalse(p.estaVazia());
		
		p.removeTopo();
		assertFalse(p.estaVazia());
		assertEquals(1,p.tamanho());
		
		p.removeTopo();
		assertTrue(p.estaVazia());
		
	}
	
	@Test
	public void testRecuperaTopo(){
		
	
		p.insereTopo(P1);
		p.insereTopo(P2);
		assertEquals(P2,p.recuperaTopo());
		
		p.removeTopo();
		
		assertEquals(P1,p.recuperaTopo());
		
		
		
	}
}
