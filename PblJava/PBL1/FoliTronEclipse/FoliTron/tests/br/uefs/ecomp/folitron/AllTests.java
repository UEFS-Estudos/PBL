package br.uefs.ecomp.folitron;

import br.uefs.ecomp.folitron.model.*;
import br.uefs.ecomp.folitron.util.ListaEncadeadaTest;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListaEncadeadaTest.class,
	BlocoTest.class,
	FoliaoTest.class,
	TransporteTest.class,
	ControllerFolitronTest.class,
})
public class AllTests { }
