package br.uefs.ecomp.samu.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCidadao {

	private Cidadao c;
	@Before
	public void setUp() throws Exception {
	  c= new Cidadao("200.000.000-31","Washington","Rua Ipamerim");
	
	}

	@Test
	public void testBasic() {
		
		assertSame("200.000.000-31",c.getCpf());
		assertSame("Washington",c.getNome());
		assertSame("Rua Ipamerim",c.getEndereco());
		

		c.setCpf("140.000.000-10");
		c.setNome("Pagotto");
		c.setEndereco("Santo Antonio");
		

		assertSame("140.000.000-10",c.getCpf());
		assertSame("Pagotto",c.getNome());
		assertSame("Santo Antonio",c.getEndereco());
		;

		Cidadao novo= new Cidadao("550.000.000-60","Regina","Rua Geraldo");

		assertFalse(novo.equals(c));

		c.setCpf("550.000.000-60");
		c.setNome("Regina");
		c.setEndereco("Rua Geraldo");
		

		assertTrue(novo.equals(c));
	}

}


