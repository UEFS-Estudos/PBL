/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Paggoto Data: 23/07/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias..
 */
package ecomp.uefs.br.controller;

import ecomp.uefs.br.model.exception.DataNotFoundException;
import ecomp.uefs.br.model.exception.LugarOcupadoException;
import ecomp.uefs.br.model.LeituraDeTexto;
import ecomp.uefs.br.model.Funcionario;
import ecomp.uefs.br.model.Vertice;
import ecomp.uefs.br.util.Grafo;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Esta classe realiza algumas operações necessárias para o funcionamento do
 * sistema.
 * @author Washington Pagotto Batista e Kayo Costa
 */
public class Controller {

    private Grafo mansao; 
    private LinkedList funcionarios;
    private LinkedList arestas;
    private LinkedList vertices ;
    
    public Controller(){
        funcionarios = new LinkedList();
        arestas = new LinkedList();
        vertices = new LinkedList();
    }

    /**
     * Este método é responsável por ler o arquivo texto.
     * @param arquivo file 
     */
    public void cadastrarMansao(File arquivo) {
        LeituraDeTexto.cadastrarMansaoTxt(arquivo, vertices, arestas, funcionarios);//lendo os vertices arestas e funcionários pelo arquivo
        mansao = new Grafo(vertices.size(), arestas, vertices);//criando a planta mansão com base no que foi recebido do arquivo
    }

    
    /**
     * Este método é responsável por apresentar o menor caminho por tempo.
     * 
     * @param vertCrise String
     * @return Iterador
     * @throws DataNotFoundException Caso nao encontre o vertice
     */
    public  Iterator caminhoDeMenorTempo(String vertCrise) throws DataNotFoundException{
       
        Vertice verticeCrise = buscarVertice(vertCrise);//buscndo o vertice a partir da string
        if(verticeCrise==null){//se o retorno for null o vertice nao existe
        throw new DataNotFoundException();
        }
        
        else{
        LinkedList aux;
        Vertice verticeDoMenor = null;
        boolean verifica = true;//para não ter que chutar um valor aleatorio para a variavel menor
        int menor = 0;
        for (int i = 0; i < vertices.size(); i++) {//percorre a list ade vertices
            Vertice v = (Vertice) vertices.get(i);
            if (v.temFuncionario()) {//se o vertice tiver funcionario
                if (verifica) {
                    menor = mansao.distancia(v, verticeCrise); //verifica o tamanho do percurso
                    verticeDoMenor = v;//guarda o vertice do percurso
                    verifica = false;//variavel de controle
                } else {
                    int x = mansao.distancia(v, verticeCrise);//verifica o tamanho do percurso do vertice atual para o da crise
                    if (x < menor) {// o valor encontrado for  menor, atualiza as variaveis menor e vertice do menor
                        menor = x;
                        verticeDoMenor = v;
                    }
                }
            }
        }
        
        aux = mansao.caminhoDistancia(verticeDoMenor, verticeCrise);//cria a a lista que representa a rota do menor caminho entre o como da crise e o de funcionario
        aux.add(menor);//adciona o valor do percurso no final da lista
        return aux.iterator();
        }
    }

   
    private Vertice buscarVertice(String vertice) {
        for (int x = 0; x < vertices.size(); x++) {
            if (((Vertice) vertices.get(x)).getNome().equals(vertice)) {
                return ((Vertice) vertices.get(x));
            }
        }
        return null;
    }

    /**
     * Este método é responsável por menor caminho de comodos.
     * @param vertCrise String
     * @return Iterador
     * @throws DataNotFoundException
     */
    public Iterator caminhoMenorNo(String vertCrise) throws DataNotFoundException {
        /*
         * Este método foi feito com o mesmo raciocinio do método caminho de menor tempo, tornando dispensável os comentários repetidos
         */
        Vertice verticeCrise = buscarVertice(vertCrise);
        if(verticeCrise==null){
        throw new DataNotFoundException();
        }
        
        else{
        LinkedList aux = null;
        Vertice verticeDoMenor = null;
        boolean verifica = true;//para não ter que chutar um valor aleatorio para a variavel menor
        int menor = 0;
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = (Vertice) vertices.get(i);
            if (v.temFuncionario()) {
                if (verifica) {
                    aux = mansao.calcularMenorNumeroNos(v, verticeCrise);
                    menor = aux.size();
                    verticeDoMenor = v;
                    verifica = false;
                } else {
                    aux = mansao.calcularMenorNumeroNos(v, verticeCrise);
                    int x = ((int) aux.size());
                    if (x < menor) {
                        menor = x;
                        verticeDoMenor = v;
                    }
                }
            }
        }
        aux = mansao.calcularMenorNumeroNos(verticeDoMenor, verticeCrise);
        return aux.iterator();
        }
    }

    /**
     * Este método é responsável por  remover funcionário de um comodo.
     * @param f String
     */
    public void removerFuncionarioDoComodo(String f) throws DataNotFoundException {
        int index=0;//variavel do for
        for (index = 0; index < vertices.size(); index++) {
            if (((Vertice) (vertices.get(index))).temFuncionario()) {//se o vertice tiver funcionario
                if (((Vertice) (vertices.get(index))).getFuncionario().getNome().equals(f)) {//se esse o nome do funcionario for igual ao da string do parametro
                    Vertice v = ((Vertice) (vertices.get(index)));
                    v.removerFuncionario();//remove funcionario do vertice
                    vertices.set(index, v);//atualiza o vertice na lista
                    break;
                }
            }
        }
        if(index==vertices.size()){//caso acabe o laço e seja encontrado que o index é igual ao numero de vertices significa que o funcionario nao foi encontrado
            throw new DataNotFoundException();
        }   
    }

   
    private boolean verificarDisponibilidadeFuncionario(String f) {
        /*
         * Esse método não possui javadoc pelo fato de não ser vizualisado em outras classes, ele é responsável por verificar se um funcionario esta presente em algum comodo.
         */
        for (int index = 0; index < vertices.size(); index++) {
            if (((Vertice) (vertices.get(index))).temFuncionario()) {
                if (((Vertice) (vertices.get(index))).getFuncionario().getNome().equals(f)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Este método é responsável por  adicionar um funcionário no comodo.
     * @param f String
     * @param vertice String
     * @throws LugarOcupadoException quando o lugar já está ocupado por um funcionário
     * @throws DataNotFoundException quando o funcinário não existe
     */
    public void adcionarFuncionarioEmComodo(String f, String vertice) throws LugarOcupadoException,DataNotFoundException {
        Funcionario func = null;
        int index;
        for (index = 0; index < funcionarios.size(); index++) {
            if (((Funcionario) (funcionarios.get(index))).getNome().equals(f)) {
                func = (Funcionario) funcionarios.get(index);
                break;
            }
        }
        
        if(index==funcionarios.size()){
        throw new DataNotFoundException("Funcionário não existe");
        }
        
        for (index = 0; index < vertices.size(); index++) {
            if (((Vertice) (vertices.get(index))).getNome().equals(vertice)) {//caso o vertice seja igual ao do parametro
                if (!((Vertice) (vertices.get(index))).temFuncionario()) {//caso nao tenha funcionario
                    if (verificarDisponibilidadeFuncionario(f)) {//caso o funcionario não esteja disponivel
                        removerFuncionarioDoComodo(f);//caso o funcionario ja esteja em um comodo ele sera removido
                    }
                    Vertice v = ((Vertice) (vertices.get(index)));
                    v.setFuncionario(func);//faz com que o funcionario seja inserido no comodo
                    vertices.set(index, v); //atualiza a lista
                    break;
                } else {//caso o comodo esteja ocupado não pode ser inserido outro funcionario
                    throw new LugarOcupadoException();
                }
            }

        }
        if(index==vertices.size()){//caso nao exista comodo
        throw new DataNotFoundException("Comodo não existe");
        }

    }

    /**
     * Este método é responsável por listar os comodos.
     * @return Iterador 
     */
    public Iterator listarFuncionarioV(){
            return vertices.iterator();//retorna a lista de vertices, este metodo nao faz parte das user stories, foi feito a mais
    }
   
    
    
}
