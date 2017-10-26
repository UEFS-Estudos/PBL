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
package ecomp.uefs.br.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import ecomp.uefs.br.model.Aresta;
import ecomp.uefs.br.model.Vertice;

/**
 *Essa classe implementa o comportamento do grafo.
 * @author Washington e Kayo
 * @see br.uefs.ecomp.util
 * 
 */
public class Grafo {

    private int numeroVertices;//atributo responsavel por armazenar a quantidade de vertices do grafo
    private Vertice[] vertices;//responsave por armazenar todos os vertices do grafo
    private LinkedList arestas; // armazena todas as arestas do grafo
    private int matriz[][];//matriz que representa o menor caminho entre os vertices
    private String maatriz[][]; //matriz que indica o caminho percorrido para chegar em um vertice pelo menor caminho

    /**
     * Construtor da classe grafo
     * @param numero int
     * @param Arestas LinkedList
     * @param Vertices LinkedList
     */
    public Grafo(int numero, LinkedList Arestas, LinkedList Vertices) {
        numeroVertices = numero;
        vertices = new Vertice[numero];
        arestas = Arestas;
        matriz = new int[numero][numero];
        maatriz = new String[numero][numero];
        inserirVertices(Vertices);//faz com que a lista de vertices recebida seja transformada em um array
        preenxerMatrizes();//preenxe as matriz com base nos valores recebidos
        calcularMenorDistancia();//calcula a distancia entre todos os vertices... Algoritmo de floyd
    }

    
    private void inserirVertices(LinkedList Vertices) {
        Iterator it = Vertices.iterator();

        int x = 0;
        while (it.hasNext()){
            vertices[x] = ((Vertice) it.next());
            x++;
        }
    }

    
    private void preenxerMatrizes() {
        Arrays.sort(vertices);//ordena o vetor de vertices
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                maatriz[i][j] = vertices[j].getNome();//faz com que mostre por as ligações diretas dos vertices por exemplo A se liga pra B por B
                if (i == j) {//diagonal principal"elemento liga pra ele mesmo"
                    maatriz[i][j] = "-";//nao interessa saber se o elemento liga pra ele mesmo
                }
                matriz[i][j] = 0;//inicializando a outra matriz
            }
        }

        Iterator it = arestas.iterator();
        while (it.hasNext()) {//este laço de repetição preenxe  amatriz de inteiros e de adjacencia de acordo com as arestas do grafo
            Aresta a = (Aresta) it.next();
            int i = 0;
            int j = 0;
            while (!a.getVerticeOrigem().equals(vertices[j])) {//buscando o indice de um vertice
                j++;
            }

            while (!a.getVerticeFim().equals(vertices[i])) {//buscando o indice do outro vertice
                i++;
            }
            maatriz[i][j] = vertices[j].getNome();//faz com que ele receba o nome do vertice de origem
            matriz[i][j] = 1;////faz com que seja alterado para 1 o que significa que há caminho entre as arestas
            matriz[j][i] = 1;//como os vertices se ligam de em ambos os caminho, eles formam uma matriz simÃ©trica
        }

        for (int a = 0; a < numeroVertices; a++) {
            for (int b = 0; b < numeroVertices; b++) {
                if (a != b && matriz[a][b] == 0) {//se for igual a 0 significa que não há caminhos entre os vertices, foi atribuido aleatoriamente o valor 10000 para a posição visto que haverá um caminho não direto entre eles pelo fato do grafo ser conexo.
                    matriz[a][b] = 10000;
                }
            }
        }
        Iterator at = arestas.iterator();
        while (at.hasNext()) {//este laço é responsável por substituir a matriz de inteiros pelos pesos da aresta
            Aresta a = (Aresta) at.next();
            int i = 0;
            int j = 0;
            while (!a.getVerticeOrigem().equals(vertices[i])) {
                i++;
            }
            while (!a.getVerticeFim().equals(vertices[j])) {
                j++;
            }
            matriz[i][j] = a.getTempo();
            matriz[j][i] = a.getTempo();//como a matriz é simétrica....
        }
    }

    
    private void calcularMenorDistancia() {
        //metodo criado com base no algoritmo de Floyd
        int k, i, j;
        int aux;
        int aux2;
        for (k = 0; k < numeroVertices; k++) {
            for (i = 0; i < numeroVertices; i++) {
                for (j = 0; j < numeroVertices; j++) {
                    aux = matriz[i][j];//recebe o elemento atual
                    aux2 = matriz[i][k] + matriz[k][j];

                    if (aux2 < aux) {//se aux 2 for menor que aux a posição da matriz sera substituida por aux 2, isso signifca que existe um caminho menor formado por outras arestas
                        matriz[i][j] = aux2;
                        maatriz[i][j] = maatriz[i][k];//muda na matriz de vertices adjacentes para que seja possível saber qual é a rota entre os menores caminhos
                    }
                    if (aux == 10000 && aux2 < 10000) {//caso seja 10000 e aux 2 seja menor signifca que agora encontrou um caminho entre os 2 vertces, visto que 10000 simbolizava que nao há caminho
                        matriz[i][j] = aux2;
                    }
                }
            }
        }
    }

    /**
     * Esse método apresenta a distancia entre dois vértices do grafo.
     * @param vertice1 Vertice
     * @param vertice2 Vertice
     * @return int
     */
    public int distancia(Vertice vertice1, Vertice vertice2) {
        int k = 0, z = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertice1)) {
                k = i;
            }
            if (vertices[i].equals(vertice2)) {
                z = i;
            }
        }
        return matriz[k][z];
    }

    /**
     * Esse método é responsável por apresentar o caminho da distancia.
     * @param vertice1 Vertice
     * @param vertice2 Vertice
     * @return LinkedList
     */
    public LinkedList caminhoDistancia(Vertice vertice1, Vertice vertice2) {
        LinkedList caminho = new LinkedList();
        while (true) {
            if (vertice1.equals(vertice2)) {//se vertice 1 for igual ao 2 o caminho foi encontrado
                caminho.add(vertice1);//adciona o final da lista
                return caminho;
            } else {
                int k = 0, z = 0;
                for (int i = 0; i < vertices.length; i++) {//verifica  aposição da aresta na lista
                    if (vertices[i].equals(vertice1)) {
                        k = i;
                    }
                    if (vertices[i].equals(vertice2)) {
                        z = i;
                    }
                }
                caminho.add(vertice1);//adciona vertice 1
                for (int i = 0; i < vertices.length; i++) {
                    if (vertices[i].getNome().equals(maatriz[k][z])) {
                        vertice1 = vertices[i];//faz com que vertice 1 seja agora o vertice encontrado na aresta.... 
                        break;
                    }
                }
            }
        }
    }

    /**
     * Esse método é responsável por retornar o caminho com numero de comodos.
     * @param vertice1 Vertice
     * @param vertice2 Vertice
     * @return LinkedList
     */
  public LinkedList calcularMenorNumeroNos(Vertice vertice1, Vertice vertice2){
     int matrix[][]=new int [numeroVertices][numeroVertices];//matriz adjacencia será utilizada para achar a matriz alcançabilidade
     String maatrix[][]=new String[numeroVertices][numeroVertices];//matriz de vertices para encontrar o caminho
       for (int i=0;i<numeroVertices;i++){//inicialização das matrizes
       for (int j=0;j<numeroVertices;j++){ 
          maatrix[i][j]=vertices[j].getNome();
         /* if(i==j)*/ maatrix[i][j]="-";
          matrix[i][j]=0;//inicializando a outra matriz
    }
    }    

     LinkedList aux =new LinkedList();//caminho

      Iterator it = arestas.iterator();
      while(it.hasNext()){//preencexendo com 1 a matriz alcançabilidade onde existir ligação e fazendo com que a matriz de vertices atualize para que seja encontrada a rota
      Aresta a = (Aresta)it.next();
      int i=0;    
      int j=0;
      while(!a.getVerticeOrigem().equals(vertices[i])){
      i++;
      }        
      while(!a.getVerticeFim().equals(vertices[j])){
      j++;
      }
      maatrix[i][j]=vertices[j].getNome();
      matrix[i][j]=1;
      matrix[j][i]=1;//como os vertices se ligam de em ambos os caminho, eles formam uma matriz simétrica
      
    }

      
      int i=0,j=0;
      while(!vertice1.equals(vertices[i])){
      i++;//posição que deseja encontrar a menor rota
      }
      while(!vertice2.equals(vertices[j])){
      j++;//posição que deseja encontrar a menor rota
      }
     

      if(matrix[i][j]==1){//se for igual a 1 significa que o caminho é direto
                aux.add(vertice1);//adciona o vertice 1 
     
       aux.add(vertice2);//adciona o vertice 2
      return aux;
      }
      while(true){ //aplicação do algoritmo de warshal
          for(int k=0;k<numeroVertices;k++){//so sera executado até encontrar o caminho com menor numero de rotas
          for(int a=0;a<numeroVertices;a++){
              for(int b=0;b<numeroVertices;b++){
              if(matrix[a][b]==0 && matrix [a][k]==1 && matrix[k][b]==1){//Segundo o algoritmo, o valor da matriz só sera modificado se ele for 0 e a matriz [a][k] e [k][b] forem 1
              matrix[a][b]=1;
              maatrix[a][b]=maatrix[a][k];
              }              
              }
          }
        
          if (matrix[i][j]==1){//quando o elemento for igual a 1 significa que foi encontrado o menor caminho de rotas
                   break;
          } 
      }
          break;
      }
      
      while(true){//verificando o caminho entre os dois vertices, basicamente igual ao outro, só que este é ralizado com a variavel matrix maatrix 
        if(vertice1.equals(vertice2)){ 
            aux.add(vertice1);
                    
              return aux;
        }
        else{            
              aux.add(vertice1);
              int k=0,z=0;
        for (int a=0;a<vertices.length;a++){
        if(vertices[a].equals(vertice1)){
          k=a;
        }
        if(vertices[a].equals(vertice2)){
          z=a;
        }
        }       
        for (int a=0;a<vertices.length;a++){
        if(vertices[a].getNome().equals(maatrix[k][z])){
        vertice1 = vertices[a];
        break; 
        }
        }
     
        }
        }
    }


    


}
