/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto
 * Data: 14/06/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias. Esta classe foi
 * reutilizada do PBL1.
 */
package br.uefs.ecomp.visWarm.model;

import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Esta classe implementa os métodos para cadastros dos itens de arquivos de
 * texto.
 *
 * @author Kayo Costa e Washington Paggoto
 */
public class LeituraDeTexto {

    /**
     * Método que faz leitura do arquivo texto de Computadores.
     *
     * @param nomeArquivo String
     * @throws DataNotFoundException
     */
     public static void arquivoPC(String nomeArquivo) throws DataNotFoundException {

        String linha = null;
        String nome;
        String capacidade;

        try {
            FileReader reader = new FileReader(nomeArquivo); // Localizando arquivo texto. 
            BufferedReader leitor = new BufferedReader(reader);//aloca espaço na memoria para o arquivo

            StringTokenizer st = null;//fornece  métodos para analisar uma cadeia de caracteres e dividir-las com um delimitador

            //faz leitura de linha até encontra uma, linha vazia.
            while ((linha = leitor.readLine()) != null) {

                // UTILIZA DELIMITADOR, PARA DIVIDIR OS CAMPOS  
                st = new StringTokenizer(linha, " ");
                String dados = null;

                while (st.hasMoreTokens()) {

                    // Campo capacidade 
                    dados = st.nextToken();
                    nome = dados;

                    // Campo nome
                    dados = st.nextToken();
                    capacidade = dados;
                    String tamanho;//responsável por armazenar o numero que será convertido pra double
                    //recebe a unidade de capacidade para usar fazer a conversão.
                    char x = capacidade.charAt(capacidade.length() - 2);//recebendo A letra de conversão
                    x = Character.toUpperCase(x);
                    if (x == 'M' || x == 'P' || x == 'G' || x == 'K' || x == 'T') {//igual signifca que haverá duas casas de unidade de medida
                        tamanho = capacidade.substring(0, capacidade.length() - 2);//sera convertido pra double
                    } else { // será byte ou seja 1casa de unidade de medida
                        x = capacidade.charAt(capacidade.length() - 1);
                        x = Character.toUpperCase(x);
                        tamanho = capacidade.substring(0, capacidade.length() - 1);//sera convertido pra double
                    }
                    //recebendo a unidade convertida.
                    double z = unidade(x);//recebe o retorno da funcao unidade
                    //faz com que tamanho seja do diminuido entre dois caracteres,
                    //ou seja a unidade de medida irá sumir.

                    //convertendo a String em double.
                    double capacidadePc = Double.parseDouble(tamanho) * z; //transforma o tamanho do video pra MB    

                    Computador novo = new Computador(nome, capacidadePc);
                    try {
                        ComputadorMaster.inserirComputador(novo);
                    } catch (CadastroRepetidoException a) {
                        System.out.println("O computador " + nome + " já foi cadastrado no sistema ");
                    }

                }
            }
            leitor.close();
            reader.close();

        } catch (Exception e) {
            throw new DataNotFoundException();
        }

    }

    /**
     * Método que faz leitura de videos.
     *
     * @param nomeArquivo String
     * @throws DataNotFoundException
     * @throws CapacidadeMaximaException
     * @throws CadastroRepetidoException
     */
    public static void arquivoVideos(String nomeArquivo) throws DataNotFoundException, CapacidadeMaximaException, CadastroRepetidoException {

        String linha = null;
        String nome;
        String capacidade;

        try {
            FileReader reader = new FileReader(nomeArquivo); // LocalizaÃƒÂ§ÃƒÂ£o do Arquivo  
            BufferedReader leitor = new BufferedReader(reader);
            //fornece  métodos para analisar uma cadeia de caracteres e dividir-las com um delimitador
            StringTokenizer st = null;

            //faz leitura de linha até encontra uma, linha vazia.
            while ((linha = leitor.readLine()) != null) {

                // UTILIZA DELIMITADOR ; PARA DIVIDIR OS CAMPOS  
                st = new StringTokenizer(linha, " ");
                String dados = null;

                while (st.hasMoreTokens()) {

                    // Campo capacidade 
                    dados = st.nextToken();
                    nome = dados;

                    // Campo nome
                    dados = st.nextToken();
                    capacidade = dados;
                    String tamanho; //responsável por armazenar o que será convertido pra double
                    //recebe a unidade de capacidade para usar fazer a conversão.
                    char x = capacidade.charAt(capacidade.length() - 2);//recebendo A letra de conversão
                    x = Character.toUpperCase(x);//maiusculo, para caso uma letra venha minuscula
                    if (x == 'M' || x == 'P' || x == 'G' || x == 'K' || x == 'T') {//2 casas de unidade de medida
                        tamanho = capacidade.substring(0, capacidade.length() - 2);//sera convertido pra double
                    } else {//sera um byte
                        x = capacidade.charAt(capacidade.length() - 1);
                        x = Character.toUpperCase(x);
                        tamanho = capacidade.substring(0, capacidade.length() - 1);//sera convertido pra double
                    }
                    //recebendo a unidade convertida.
                    double z = unidade(x);

                    double capacidadeVideo = Double.parseDouble(tamanho) * z;//converte a string em double    
                    Video v = new Video(nome, capacidadeVideo);

                    try {

                        ComputadorMaster.distribuirVideo(v);

                    } catch (CapacidadeMaximaException e) {
                        System.out.println("O video " + nome + " não pode ser inserido pois não há capacidade");
                    } catch (CadastroRepetidoException a) {
                        System.out.println("O video " + nome + " já¡ foi cadastrado no sistema");
                        // throw new CadastroRepetidoException();
                    }

                }
            }
            leitor.close();
            reader.close();

        } catch (Exception e) {
            throw new DataNotFoundException();
        }

    }

    /**
     * Método que verifica a unidade que será convertida.
     *
     * @param x char
     * @return y double
     */
    public static double unidade(char x) {

        double y = 1 / 1000000;//caso a unidade ja seja Byte
        if (x == 'K') {
            y = 1 / 1000;
        } else if (x == 'M') {
            y = 1;
        } else if (x == 'G') {
            y = 1000;
        } else if (x == 'T') {
            y = 1000000;
        } else if (x == 'P') {
            y = 1000000000;
        }
        return y;

    }
}
