/** 
 * Componente Curricular: Módulo Integrado de Programação 2
 * Autor: Kayo Costa de Santana 
 * Data: 22/03/2014
 * Declaro que este código foi elaborado por mim de forma individual e 
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que 
 * uma citação para o não a minha está destacado com autor e a fonte do 
 * código, e estou ciente que estes trechos não serão considerados para fins 
 * de avaliação. Alguns trechos do código podem coincidir com de outros 
 * colegas pois estes foram discutidos em sessões tutorias. 
 * Esta classe foi reutilizada do PBL1.
 */
package br.uefs.ecomp.visWarm.util;


/**
 * Esta classe � respons�vel por implementar os comportamentos de um Iterador. Ela implementa os atributos da classe Iterador
 * @author Kayo Costa de Santana
 */
public class MyIterador implements Iterador {
    
    private Link proximo;
        
    /**
     * M�todo respons�vel por instanciar um novo MyIterador.
     * @param primeiro Link
     */
    public MyIterador(Link primeiro)
    {
        this.proximo = primeiro;
    }
     /**
     * O m�todo � respons�vel por verificar se existe elemento na lista
     * @return boolean
     */
    @Override
    public boolean temProximo() {
        return proximo != null;
    }
    /**
     * O m�todo � respons�vel por remover e retornar o primeiro elemento da lista.
     * @return object Object
     */
    @Override
    public Object proximo() {
        Link aux;
        if(proximo != null){
            aux = proximo;
            proximo = proximo.getProximo();
            return aux.getCelula();
        }
        return null;
    }
}
