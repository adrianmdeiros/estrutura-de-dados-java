package ListaEncadeadaDupla;


public class Lista {
    No inicio;
    No fim;
    int tamanho;
    
    public int tamanho(){
        return tamanho;
    }
    
    
    public boolean listaVazia(){
        return inicio == null;
    }
    
    
    
    public void inserirInicio(String dados){
        No no = new No();
        no.dados = dados;
        no.anterior = null;
        no.proximo = inicio;
        
        if(inicio != null){
            inicio.anterior = no;
        }
        inicio = no;
        if(tamanho == 0){
            fim = inicio;
        }
        tamanho++;
    }
    
    public String removerInicio(){
        if(inicio == null){
            return null;
        }
        
        String dados = inicio.dados;
        inicio = inicio.proximo;
        
        if(inicio != null){
            inicio.anterior = null;
        } else {
            fim = null;
        }
        tamanho--;
        return dados;
    }
    
    public void inserirFim(String dados){
        No no = new No();
        no.dados = dados;
        no.proximo = null;
        no.anterior = fim;
        
        if(fim != null){
            fim.proximo = no;
        }
        fim = no;
        if(tamanho == 0){
            inicio = fim;
        }
        tamanho++;
 
    }
    
    public String removerFim(){
        if(fim == null){
            return null;
        }
        String dados = fim.dados;
        
        fim = fim.anterior;
        if(fim != null){
            fim.proximo = null;
        } else {
            inicio = null;
        }
        tamanho--;
        return dados;
    }
    
   public void inserirMeio(int indice, String dados){
       if(indice <= 0){
           inserirInicio(dados);
       } else if(indice >= tamanho){
           inserirFim(dados);
       } else {
           No local = inicio;
           for(int i = 0; i < indice-1; i++){
               local = local.proximo;
           }
           No no = new No();
           no.dados = dados;
           no.anterior = local;
           no.proximo = local.proximo;
           local.proximo = no;
           no.proximo.anterior = no;
       }
       tamanho++;
   }
   
   public String removerMeio(int indice){
       if(indice < 0 || indice >= tamanho || inicio == null){
           return null;
       } else if(indice == 0){
           return removerInicio();
       } else if(indice == tamanho-1){
           return removerFim();
       }
       No local = inicio;
       for(int i = 0; i < indice; i++){
           local = local.proximo;
       }
       local.anterior.proximo = local.proximo;
       local.proximo.anterior = local.anterior;
       tamanho--;
       return local.dados;
   }
   
   /*public void inserirOrdenado(String dados){
       No no = new No();
       no.dados = dados;
       if(inicio == null){
           no.proximo = null;
           inicio = no;
           fim = no;
       }
       No anterior = inicio;
       No atual = inicio;
       while(atual != fim && atual.dados.matricula < dados.matricula){
           anterior = atual;
           atual = atual.proximo;
       }
       if(atual == inicio){
           no.proximo = inicio;
           fim = no;
       }else{
           no.proximo = atual;
           anterior.proximo = no;
       }
   }
   */
   
   public String buscaLista(int posicao){
       if(posicao <= 0){
           return null;
       }
        No local = inicio;
        int i = 1;
        while(local != null && i < posicao){
            local = local.proximo;
            i++;
        }
        if(local == null){
           return null;
        }
       return local.dados;
   }
   
   
   
   public void mostrarLista(){
      String lista = "Quantidade de elementos: " + tamanho + "\n";
      if(!listaVazia()){ 
        No local = inicio;
        while(local != null){
           lista += local.dados + " ";
           local = local.proximo;
        }
      }
       System.out.println(lista);
   }

    
   
}
