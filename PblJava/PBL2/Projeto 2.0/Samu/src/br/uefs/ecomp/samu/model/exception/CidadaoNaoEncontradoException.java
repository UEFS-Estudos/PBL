
package br.uefs.ecomp.samu.model.exception;

public class CidadaoNaoEncontradoException extends Exception {
    public CidadaoNaoEncontradoException(){
        super();
    }
    
    public CidadaoNaoEncontradoException(String msg){
        super(msg);
    }
    
    public CidadaoNaoEncontradoException(Throwable t){
        super(t);
    }
}
