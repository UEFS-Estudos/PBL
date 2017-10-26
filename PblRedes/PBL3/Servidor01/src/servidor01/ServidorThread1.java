/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pagotto
 */
public class ServidorThread1 {
    
    
       /*
        Existe duas maneiras de se usar Thread mas conceitualmente(
        utilziando o extends Thread ou usando o implements runnable ... QUAL diferença dos dois.. Primeiro extendendo o Thread
        vc poderá utilizar varios metodos seja o start o stop e etc.. além de escrever novamente o metodo run ... Já o implements
        vc só poderá utilizar e escrever novamente o metodo run.
        ISSo se chama thread Main .. usando um thread extendido e chamando na main
        */
   
    public static DataOutputStream recebeDNS;
       @SuppressWarnings("ResultOfObjectAllocationIgnored")
       public static void main(String[] args) throws SQLException, IOException{
           
            int porta=1234;//numeração da porta escolhida
              
           try {
               ServerSocket servidor= new ServerSocket(porta);//criando o servidor e numeroado a porta
               Socket iente= new Socket("192.168.43.103",1237);
               DataOutputStream a = new DataOutputStream(iente.getOutputStream());
             
               ServidorConectaEnde servidorMaster = new ServidorConectaEnde(iente);
               servidorMaster.start();
               System.out.println("test");
               while(true){
                  Socket conexao = servidor.accept(); // inicializando a conexao
                  
                  
                  System.out.println("Porta do Cliente:" + conexao.getPort());// printando a conexao 
                  System.out.println("Porta do Cliente:" + conexao.getLocalPort());
                  
                 
                  new ThreadConect(conexao).start();// esse comando que chama o threadConect, que a onde está presente todo o nosso protocolo
                  
               }
               
           } catch (IOException ex) {
               System.out.println(ex.toString());
           }
            
       }
}
