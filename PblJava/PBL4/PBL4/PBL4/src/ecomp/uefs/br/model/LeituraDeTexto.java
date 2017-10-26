package ecomp.uefs.br.model;

/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto
 * Data: 20/07/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias. Esta classe foi
 * reutilizada do PBL1.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Esta classe implementa os métodos para cadastros dos itens de arquivos de
 * texto.
 *
 * @author Kayo Costa e Washington Pagotto
 */
public class LeituraDeTexto {

    /**
     * Método que faz leitura do arquivo texto e manipula o mesmo para.
     *
     * @param arquivo File
     * @param vertices  LinkedList
     * @param arestas  LinkedList
     * @param funcionarios  List
     */
     public static void cadastrarMansaoTxt(File arquivo, LinkedList vertices, LinkedList arestas, List funcionarios){

        String linha = null;

        LinkedList verticesAux=new LinkedList();
        boolean verifica=true;//variavel auxiliar para evitar muitas comparaçoes
        try {
            FileReader reader = new FileReader(arquivo); // Localizando arquivo texto. 
            BufferedReader leitor = new BufferedReader(reader);//aloca espaço na memoria para o arquivo

            StringTokenizer st = null;//fornece  métodos para analisar uma cadeia de caracteres e dividir-las com um delimitador
            int x= Integer.parseInt(leitor.readLine());
            //faz leitura de linha até encontra uma, linha vazia.
            while ((linha = leitor.readLine()) != null) {
                // UTILIZA DELIMITADOR, PARA DIVIDIR OS CAMPOS 
                if(linha.contains("*")){//se contem o caracter * na linha
                    if(verifica){//primeiro cadastro de funcionarios
                    Iterator it=verticesAux.iterator();
                    while(it.hasNext())
                        vertices.add(new Vertice((String)it.next()));//transforma a lista de nomes de vertices em lista de vertices
                    verifica=false;
                    }
                 st = new StringTokenizer(linha, "*"); //delimita as strings no *
                    String v1 = null;
                    String f = null;
                    f = st.nextToken();//pega a primeira parte da linha
                    v1 = st.nextToken();//pega a segunda parte da linha
                    
                    Vertice vertice1 = new Vertice(v1);//cria o vertice
                    Funcionario func = new Funcionario (f);//cria o funcionario
                    int auxiliar= verticesAux.indexOf(v1);//index do vertice que o funcionario está
                    Vertice aux=((Vertice)vertices.get(auxiliar));//recupera o vertice criado com base no vertice inserido
                    aux.setFuncionario(func);//faz com que o vertice receba o funcionario
                    vertices.set(auxiliar, aux); //faz com que a lista de vertices seja atualizada 
                    funcionarios.add(func);//adciona o funcionario a lista

                }
                else{
                st = new StringTokenizer(linha, "-");//delimita em -
                 String v1 = null;
                String v2 = null;
                String tamanho=null;
                    v1 = st.nextToken();//recebe a primeira string
                    v2 = st.nextToken();//a segunda string
                    tamanho = st.nextToken();             //a terceira string"peso"       
                    int TAMANHO= Integer.parseInt(tamanho);//converte o peso pra inteiro
                    Vertice vertice1=new Vertice(v1);//cria o vertice
                    
                    if (verticesAux.indexOf(v1)==-1){//verifica se o vertice não foi inserido ainda na lista para evitar repetição
                    verticesAux.add(v1);
                    }
                    Vertice vertice2=new Vertice (v2);
                    if (verticesAux.indexOf(v2)==-1){//verifica se o vertice nao foi inserido ainda na lista para evitar repetição
                    verticesAux.add(v2);
                    }
                    Aresta a = new Aresta(vertice1,vertice2,TAMANHO);//cria a resta
                    arestas.add(a);//adciona a aresta
                }     
            
            }          
            leitor.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            //throw new DataNotFoundException();
        }

    }

}
