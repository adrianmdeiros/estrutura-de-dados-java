package PilhaDinamica;

import Util.LeitorDeArquivo;
import java.io.IOException;
import java.util.List;


public class Pilha {
    No topo;
    int tamanho;
    
    public void init() throws IOException{
        String caminho = "/entradas/dados.txt";
        List<String> dados = LeitorDeArquivo.lerArquivo(caminho);
        
        for (int i = 0; i < dados.size(); i++){
            inserirPilha(dados.get(i));
        }
    }
    
    
  
    public int tamanho(){
        return tamanho;
    }
    
    public boolean pilhaVazia(){
        return topo == null;
    }
    
    
    public void inserirPilha(String dados){
        No no = new No();
        no.dados = dados;
        no.proximo = topo;
        topo = no;
        tamanho++;
    }
    
    public void removePilha(){
        if(!pilhaVazia()){
            No local = topo;
            topo = local.proximo;
            tamanho--;
        }
    }
    
    
    public String buscarTopo(){
        String dados = null;
        if(!pilhaVazia()){
            dados = topo.dados;
        }
       return dados;
    }
    
     public void mostrarPilha(){
        System.out.println("__________PILHA__________\n");
        String pilha = "\nQuantidade de elementos: " + tamanho + "\n";
        if(!pilhaVazia()){
            No local = topo;
              while(local != null){
              pilha += local.dados + " \n";
              local = local.proximo;
            }
        }
        System.out.println(pilha);
    }
    
}
