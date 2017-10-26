package br.uefs.ecomp.samu.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestAtendente {
    
	private Atendente a;
	@Before
	public void setUp() throws Exception {
	
		a=new Atendente("000.000.000-00","Batista","Rua Santo",600);
	
	}

	@Test
	public void testBasic() {
		
		assertSame("000.000.000-00",a.getCpf());
		assertSame("Batista",a.getNome());
		assertSame("Rua Santo",a.getEndereco());
		assertTrue(600 == a.getSalario());
		
		
		
		a.setCpf("640.000.000-10");
		a.setNome("Tim");
		a.setEndereco("Rua Senador");
		a.setSalario(900);
		

		assertSame("640.000.000-10",a.getCpf());
		assertSame("Tim",a.getNome());
		assertSame("Rua Senador",a.getEndereco());
		
		assertTrue( 900== a.getSalario());

		Atendente novo= new Atendente("550.000.000-60","Regina","Rua Geraldo",850);

		assertFalse(novo.equals(a));

		a.setCpf("550.000.000-60");
		a.setNome("Regina");
		a.setEndereco("Rua Geraldo");
		a.setSalario(850);
	//	a.setQtdAtendimentos(58);

		assertTrue(novo.equals(a));
	}

}
