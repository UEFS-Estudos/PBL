/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.visWarm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe que auxilia a leitura de dados do usu�rio. Esta classe n�o deve ser
 * modificada. Para utiliz�-la, crie um atributo do tipo Console na sua 
 * aplica��o.
 * 
 * Esta classe foi baseada na classe Console desenvolvido por Ives Jose de 
 * Albuquerque Macedo Junior (ijamj@cin.ufpe.br)
 */
public class Console {

    /**
     * O buffer que armazena os dados vindos da stream de entrada
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Esta linha foi alterada para evitar a sobrecarga
    
    /**
     * M�todo que espera que o usu�rio digite uma String e aperte "Enter",
     * devolvendo a String digitada como resultado
     *
     * @return A String digitada
     */
    public static String readString() throws IOException {
        while (!Console.br.ready()) {
        }

        String ret = Console.br.readLine();

        return ret==null ? "" : ret;
    }

    /**
     * M�todo que espera que o usu�rio digite um caracter e aperte "Enter",
     * devolvendo o caracter digitado. Caso o usu�rio digite mais de um
     * caracter, o primeiro ser� lido e os demais ser�o descartados do sistema
     *
     * @return O caracter digitado
     */
    public static char readChar() throws IOException {  // este metodo foi alterado para ficar mais robusto        
        String str = Console.readString();
        return str.length()>0 ? str.charAt(0) : '\n';
    }

    /**
     * M�todo que espera que o usu�rio digite uma String e aperte "Enter",
     * devolvendo um array com os caracteres digitados como resultado
     *
     * @return A String digitada como array de caracteres
     */
    public static char[] readCharArray() throws IOException{        
        return Console.readString().toCharArray();
    }

    /**
     * M�todo que espera que o usu�rio digite um short e aperte "Enter",
     * devolvendo o short digitado, independentemente de ter sido digitado
     * como:<br>
     *
     * decimal;<br> octal: come�ando com um 0 (zero)<br> hexadecimal: come�ando
     * com um 0x ou um #<br>
     *
     * @return O short digitado
     */
    public static short readShort() throws IOException, NumberFormatException{        
        return Short.parseShort(Console.readString()); 
    }

    /**
     * M�todo que espera que o usu�rio digite um int e aperte "Enter",
     * devolvendo o int digitado, independentemente de ter sido digitado
     * como:<br>
     *
     * decimal;<br> octal: comecando com um 0 (zero)<br> hexadecimal: comecando
     * com um 0x ou um #<br>
     *
     * @return O int digitado
     */
    public static int readInt() throws IOException, NumberFormatException{
        return Integer.parseInt(Console.readString());        
    }

    /**
     * M�todo que espera que o usu�rio digite um long e aperte "Enter",
     * devolvendo o long digitado, independentemente de ter sido digitado
     * como:<br>
     *
     * decimal;<br> octal: começando com um 0 (zero)<br> hexadecimal: comecando
     * com um 0x ou um #<br>
     *
     * @return O long digitado
     */
    public static long readLong() throws IOException {
       return Long.parseLong(Console.readString());        
    }

    /**
     * M�todo que espera que o usu�rio digite um float e aperte "Enter",
     * devolvendo o float digitado
     *
     * @return O float digitado
     */
    public static float readFloat() throws IOException {
        return Float.parseFloat(Console.readString());        
    }

    /**
     * M�todo que espera que o usu�rio digite um double e aperte "Enter",
     * devolvendo o double digitado
     *
     * @return O byte digitado
     */
    public static double readDouble() throws IOException {
        return Double.parseDouble(Console.readString());                
    }

    
    /**
     * M�todo Main que testa os demais m�todos da classe Console. Este m�todo �
     * apenas para testar o Console e n�o deve ser modificado ou estendido!!!
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Esta classe n�o deve ser modificada, voc� deve criar \n"
                + "outra classe para ser a sua aplica��o, utilizando esta \n"
                + "classe (Console) como atributo! Segue os testes do Console:\n");
        System.out.println("Digite uma String qualquer !!!");
        String str = Console.readString();
        System.out.println("Voce digitou a String: " + str);
        
        System.out.println("Digite um caracter qualquer !!!");
        char chr = Console.readChar();
        System.out.println("Voce digitou o caracter: " + chr);

        System.out.println("Digite um sequencia de caracteres qualquer !!!");
        char[] chrs = Console.readCharArray();
        System.out.println("Voce digitou a sequencia: " + java.util.Arrays.toString(chrs));

        
        System.out.println("Digite um short qualquer !!!");
        short sht = Console.readShort();
        System.out.println("Voce digitou o short: " + sht );
        
        System.out.println("Digite um int qualquer !!!");
        int integer = Console.readInt();
        System.out.println("Voce digitou o int: " + integer );
        
        System.out.println("Digite um long qualquer !!!");
        long lng = Console.readLong();
        System.out.println("Voce digitou o long: " + lng );
        
        System.out.println("Digite um float qualquer !!!");
        float flt = Console.readFloat();
        System.out.println("Voce digitou o float: " + flt);

        System.out.println("Digite um double qualquer !!!");
        double dbl = Console.readDouble();
        System.out.println("Voce digitou o double: " + dbl);
    }
}

