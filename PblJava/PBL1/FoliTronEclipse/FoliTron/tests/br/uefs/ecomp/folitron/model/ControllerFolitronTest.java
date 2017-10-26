package br.uefs.ecomp.folitron.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.folitron.facade.ControllerFolitron;
import br.uefs.ecomp.folitron.util.Iterador;

public class ControllerFolitronTest {

	private Bloco b1, b2, b3;	
	private Foliao f1, f2, f3;
	private Transporte t1, t2, t3;
	
	ControllerFolitron cf = new ControllerFolitron();

	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void testCadastrarBloco() {
		assertEquals(0, cf.blocos.tamanho());
		b1 = cf.cadastrarBloco("Dormir é o Melhor Remédio", "Feira de Santana", 01);
		assertEquals(1, cf.blocos.tamanho());
		b2 = cf.cadastrarBloco("A Velha Debaixo da Cama", "Olinda", 02);
		b3 = cf.cadastrarBloco("Os Mascarados", "Aracaju", 03);
		assertEquals(3, cf.blocos.tamanho());
	}
	
	@Test
	public void testCadastrarFoliao() {
		assertEquals(0, cf.folioes.tamanho());
		f1 = cf.cadastrarFoliao("012345678-90", "666666 SSP/BA", "José Roela", 30);  
		assertEquals(1, cf.folioes.tamanho());
		f2 = cf.cadastrarFoliao("000000000-00", "666666 SSP/AC", "Antônio Liso", 20);  
		f3 = cf.cadastrarFoliao("111111111-11", "666666 SSP/PE", "Maria Desespero", 40);  
		assertEquals(3, cf.folioes.tamanho());
	}
		
	@Test
	public void testCadastrarTransporte() {
		b1 = cf.cadastrarBloco("Dormir é o Melhor Remédio", "Feira de Santana", 01);
		b2 = cf.cadastrarBloco("A Velha Debaixo da Cama", "Olinda", 02);
		b3 = cf.cadastrarBloco("Os Mascarados", "Aracaju", 03);
				
		t1 = cf.cadastrarTransporte("Viagens Bahia", "Van", 34.8, 10, 01, "Feira - UEFS", 
									01, "Salvador", 02, "Feira - Rodoviária", b1);
		
		t2 = cf.cadastrarTransporte("Feira Viagens", "Ônibus", 21.5, 40, 02, "Matinha", 
									02, "Salvador", 02, "Baraúnas", b2);
		
		t3 = cf.cadastrarTransporte("Teste", "Carro", 21.5, 40, 01, "XXX", 
									01, "YYY", 01, "ZZZ", b1);
		
		Iterador iterador = cf.listarTransportes(b1);
		assertTrue(iterador.temProximo());
		Transporte proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t1, proximoTransporte);	
		assertTrue(iterador.temProximo());
		proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t3, proximoTransporte);	
		assertFalse(iterador.temProximo());
		
		iterador = cf.listarTransportes(b2);
		assertTrue(iterador.temProximo());
		proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t2, proximoTransporte);		
		assertFalse(iterador.temProximo());
		
		
		f1 = cf.cadastrarFoliao("012345678-90", "666666 SSP/BA", "José Roela", 30);
		f2 = cf.cadastrarFoliao("000000000-00", "666666 SSP/AC", "Antônio Liso", 20);
		f3 = cf.cadastrarFoliao("111111111-11", "666666 SSP/PE", "Maria Desespero", 40);
		
		
		assertTrue(cf.registrarFoliaoEmTransporte(f1, t1));
		assertTrue(cf.registrarFoliaoEmTransporte(f2, t2));		
		assertTrue(cf.registrarFoliaoEmTransporte(f3, t2));
		assertFalse(cf.registrarFoliaoEmTransporte(f3, t2));		
		
		
		iterador = cf.listarFolioes(t2);
		assertTrue(iterador.temProximo());
		Foliao proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f2, proximoFoliao);		
		assertTrue(iterador.temProximo());
		proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f3, proximoFoliao);
		assertFalse(iterador.temProximo());
		
		
		iterador = cf.listarFolioes(t1);
		assertTrue(iterador.temProximo());
		proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f1, proximoFoliao);		
		assertFalse(iterador.temProximo());
				
	}

}
