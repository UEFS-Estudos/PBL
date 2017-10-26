/**
 * Componente Curricular: Módulo Integrado de Programação 2 Autor: Kayo Costa de
 * Santana e Washington Pagotto 
 * Data: 18/06/2014 Declaro que este código foi
 * elaborado por mim de forma individual e não contém nenhum trecho de código de
 * outro colega ou de outro autor, tais como provindos de livros e apostilas, e
 * páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de
 * outra autoria que uma citação para o não a minha está destacado com autor e a
 * fonte do código, e estou ciente que estes trechos não serão considerados para
 * fins de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias. Esta classe foi
 * reutilizada do PBL1.
 */
package br.uefs.ecomp.visWarm.util;

import br.uefs.ecomp.visWarm.model.exception.CadastroRepetidoException;
import br.uefs.ecomp.visWarm.model.exception.DataNotFoundException;

/**
 * Este classe implementa o comportamento de uma árvore binária AVL. A classe
 * foi implementada a partir de uma interface de árvore binária normal
 *
 * @author Kayo Costa e Washington Paggoto
 * @see br.uefs.ecomp.visWarm.util.No
 */
public class ArvoreAVL implements IBinaryTree {

    private No raiz = null;

    /**
     * Este método exclui um vídeo de forma recursiva.
     *
     * @param aux No
     * @param item Comparable
     * @return No
     */
    public No excluir(No aux, Comparable item) {
        No aux2, aux3;
        if (item.compareTo(aux.getObjeto()) == 0) {//caso base
            if (aux.getfEsquerdo() == aux.getfDireito()) {
                return null;//ou seja ambos sao null, ja que é a unica hipotese dos filhos serem iguais "o elemento é uma folha"
            } else if (aux.getfEsquerdo() == null && aux.getfDireito() != null) {//O elemento possui apenas filho direito
                return aux.getfDireito();
            } else if (aux.getfDireito() == null && aux.getfEsquerdo() != null) {//o elemento possui apenas filho esquerdo
                return aux.getfEsquerdo();
            } else { // o elemento possui filho esquerdo e filho direito
                aux2 = aux.getfEsquerdo();
                aux3 = aux.getfDireito();
                No anterior = aux2;
                boolean verifica = false;
                while (aux2.getfDireito() != null) {//proucurando um sucessor para o elemento excluido
                    anterior = aux2;
                    aux2 = aux2.getfDireito();
                    verifica = true;//verificando se o sucessor realmente foi um filho à direita 
                }
                if (verifica == true) {
                    aux2.setfDireito(aux.getfDireito());
                    aux2.setfEsquerdo(aux.getfEsquerdo());
                    anterior.setfDireito(null);
                } else {
                    aux2.setfDireito(aux.getfDireito());
                }

                aux2.setAltura(maiorAltura(aux.getfDireito().getAltura(), aux.getfEsquerdo().getAltura()) + 1);
                aux2 = balancear(aux2);
                return aux2;
            }
        } else if (item.compareTo(aux.getObjeto()) > 0) {
            aux.setfDireito(excluir(aux.getfDireito(), item));//proucurando o elemento
        } else {
            aux.setfEsquerdo(excluir(aux.getfEsquerdo(), item));//proucurando o elemento
        }

        aux = balancear(aux);

        return aux;

    }

    /**
     * Este método procura o nó pai de um item.
     *
     * @param item Comparable
     * @return No || null
     */
    public No procurarPai(Comparable item) {
        No aux = raiz;
        No anterior = null;
        while (aux != null) {

            if (item.compareTo(aux.getObjeto()) < 0) {
                anterior = aux;
                aux = aux.getfEsquerdo();
            } else if (item.compareTo(aux.getObjeto()) > 0) {
                anterior = aux;
                aux = aux.getfDireito();
            } else if (item.compareTo(aux.getObjeto()) == 0) {
                return anterior;
            }

        }
        return null;
    }

    /**
     * Este método procura um item ná arvore.
     *
     * @param item Comparable
     * @return No || null
     */
    public No procurar(Comparable item) {
        No aux = raiz;
        while (aux != null) {   //o while sera encerrado quando o item for encontrado ou quando tiver a certeza que ele nao existe
            if (item.compareTo(aux.getObjeto()) < 0) {
                aux = aux.getfEsquerdo();
            } else if (item.compareTo(aux.getObjeto()) > 0) {
                aux = aux.getfDireito();
            } else if (item.compareTo(aux.getObjeto()) == 0) {
                return aux;
            }
        }
        return null;
    }

    /**
     * Este método insere um item ná arvore de forma recursiva.
     *
     * @param item Comparable
     * @param aux No
     * @return No
     * @throws CadastroRepetidoException
     */
    public No insert(Comparable item, No aux) throws CadastroRepetidoException {
        if (procurar(item) != null) {
            throw new CadastroRepetidoException();
        }
        if (aux == null) {//caso base
            aux = new No(item);
        } else if (item.compareTo(aux.getObjeto()) < 0) {//se for menor que 0 passa por parametro o no da esquerda
            aux.setfEsquerdo(insert(item, aux.getfEsquerdo()));
        } else if (item.compareTo(aux.getObjeto()) > 0) {//se for maior que 0 passa por parametro o no da direita
            aux.setfDireito(insert(item, aux.getfDireito()));
        }
        aux = balancear(aux);
        return aux;

    }

    /**
     * Este método procura um vídeo ná arvore.
     *
     * @param item Comparable
     * @return Object
     * @throws DataNotFoundException
     */
    @Override
    public Object search(Comparable item) throws DataNotFoundException {
        Object o = procurar(item);
        if (o != null) {
            o = ((No) o).getObjeto();
            return o;
        }
        throw new DataNotFoundException();
    }

    /**
     * Este método adciona um item na árvore, chamando o método recursivo de
     * inserção.
     *
     * @param item Comparable
     * @throws CadastroRepetidoException
     */
    @Override
    public void add(Comparable item) throws CadastroRepetidoException {
        try {
            raiz = insert(item, raiz);//chama o método recursivo inserir
        } catch (CadastroRepetidoException ex) {
            throw new CadastroRepetidoException();
        }

    }

    /**
     * Este método remove um item da árvore, chamando o método recursivo de
     * remoção.
     *
     * @param item
     * @throws DataNotFoundException
     */
    @Override
    public void remove(Comparable item) throws DataNotFoundException {
        raiz = excluir(raiz, item);//chama o método excluir

    }

    /**
     * Este método retorna o iterador de uma árvore.
     *
     * @return Iterador
     */
    public Iterador iterator() {
        ListaEncadeada aux = new ListaEncadeada();//cria uma lista
        fazerIterar(aux);//faz com que os objetos sejam inseridos na lista
        return aux.iterador(); //retorna iterador da lista
    }

    /**
     * Este método chama o método recursivo emordem.
     *
     * @param aux ListaEncadeada
     */
    public void fazerIterar(ListaEncadeada aux) {
        emordem(raiz, aux);
    }

    /**
     * Este método insere em ordem os elementos da árvore em uma lista
     * encadeada.
     *
     * @param no No
     * @param lista ListaEncadeada
     */
    public void emordem(No no, ListaEncadeada lista) {
        if (no != null) {
            emordem(no.getfEsquerdo(), lista);//pega todos os elementos da arvore da esquerda
            lista.insereFinal(no.getObjeto()); // insere na lista
            emordem(no.getfDireito(), lista); //pega todos os elementos da arvore da direita
        }
    }

    /**
     * Este método retorna a altura de um nó.
     *
     * @param t
     * @return int
     */
    public int altura(No t) {
        return t == null ? -1 : t.getAltura();//se o nó recebido for null ele retorna -1,  se não ele retorna a sua altura
    }

    /**
     * Este método analisa qual é a maior altura de um nó.
     *
     * @param esquerda int
     * @param direita int
     * @return int
     */
    public int maiorAltura(int esquerda, int direita) {
        return esquerda > direita ? esquerda : direita;//se esquerda for maior que direita retorna altura da esquerda, se não retorna a da direita
    }

    /**
     * Este método retorna o fator de balanceamento de um Nó.
     *
     * @param aux No
     * @return int
     */
    private int fatorBalanceamento(No aux) {
        return altura(aux.getfEsquerdo()) - altura(aux.getfDireito());
    }

    /**
     * Este método executa a rotação simples à direita.
     *
     * @param aux2 No
     * @return No
     */
    public No rotacaoDireita(No aux2) {
        No aux1 = aux2.getfEsquerdo();//aux1 recebe o filho da esquerda do nó
        aux2.setfEsquerdo(aux1.getfDireito()); //o filho a esquerda do nó é igual ao filho da direita de aux1
        aux1.setfDireito(aux2); // o filho da direita de aux1, será aux 2. 
        aux2.setAltura(maiorAltura(altura(aux2.getfEsquerdo()), altura(aux2.getfDireito())) + 1); //determinando altura
        aux1.setAltura(maiorAltura(altura(aux1.getfEsquerdo()), altura(aux2.getfDireito())) + 1); //determinando altura
        return aux1;
    }

    /**
     * Este método executa a rotação simples à esquerda.
     *
     * @param aux1 No
     * @return No
     */
    public No rotacaoEsquerda(No aux1) {
        No aux2 = aux1.getfDireito(); //aux 2 recebe o filho direito do no
        aux1.setfDireito(aux2.getfEsquerdo()); //o filho direito de aux 1 passa a ser o filho esquerdo de aux 2
        aux2.setfEsquerdo(aux1); // o filho esquerdo de aux 2 agora é aux 1
        aux1.setAltura(maiorAltura(altura(aux1.getfEsquerdo()), altura(aux1.getfDireito())) + 1);//determinado a altura de aux1
        aux2.setAltura(maiorAltura(altura(aux2.getfEsquerdo()), altura(aux1.getfDireito())) + 1); // determinando a altura de aux2
        return aux2;
    }

    /**
     * Este método executa a rotação dupla à direita.
     *
     * @param aux3 No
     * @return No
     */
    public No rotacaoDuplaDireita(No aux3) {
        aux3.setfEsquerdo(rotacaoEsquerda(aux3.getfEsquerdo()));
        return rotacaoDireita(aux3);
    }

    /**
     * Este método executa a rotação dupla à esquerda.
     *
     * @param aux1
     * @return No
     */
    private No rotacaoDuplaEsquerda(No aux1) {
        aux1.setfDireito(rotacaoDireita(aux1.getfDireito()));
        return rotacaoEsquerda(aux1);
    }

    /**
     * Este método é responsável por balancear a árvore.
     *
     * @param aux No
     * @return No
     */
    public No balancear(No aux) {

        if (fatorBalanceamento(aux) == 2) {
            if (fatorBalanceamento(aux.getfEsquerdo()) > 0) {//verificando fator de balanceamento do filho
                aux = rotacaoDireita(aux);//fazendo a rotação simples
            } else {
                aux = rotacaoDuplaDireita(aux);//fazendo a rotação dupla
            }
        } else if (fatorBalanceamento(aux) == -2) {
            if (fatorBalanceamento(aux.getfDireito()) < 0) {//verificando fator de balanceamento do filho
                aux = rotacaoEsquerda(aux);
            } else {
                aux = rotacaoDuplaEsquerda(aux);
            }
        }
        aux.setAltura(maiorAltura(altura(aux.getfEsquerdo()), altura(aux.getfDireito())) + 1);//calculando a nova altura
        return aux;
    }

    /**
     * Este método retorna a raiz da árvore.
     *
     * @return No
     */
    public No getRaiz() {
        return raiz;
    }
    /* METODOS PARA PRINTAR A ÁRVORE
     public void displayTree() {
     if (raiz == null) {
     System.out.println("Árvore vazia!");
     return;
     }
     String separator = String.valueOf("  |__");
     System.out.println(this.raiz.getObjeto() + "(" + raiz.getAltura() + ")");

     displaySubTree(raiz.getfEsquerdo(), separator);
     displaySubTree(raiz.getfDireito(), separator);
     }

     private void displaySubTree(No node, String separator) {

     if (node != null) {

     No father = this.procurarPai((Comparable) node.getObjeto());
     if (node.equals(father.getfEsquerdo()) == true) {
     System.out.println(separator + node.getObjeto() + "(" + node.getAltura() + ")" + " (ESQ)");
     } else {
     System.out.println(separator + node.getObjeto() + "(" + node.getAltura() + ")" + " (DIR)");
     }
     displaySubTree(node.getfEsquerdo(), "     " + separator);
     displaySubTree(node.getfDireito(), "     " + separator);
     }
     }
     */
}
