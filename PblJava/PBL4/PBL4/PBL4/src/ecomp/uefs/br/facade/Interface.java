/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
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
package ecomp.uefs.br.facade;

import ecomp.uefs.br.model.Vertice;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import ecomp.uefs.br.model.exception.DataNotFoundException;
import ecomp.uefs.br.model.exception.LugarOcupadoException;

/**
 *
 * @author Washington e Kayo
 */
public class Interface extends JFrame{
  
    public Facade facade;
     
   
    public Interface(){
        super("PBL4");
        menuBarra();//método da interface
        apresenta();//label do nome
       
        
        facade= new Facade();
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fechando janela
        setSize(850,300); //dando dimensão a janela
     
                
        
       
   }
    
    
    public void menuBarra(){
         
         actionCadastrar mover = new actionCadastrar(); //action de mover funcionario pra qualquer comodo
         JMenu menuF= new JMenu("Funcinonário");//criando o objeto menu.
         JMenuBar barMenu= new JMenuBar();//criando objeto menu Barra
      
         JMenuItem funcionarioItens =new JMenuItem("Cadastrar");//menu item de funcionário
         funcionarioItens.addActionListener(mover);//adiconando action de mover no menu item
         menuF.add(funcionarioItens); //adicionando o item no menu
        
         actionRemover remover = new actionRemover();//action de remover funcionario do comodo
         JMenuItem removerF= new JMenuItem("Remover");// objeto menu item
         removerF.addActionListener(remover);// adicionando action de remover funcionario do comodo no menu Item
         menuF.add(removerF);// adicionando no menu de funcionarios
         
         actionListarF listar= new actionListarF();//action de listar funcinários e seus comodos.
         JMenuItem consultarF= new JMenuItem("Consultar");//objeto menu item
         consultarF.addActionListener(listar);//adiconando action para listar funcinários no menu item.
         menuF.add(consultarF);//adicionando menu item no menu
         
         JMenu menuCrise = new JMenu("Mr. Robert");//criando menu de Mr.robert
         
         JMenu crise = new JMenu("Crise");//add menu crise.
         menuCrise.add(crise);//adicionando no menu principal
         
         actionTempo t= new actionTempo();// action de menor tempo e o caminho
         JMenuItem tempo = new JMenuItem("Menor tempo e caminho");//menu item de tempo e caminho
         tempo.addActionListener(t);//adicionando action no menu item de tempo.
         crise.add(tempo);// adiconando menu item no menu.
         
         actionComodo c= new actionComodo();//action de menor numero de comodos
         JMenuItem comodo= new JMenuItem("Menor número de Comodo e caminho");//criando menu item.
         comodo.addActionListener(c);// adicionando action no menu item.
         crise.add(comodo);//adicionando menu item no menu.
         
         actionImporta i = new actionImporta();// adicionando action de importar.
         JMenu importa= new JMenu("Importar txt");// menu barra de importar txt
         JMenuItem txt = new JMenuItem("Selecionar");// menu item pra ele selecionar
         txt.addActionListener(i);// adicionando action 
         importa.add(txt);//adicionando menu item no menu.
         
         actionInformacao in = new actionInformacao();//action de informações
         JMenu informa = new JMenu("Informações");//menu de informações
         JMenuItem sobre= new JMenuItem("Sobre");//menu item
         sobre.addActionListener(in);//add action no menu item.
         informa.add(sobre);//adicionando menu item no menu
         
         // adiconando os menus no menu Barra.
         setJMenuBar(barMenu);
         barMenu.add(importa);
         barMenu.add(menuF);
         barMenu.add(menuCrise);
         barMenu.add(informa);
        
                  
    }
    
    
    
    public void apresenta(){
                
            	setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();// criando a panel pra colocar o titulo
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("PBL4 - Sistema de alerta à Emergência");//criando label pra adicionar na panel.
		titulo.setFont(new Font("Verdana", Font.PLAIN,40));// definido tamanho e fonte
		
		panelTitulo.add(titulo);//adicionando  label na panel
		add(panelTitulo, BorderLayout.NORTH);// direcionando ele pro norte.
		
                //add(cadastro,BorderLayout.CENTER);
		//add(botoesPanel, BorderLayout.SOUTH);
    }
    
    public File importarArquivo(){
        
		       Container c = getContentPane();
		       FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		       c.setLayout(layout);// definido layout
		       JFileChooser fc = new JFileChooser(); // criando o chooser para pegar o txt
		       FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
	               fc.setFileFilter(filter);// defindo o filtro que só pode ler arquivo txt
		       
		       int res = fc.showOpenDialog(null);
			   //caso ele escolha o arquio e seja aprovado será aceito o mesmo e será printada o nome dele.
			   if(res == JFileChooser.APPROVE_OPTION){
                            
                               File arquivo = fc.getSelectedFile();  
			       JOptionPane.showMessageDialog(null, "Voce escolheu o arquivo: " + arquivo.getName());
			       return arquivo;
			   }
			   else// se nao for será printado que não selecionada o arquivo.
			       JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo.");
		                     
		       return null;
		   }    
    
    private class actionCadastrar implements ActionListener{

         /*classe que adiciona uma action que é mover 
         * o funcionário de comodo.
         * 
         */
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
           
                
                try {
                    String funcionario = JOptionPane.showInputDialog(null, "Digite Funcionario que deseja mover:");
                    String ver =JOptionPane.showInputDialog(null,"Digite o comodo:");
                    facade.adcionarFuncionarioEmComodo(funcionario,ver);
                } catch (DataNotFoundException ex) {
                    //ex.printStackTrace();
                     JOptionPane.showMessageDialog(null,"Funcionário ou Cômodo não existe");//caso o funcionário n exista
                } catch (LugarOcupadoException exa) {
                     JOptionPane.showMessageDialog(null, "Já está ocupado" );//caso o comodo já esteja com funcionário
                }
               
            }
            
            
        
        
    }
    
     private class actionRemover implements ActionListener{

         /*
          * Classe que cria uma action 
          * quando desejar remover um funcionário do comodo.
          */
          
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
                                
                    String funcionario = JOptionPane.showInputDialog(null, "Digite o funcionario que deseja:");
                    try{
                    facade.removerFuncionarioDoComodo(funcionario);
                    }
                    // caso o funcionário não exista
                    catch(DataNotFoundException a){
                    JOptionPane.showMessageDialog(null,"Funcionário não existe");
                    } 
               
            }
        
     }  
     
     
     private class actionImporta implements ActionListener{

          /*
          *  classe que adiciona uma action para 
          * importar arquivo de txt.
          */
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
           
              File  f= importarArquivo();
              facade.cadastrarMansao(f);
               
            }
            
            
        
        
    }
     
      private class actionTempo implements ActionListener{
        
          /*
           * classe que adiciona uma action 
           * para mostrar o menor tempo e o caminho que o funcionário 
           * vai gastar até o quarto de Mr.robert;
           */
        
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                String x= JOptionPane.showInputDialog(null,"Digite o comodo crise:");
                String caminho = "";
                Iterator at= (Iterator) facade.caminhoDeMenorTempo(x);
                         
                
                while(at.hasNext()){
                 
                    //Vertice y= (Vertice) at.next();
                    Object y= at.next();
                    if(y instanceof Vertice){
                        Vertice a=(Vertice)y;
                   
                        caminho+= " " + a.getNome()+ " - " ;
                    }
                    else{
                        caminho+= y;
                    }
                
                }
               
                JOptionPane.showMessageDialog(null, caminho);
               //caso o comodo não exista no grafo 
            } catch (DataNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Comodo não existe");
            }
               
            }
            
            
        
        
    }
     
      private class actionComodo implements ActionListener{

          /*
           * classe que adiciona uma action quando 
           * querer o menor numero de comodos e o caminho 
           * até chegar em Mr.roberte
           */
        
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                String x= JOptionPane.showInputDialog(null,"Digite o comodo da crise:");
                String caminho = "";
                int z=0;
                Iterator at= (Iterator) facade.caminhoMenorNo(x);
               
                while(at.hasNext()){
                 
                    Vertice y= (Vertice) at.next();
                    caminho+= " " + y.getNome()+ " - " ;
                    z++;
                   
                
                }
                if(z!=0){
                z=z-1;
                }
                
                JOptionPane.showMessageDialog(null, caminho + z );
            } 
            //caso o comodo não exista
            catch (DataNotFoundException ex) 
            {
                 JOptionPane.showMessageDialog(null,"Comodo não existe");
            }
               
        }
            
            
        
        
    }
      
         private class actionListarF implements ActionListener{

             /*
              * classe que adiciona uma action para listar os comodos que tem 
              * ou não funcionário
              */
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
                
                String caminho = "";
                Iterator at= (Iterator) facade.listarFuncionarioV();
                            
                
                while(at.hasNext()){
                 
                    //Vertice y= (Vertice) at.next();
                   Vertice a= (Vertice) at.next();
                   
                   if(a.temFuncionario()){
                   caminho+= " Comodo: " +a.getNome()+" Funcionario: " +a.getFuncionario().getNome()+"\n";
                   }
                  
                   else{
                       caminho+= " Comodo: " +a.getNome()+" Vazio " +"\n";
                   }
                }
                JOptionPane.showMessageDialog(null, caminho);
         
               
            }
            
            
        
        
    }
         
         private class actionInformacao implements ActionListener{

             /*
              * classe que adiciona uma action de informações
              */
             String caminho="";
        
             @Override
        
             public void actionPerformed(ActionEvent e) {
            
                 
                 caminho="Esse programa foi feito por Washington Pagotto Batista e Kayo Costa,\n"
                    + "email para informações wstroks@gmail.com e kayosantana94@gmail.com!!!";
                 
                 JOptionPane.showMessageDialog(null, caminho);
                 
        }
    
}
        
    public static void main(String[] args){
        new Interface();
    }
}
