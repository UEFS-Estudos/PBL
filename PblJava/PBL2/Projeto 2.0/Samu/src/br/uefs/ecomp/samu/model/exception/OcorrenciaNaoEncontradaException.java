package br.uefs.ecomp.samu.model.exception;

public class OcorrenciaNaoEncontradaException extends Exception {
    
    public OcorrenciaNaoEncontradaException(){
        super();
    }
    
    public OcorrenciaNaoEncontradaException(String msg){
        super(msg);
    }
    
    public OcorrenciaNaoEncontradaException(Throwable t){
        super(t);
    }
    
}
