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
package ecomp.uefs.br.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;



/**
 * Esta classe implementa o comportamento de um vertice. A classe vertice implementa
 * a interface do java Comparable e é equivalente a cada cômodo da casa.
 * @author Kayo e Washington
 */
public class Vertice implements Comparable <Vertice> {
   
    /*
    Vertice é um funcionario
    */
    
    private String nome ;
    private Funcionario funcionario=null;
    
    /**
     * Construtor da classe
     * @param nome String
     */
    public Vertice(String nome){
    this.nome = nome;
 
    }

   
    /**
     * Esse método é responsável por retorna o nome.
     * 
     * @return nome String
     */
    public String getNome(){
    return nome;
    }
    
   
    @Override
    public int compareTo(Vertice o) {
        return nome.compareTo(o.getNome());
    }

    /**
     * Esse método é responsável por retorna o objeto funcionário.
     * @return funcionario Funcionario
     */
    public Funcionario getFuncionario(){  
        return funcionario;
       
    }
    
    /**
     * Esse método é responsável por retorna se tem um funcionário.
     * @return boolean
     */
    public boolean temFuncionario(){
        return (funcionario!=null);
    }
    
    /**
     * Esse método altera o funcionario.
     * @param f Funcionario
     */
    public void setFuncionario(Funcionario f){
        if (funcionario==null){
        this.funcionario=f;
        }
    }
    /**
     * Esse método é responsável por remover funcionário 
     */
    public void removerFuncionario(){
    Funcionario aux =funcionario;
    funcionario = null;
   
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
            

}
