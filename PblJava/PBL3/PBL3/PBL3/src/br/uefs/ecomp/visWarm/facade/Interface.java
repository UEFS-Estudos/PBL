/** 
 * Componente Curricular: Módulo Integrado de Programação 2
 * Autor: Kayo Costa de Santana e Washington Pagotto
 * Data: 14/06/2014
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
package br.uefs.ecomp.visWarm.facade;

import br.uefs.ecomp.visWarm.model.Computador;
import static br.uefs.ecomp.visWarm.model.LeituraDeTexto.unidade;
import br.uefs.ecomp.visWarm.model.Video;
import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.CapacidadeMaximaException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;
import br.uefs.ecomp.visWarm.model.exception.PerdaDeDadosException;
import br.uefs.ecomp.visWarm.util.Console;
import br.uefs.ecomp.visWarm.util.Iterador;
import java.io.IOException;

/**
 *
 * @author Kayo
 */
public class Interface {

    public static double valorConvertido(String capacidade) {
        String tamanho;
        char x = capacidade.charAt(capacidade.length() - 2);//recebendo A letra de conversão
        x = Character.toUpperCase(x);
                                        if(x=='M' ||   x=='P' ||   x=='G' ||   x=='K' ||   x=='T'){//caso seja igual significa que existem duas casas de unidade de medida
                                            tamanho = capacidade.substring(0, capacidade.length() - 2);//sera convertido pra double
                                        } 
                                        else{//significa que é B, e só tem uma unidade de medida
                                            x = capacidade.charAt(capacidade.length() - 1);
                                            x = Character.toUpperCase(x);
                                        tamanho = capacidade.substring(0, capacidade.length() - 1);//sera convertido pra double
                                        } 
        double z = unidade(x);
        double tamanhoVideo = Double.parseDouble(tamanho) * z;//serve tambem para pc
        return tamanhoVideo;
    }

    public static void systemPause() throws IOException {
        System.out.println("Digite uma tecla para continuar...");
        Console.readString();
    }

    public static void main(String[] args) throws Exception {

        int escolhaMenu;
        Facade facade = new Facade();
        boolean verifica1 = true;
        boolean verifica2;
        while (verifica1) {
            try {
                System.out.println("Olá, você está conectado em: "
                        +System.getProperty("user.name")
                        + "\n\nDigite [1] para cadastrar um novo computador via teclado"
                        + "\nDigite [2] para cadastrar um novo vídeo via teclado"
                        + "\nDigite [3] para cadastrar um novo computador via arquivo de texto"
                        + "\nDigite [4] para cadastrar um novo video via arquivo de texto"
                        + "\nDigite [5] para listar todos os computadores e a sua capacidade total"
                        + "\nDigite [6] para listar todos os videos contidos no servidor e onde ele está armazenado"
                        + "\nDigite [7] para listar todos os computadores e o espaço disponível de cada um deles"
                        + "\nDigite [8] para listar todos os videos de um determinado computador"
                        + "\nDigite [9] para buscar um vídeo"
                        + "\nDigite [10] para excluir um computador"
                        + "\nDigite [11] para excluir um vídeo"
                        + "\nDigite [12] para sair"
                        + "\nEscolha:  ");
                escolhaMenu = Console.readInt();
                switch (escolhaMenu) {
                    case 1:
                        System.out.println("Digite o nome do Computador:  ");
                        String nomePc = Console.readString();
                        System.out.println("Digite a capacidade do Computador e a sua unidade de medida (Exemplo: 150MB)"
                                + "Capacidade: ");
                        String capacidadeUnidade = Console.readString();
                        double capacidade = valorConvertido(capacidadeUnidade);
                        try {
                            facade.cadastrarComputador(nomePc, capacidade);
                        } catch (CadastroRepetidoException e) {
                            System.out.println("Cadastro já existe no sistema...");
                            systemPause();
                        }
                        break;
                    case 2:
                        System.out.println("Digite o nome do Vídeo :  ");
                        String nomeVi = Console.readString();
                        System.out.println("Digite o tamanho do Video e a sua unidade de medida (Exemplo: 150MB)"
                                + "Tamanho: ");
                        String tamanhoUnidade = Console.readString();
                        double tamanho = valorConvertido(tamanhoUnidade);
                        try {
                            facade.cadastrarVideo(nomeVi, tamanho);
                        } catch (CadastroRepetidoException e) {
                            System.out.println("Cadastro já existe no sistema...");
                            systemPause();
                        } catch (CapacidadeMaximaException a) {
                            System.out.println("Sem espaço para alocação de vídeos");
                            systemPause();
                        }
                        break;
                    case 3:
                        System.out.println("Digite o nome do arquivo de Computadores (Exemplo: Computadores.txt)"
                                + "Nome: ");
                        String nomeAPc = Console.readString();//nome do arquivo do pc
                        try {
                            facade.cadastrarComputadorViaTxt(nomeAPc);
                        } catch (DataNotFoundException e) {
                            System.out.println("Nome de arquivo inválido ...");
                            systemPause();
                        } catch (CadastroRepetidoException a) {
                            System.out.println("Cadastro repetido ...");
                            systemPause();
                        }
                        break;
                    case 4:
                        System.out.println("Digite o nome do arquivo de Videos (Exemplo: Videos.txt)"
                                + "Nome: ");
                        String nomeAVi = Console.readString();//nome do arquivo do pc
                        try {
                            facade.cadastrarVideoViaTxt(nomeAVi);
                        } catch (DataNotFoundException e) {
                            System.out.println("Nome de arquivo inválido ...");
                            systemPause();
                        } catch (CadastroRepetidoException a) {
                            System.out.println("Cadastro repetido ...");
                            systemPause();
                        } catch (CapacidadeMaximaException d) {
                            System.out.println("Espaço insuficiente ...");
                            systemPause();
                        }
                        break;
                    case 5:
                        Iterador comp = facade.listarComputadores();
                        while (comp.temProximo()) {
                            Computador aux = ((Computador) comp.proximo());
                            System.out.println("\nNome do Computador:  " + aux.getNome());
                            System.out.println("\nCapacidade total do Computador:  " + aux.getCapacidadeTotal() + "MB");
                        }
                        break;
                    case 6:
                        verifica2 = true;
                        while (verifica2) {
                            Iterador aux = facade.listarComputadores();
                            while (aux.temProximo()) {
                                Computador atual = ((Computador) aux.proximo());
                                if (!aux.temProximo()) {//se não tiver proximo elemento para analisar ele fará sair do laço while(verifica2)
                                    verifica2 = false;
                                }
                                Iterador aux2 = facade.listarVideosEmPc(atual.getNome());
                                System.out.println("\nVideos do Computador   " + atual.getNome());
                                while (aux2.temProximo()) {
                                    Video video = ((Video) aux2.proximo());
                                    System.out.println("Nome " + video.getNome());
                                    System.out.println("Tamanho " + video.getTamanho() + "MB");
                                }
                            }
                        }
                        break;
                    case 7:
                        Iterador compt = facade.listarComputadores();
                        while (compt.temProximo()) {
                            Computador aux = ((Computador) compt.proximo());
                            System.out.println("\nNome do Computador:  " + aux.getNome());
                            System.out.println("\nCapacidade atual do Computador:  " + aux.getCapacidadeAtual() + "MB");
                        }
                        break;
                    case 8:
                        System.out.println("Digite o nome do Computador :  ");
                        String pcVi = Console.readString();
                        Iterador viEmPc;
                        try {
                            viEmPc = facade.listarVideosEmPc(pcVi);
                            while (viEmPc.temProximo()) {
                            Video aux = ((Video) viEmPc.proximo());
                            System.out.println("\nNome do video:  " + aux.getNome());
                            System.out.println("\nCapacidade atual do Computador:  " + aux.getTamanho() + "MB");
                        }
                        } catch (DataNotFoundException a) {
                            System.out.println("Computador não encontrado");
                            systemPause();
                        }
                        
                        break;
                    case 9:
                        System.out.println("Digite o nome do Vídeo :  ");
                        String nomeViBuscar = Console.readString();
                        try {
                            Video aux = facade.buscarVideo(nomeViBuscar);
                            System.out.println("Tamanho: " + aux.getTamanho());
                            System.out.println("Computador: " + aux.getComputador().getNome());
                        } catch (DataNotFoundException e) {
                            System.out.println("Video não existe no sistema ...");
                        }
                        break;
                    case 10:
                        System.out.println("Digite o nome do Computador que deseja remover :  ");
                        String pcRemover = Console.readString();
                        try {
                            facade.excluirComputador(pcRemover);
                        } catch (PerdaDeDadosException ea) {
                            System.out.println("A remoção do computador implicaria na perda de dados... \n\t\tComputador NÃO removido!");
                            systemPause();
                        } catch (DataNotFoundException e) {
                            System.out.println("Computador não existe no sistema ...");
                            systemPause();
                        }
                        break;
                    case 11:
                        System.out.println("Digite o nome do Video que deseja remover :  ");
                        String videoRemover = Console.readString();
                        try {
                            facade.excluirVideo(videoRemover);
                        } catch (DataNotFoundException e) {
                            System.out.println("Video não existe no sistema ...");
                            systemPause();
                        }
                        break;
                    case 12:
                        System.out.println("Até mais...  "
                                +System.getProperty("user.name"));
                        systemPause();
                        verifica1 = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu algum erro no sistema, tente novamente...");
                systemPause();
            }
        }
    }
}
