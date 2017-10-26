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

/**
 * Essa classe implementa o comportamento de funcionário.
 * @author Kayo e Washington
 */
public class Funcionario {
    String nome;

    /**
     * Este método altera o nome do funcionário.
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    /**
     *  construtor da classe
     * @param nome String
     */
    public Funcionario (String nome){
    this.nome=nome;

    }

      /**
       * Esse método retorna o nome do funcionário
       * @return nome String
       */
      public String getNome(){
      return this.nome;
      }

}
