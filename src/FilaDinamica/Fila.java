package FilaDinamica;
import Util.LeitorDeArquivo;
import java.io.IOException;
import java.util.List;



public class Fila {
    No inicio;
    No fim;
    int tamanho;
    
    public void init() throws IOException{
        String caminho =".\\dados.txt";
        List<String> dados = LeitorDeArquivo.lerArquivo(caminho);
        
        for (int i = 0; i < dados.size(); i++){
            inserirFila(dados.get(i));
        }
    }
    
    
    public boolean filaVazia(){
        return inicio == null;
    }
 
    public void inserirFila(String dados){
        No no = new No();
        no.dados = dados;
        no.proximo = null;
        if(fim == null){
            inicio = no;
        }else{
            fim.proximo = no;
        }
        fim = no;
        tamanho++;
    }
    
    public String removerFila(){
        No local = inicio;
        if(!filaVazia()){
            inicio = inicio.proximo;
        }
        if(filaVazia()){
            fim = null;
        }
        return local.dados;
    }
    
    public String buscarFila(){
        String dados = null;
        if(!filaVazia()){
            dados = inicio.dados;
        }
        return dados;
    }
    
    
    
    public void mostrarFila(){
        System.out.println("__________FILA__________\n");
        String fila = "\nQuantidade de elementos: " + tamanho + " \n";
        if(!filaVazia()){
            No local = inicio;
            while(local != null){
                fila += local.dados + " ";
                local = local.proximo;
            }
        }
        System.out.println(fila);
    }
    
}
