package FilaDinamica;



public class Fila {
    No inicio;
    No fim;
    int tamanho;
    
    
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
    
    public String consultarFila(){
        String dados = null;
        if(!filaVazia()){
            dados = inicio.dados;
        }
        return dados;
    }
    
    
    
    public void mostraFila(){
        String fila = " TAMANHO: " + tamanho + " \n";
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
