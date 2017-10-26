package br.uefs.ecomp.visWarm.util;

import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;

public interface IBinaryTree {

    public Object search(Comparable item) throws DataNotFoundException;

    public void add(Comparable item)throws CadastroRepetidoException;

    public void remove(Comparable item) throws DataNotFoundException;

}
