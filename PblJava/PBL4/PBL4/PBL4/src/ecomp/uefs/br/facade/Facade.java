
package ecomp.uefs.br.facade;
import ecomp.uefs.br.controller.Controller;
import ecomp.uefs.br.model.exception.DataNotFoundException;
import ecomp.uefs.br.model.Vertice;
import ecomp.uefs.br.model.exception.LugarOcupadoException;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;


public class Facade {
    private Controller controller;
    

    public Facade(){
        controller = new  Controller();
    }

    public void cadastrarMansao(File arquivo) {
       controller.cadastrarMansao(arquivo);
    }

    

     public Iterator caminhoDeMenorTempo(String vertCrise) throws DataNotFoundException{
     
         return controller.caminhoDeMenorTempo(vertCrise);
    }

    public Iterator caminhoMenorNo(String vertCrise) throws DataNotFoundException {
       return controller.caminhoMenorNo(vertCrise);
    }


    public void removerFuncionarioDoComodo(String f) throws DataNotFoundException {
        controller.removerFuncionarioDoComodo(f);
    }

    


    public void adcionarFuncionarioEmComodo(String f, String vertice) throws LugarOcupadoException,DataNotFoundException {
       controller.adcionarFuncionarioEmComodo(f, vertice);

    
}

    public Iterator listarFuncionarioV(){
         return controller.listarFuncionarioV();
     }
}