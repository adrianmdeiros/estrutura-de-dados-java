package PilhaDinamica;


public class Pilha {
    No topo;
    int tamanho;
    
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
    
    
    public String consultarTopo(){
        String dados = null;
        if(!pilhaVazia()){
            dados = topo.dados;
        }
       return dados;
    }
    
     public void mostraPilha(){
        String pilha = "Quantidade de elementos: " + tamanho + "\n";
        if(!pilhaVazia()){
            No local = topo;
              while(local != null){
              pilha += local.dados + " ";
              local = local.proximo;
            }
        }
        System.out.println(pilha);
    }
    
}
