package br.uefs.ecomp.samu.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestAmbulancia {
    
	private Ambulancia am;
	@Before
	public void setUp() throws Exception {
	
	am=new Ambulancia("JDK-1215");
	}

	@Test
	public void testBasic() {
		assertSame("JDK-1215",am.getPlaca());
		
		am.setPlaca("NMX-1011");
		
		assertSame("NMX-1011", am.getPlaca());
		
		Ambulancia novo=new Ambulancia("WPB-1141");
		
		assertFalse(novo.equals(am));
		
		am.setPlaca("WPB-1141");
		
		assertTrue(novo.equals(am));
	}

}
