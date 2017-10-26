/** 
 * Componente Curricular: M�dulo Integrado de Programa��o 2
 * Autor: Kayo Costa de Santana 
 * Data: 22/03/2014 
 * Declaro que este c�digo foi elaborado por mim de forma individual e 
 * n�o cont�m nenhum trecho de c�digo de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e p�ginas ou documentos 
 * eletr�nicos da Internet. Qualquer trecho de c�digo de outra autoria que 
 * uma cita��o para o n�o a minha est� destacado com autor e a fonte do 
 * c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins 
 * de avalia��o. Alguns trechos do c�digo podem coincidir com de outros 
 * colegas pois estes foram discutidos em sess�es tutorias. 
 * Esta classe foi reutilizada do PBL 1. Algumas altera��es foram realizadas. 
 */
package br.uefs.ecomp.visWarm.util;

import br.uefs.ecomp.visWarm.model.Video;

/**
 * Esta classe implementa os m�todos de uma estrutura de dados Lista Duplamente Encadeada. Nela s�o implementados os m�todos da classe ILista.
 * @author Kayo Costa de Santana
 * 
 */

public class ListaEncadeada implements ILista{
    

    private int tam;
    private Link primeiro, ultimo;
    
   
    /**
     * O m�todo � respons�vel por saber se a lista est� vazia.
     * @return boolean 
     */
    @Override
    public boolean estaVazia() {
        return (tam == 0);
    }
    /**
     * O m�todo � respons�vel por retornar o tamanho da lista.
     * @return tamanho int
     */
    @Override
    public int tamanho() {
       return tam;
    }    

    /**
     * O m�todo e respons�vel por inserir um elemento no inicio da lista.
     * @param o Object
     */
    @Override
    public void insereInicio(Object o) {
        Link aux = new Link (o);
        
        if(estaVazia())
        {
        primeiro = aux;
        ultimo = aux;
        }
        
        else 
        {
        aux.setProximo(primeiro);
        primeiro.setAnterior(aux);
        primeiro = aux;
        }
        
        tam++;
    }//Insere um objeto no inicio da lista
    
    /**
     * O m�todo � respons�vel por remover um elemento no final da lista.
     * @return Object || null
     */
    @Override
    public Object removeFinal() {
        Link aux;
        if(estaVazia())
        {
         return null;   
        }
        else if(tamanho() == 1)
        {
        aux = primeiro;
        primeiro = null;
        ultimo = null;
        }
        else{
        aux = ultimo;
        ultimo = ultimo.getAnterior();
        ultimo.setProximo(null);
        }
        tam--;
        return aux.getCelula();
    }
    public Link removeMeio(Object o){
        int index=tamanho();
        Link aux=primeiro;
         if(!estaVazia())
        {
            int x;
            for (x=0;x<index;x++)
            {
            if(aux.getCelula().equals(o)){
            return aux;
            }
            aux=aux.getProximo();
            }
            }       
        return null;
    }
    
    public void removerMeio(Object o){
        Link aux=removeMeio(o);
        if(tam==1){
        aux=null;
        primeiro=null;
        ultimo=null;
        tam--;
        }
        else if(aux==primeiro){
        aux=aux.getProximo();
        aux.setAnterior(null);
        primeiro=aux;
        tam--;
        }
        else if(aux==ultimo){
        aux=aux.getAnterior();
        aux.setProximo(null);
        ultimo=aux;
        tam--;
        }
        else{
        aux.getProximo().setAnterior(aux.getAnterior());
        aux.getAnterior().setProximo(aux.getProximo());
        tam--;
    }
    }
    
    /**
     * O m�todo � respons�vel por remover um elemento no in�cio da lista.
     * @return object Object
     */
    @Override
    public Object removeInicio() {
        Link aux;
        if(estaVazia())
        {
         return null;   
        }
        else if(tamanho() == 1)
        {
        aux = primeiro;
        primeiro = null;
        ultimo = null;
        }
        else{
        aux = primeiro;
        primeiro = primeiro.getProximo();
        primeiro.setAnterior(null);
        }
        
        tam--;
        return aux.getCelula();
    }//Remove o primeiro elemento da lista
    
    /**
     * O m�todo � respons�vel por retornar um determinado elemento da lista.
     * @param index int
     * @return Object || null
     */
    @Override
    public Object recupera(int index) {
        if(!estaVazia())
        {
            if (index == 0)
            {
            return primeiro.getCelula();
            }
            
            else
            {
            Link aux = primeiro;
            int x;
            for (x=0;x<index;x++)
            {
            aux=aux.getProximo();
            }
            return aux.getCelula();
            }
        }
        
        return null;
    }// Retorna o elemento "index" da lista...

    
    /**
     * O metodo � respons�vel por percorrer a lista, atrav�s do uso de um Iterador.
     * @return it Iterador
     */
    @Override
    public Iterador iterador() {
        Iterador it = new MyIterador(primeiro);
        return it;
    }    
    /**
     * O m�todo � respons�vel por inserir um elemento no final de uma lista.
     * @param o Object 
     */
    @Override
    public void insereFinal(Object o) {
        if(estaVazia())
        {
          insereInicio(o);
        }
        
        else 
        {
        Link aux = new Link (o);
        aux.setAnterior(ultimo);
        ultimo.setProximo(aux);
        ultimo = aux;
        tam++;
        }
    }// Insere um elemento no final da lista
      public static void main(String[] args) throws Exception {
          String capacidade = new String("150GB");
          char x = capacidade.charAt(capacidade.length() -2);
          String tamanho=capacidade.substring(0, capacidade.length()-2);//faz com que tamanho seja do inicio 0 até o fim-2 ou seja ate antes da U.M
          double y = Double.parseDouble(tamanho);//converte a string em double
          
          
          System.out.println(x);
          System.out.println(tamanho);
          System.out.println(capacidade);
          System.out.println("double "+y);
      }
      
}


