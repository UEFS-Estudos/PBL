/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Classe responsável por geral os trilhos que serão mostrados na interface
 * @author Hugo Ribeiro e Washington Pagotto@author Hugo
 */
public class trilho {

         public JLabel trilho;
	
	 JLabel haha;
	 
	 /*
	  * Velocidade da bolinha set!!! distancia, velocidade e arrumar !! Mudar ih trilho, e os trens 
	  */
	public trilho(){
		janelaEditar();
		
		
	}
	public void janelaEditar(){
               
		trilho= new  JLabel ( new ImageIcon(getClass().getResource("Ferrovia.png")));
		
		
		trilho.setBounds(0, 0, 864, 623);
		
		
		
		
		
		
	}
	
	
       
       
       
	
	
}
    

