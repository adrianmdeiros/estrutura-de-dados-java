package ArvoreBinaria;
import java.io.IOException;
import java.util.List;
import Util.LeitorDeArquivo;

public class Arvore {
    private No raiz;
    
    public Arvore(){
        raiz = null;
    }
    
    public void init() throws IOException{
        String caminho = "/entradas/dados.txt";
        List<String> dados = LeitorDeArquivo.lerArquivo(caminho);
       
        for (int i = 0; i < dados.size(); i++) {
            inserirElemento(Integer.parseInt(dados.get(i)));        
        }
    }
    

    public void inserirElemento(long valor){
        No novo = new No();
        novo.elemento = valor;
        novo.direita = null;
        novo.esquerda = null;
        
        if(raiz == null)
            raiz = novo;
        else{
            No atual = raiz;
            No anterior;
            while(true){
                anterior = atual;
                if(valor <= atual.elemento){
                    atual = atual.esquerda;
                    if(atual == null){
                        anterior.esquerda = novo;
                        return;
                    }
                } // fim da condição de ir para esquerda
                else { 
                    atual = atual.direita; 
                    if(atual == null){
                        anterior.direita = novo;
                        return;
                    }
                } // fim da condição de ir para direita
            } // fim do while
        } 
    } 

    public No buscarElemento(long valor) {
        if (raiz == null) 
            return null; 
        No atual = raiz;  
        while (atual.elemento != valor) { 
            if(valor < atual.elemento ) 
                atual = atual.esquerda; 
            else 
                atual = atual.direita; 
            if (atual == null)
                System.out.println("Elemento não encontrado.");
                return null; 
        }
        return atual;
    }
    
    
    public boolean removerElemento(long valor) {
        if (raiz == null)
            return false; 

        No atual = raiz;
        No pai = raiz;
        boolean filho_esquerda = true;

            while (atual.elemento != valor) { 
              pai = atual;
              if(valor < atual.elemento ) { 
                atual = atual.esquerda;
                filho_esquerda = true; 
              }
              else { 
                atual = atual.direita; 
                filho_esquerda = false; 
              }
              if (atual == null)
                    System.out.println("Elemento não encontrado");
                return false; 
            } 
            // Se não possui nenhum filho (folha)
            if (atual.esquerda == null && atual.direita == null) {
              if (atual == raiz )
                  raiz = null; 
              else if (filho_esquerda)
                pai.esquerda = null; 
              else
                pai.direita = null; 
            }

            // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
            else if (atual.direita == null) {
                if (atual == raiz)
                   raiz = atual.esquerda; 
                else if (filho_esquerda)
                   pai.esquerda = atual.esquerda; 
                else
                   pai.direita = atual.esquerda; 
            }

            // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda   
            else if (atual.esquerda == null) {
                if (atual == raiz)
                    raiz = atual.direita; 
                else if (filho_esquerda)
                    pai.esquerda = atual.direita; 
                else
                    pai.direita = atual.direita; 
            }

            // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
            else {
              No sucessor = noSucessor(atual);
                if (atual == raiz)
                    raiz = sucessor; 
                else if(filho_esquerda)
                    pai.esquerda = sucessor;
                else 
                    pai.direita = sucessor; 
                sucessor.esquerda = atual.esquerda; 
            }
        return true;
    }
    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
    public No noSucessor(No apagar) { // O parametro é a referencia para o No que deseja-se apagar
        No paiSucessor = apagar;
        No sucessor = apagar;
        No atual = apagar.direita; // vai para a subarvore a direita

        while (atual != null) { 
          paiSucessor = sucessor;
          sucessor = atual;
          atual = atual.esquerda; 
        } 

        if (sucessor != apagar.direita) { 
          paiSucessor.esquerda = sucessor.direita; 
          sucessor.direita = apagar.direita;                    
        }
        return sucessor;
    }
  
    public void emOrdem(No atual){
        if(atual != null) {
           emOrdem(atual.esquerda);
           System.out.print(atual.elemento + " ");
           emOrdem(atual.direita);
        }
    }
    
    public void preOrdem(No atual){
        if(atual != null) {
            System.out.print(atual.elemento + " ");
            preOrdem(atual.esquerda);
            preOrdem(atual.direita);
        }
    }
    
    public void posOrdem(No atual){
        if(atual != null){
            posOrdem(atual.esquerda);
            posOrdem(atual.direita);
            System.out.print(atual.elemento + " ");
        }
    }
    
    public int alturaArvore(No atual){
        if(atual == null || (atual.esquerda == null && atual.direita == null))
            return 0;
        else {
            if (alturaArvore(atual.esquerda) > alturaArvore(atual.direita))
                return ( 1 + alturaArvore(atual.esquerda) );
            else
                return ( 1 + alturaArvore(atual.direita) );
        }
    }
    
    public int quantidadeFolhas(No atual){
        if(atual == null)
            return 0;
        if(atual.esquerda == null && atual.direita == null)
            return 1;
        return quantidadeFolhas(atual.esquerda) + quantidadeFolhas(atual.direita);
    } 
    
    public int quantidadeNos(No atual){
        if(atual == null)
            return 0;
        else
            return ( 1 + quantidadeNos(atual.esquerda) + quantidadeNos(atual.direita));
    }
    
    public void mostrarArvore(){
        System.out.println("__________ÁRVORE__________\n");
        System.out.println("\n\nEm ordem:\n");
        emOrdem(raiz);
        System.out.println("\n\nPre-ordem:\n");
        preOrdem(raiz);
        System.out.println("\n\nPos-ordem:\n");
        posOrdem(raiz);
        System.out.println("\n\nAltura:\n" + alturaArvore(raiz));
        System.out.println("\n\nFolhas:\n" + quantidadeFolhas(raiz));
        System.out.println("\n\nNos:\n" + quantidadeNos(raiz));
    }
    
}
