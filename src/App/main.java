package App;
import FilaDinamica.Fila;
import PilhaDinamica.Pilha;
import ArvoreBinaria.Arvore;
import ListaEncadeadaDupla.Lista;
import java.io.IOException;

public class main{
   
    public static void main(String[]args) throws IOException{
        
        Fila fila = new Fila();
        Arvore arvore = new Arvore();
        Lista lista = new Lista();
        Pilha pilha = new Pilha();
        
        lista.init();
        pilha.init();
        fila.init();
        arvore.init();
        
        int valor = 0;
        String comandos = "";
        
        
        for(String entrada : args){
            if(entrada.matches("-?\\d+")){
                valor = Integer.parseInt(entrada);
            }else{
                comandos += entrada;
            }
        }
        
        
        switch (comandos) {
            case "arvoremostrar" -> arvore.mostrarArvore();
            case "arvorebuscar" -> System.out.println("Resultado da busca: \n" + arvore.buscarElemento(valor));            
            case "arvoredeletar"-> {
                arvore.removerElemento(valor);
                arvore.mostrarArvore();
            }
            case "pilhamostrar" -> pilha.mostrarPilha();
            case "pilhabuscar" -> System.out.println("Elemento do topo da pilha: \n" + pilha.buscarTopo());
            case "pilhadeletar" -> {
                pilha.removePilha();
                pilha.mostrarPilha();
            }
            case "filamostrar" -> fila.mostrarFila();
            case "filabuscar" -> System.out.println("Resultado da busca: \n" + fila.buscarFila());
            case "filadeletar" -> {
                fila.removerFila();
                fila.mostrarFila();
            }
            case "listamostrar" -> lista.mostrarLista();
            case "listabuscar" -> System.out.println("Resultado da busca: \n" + lista.buscaLista(valor));
            case "listadeletarinicio" -> {
                lista.removerInicio();
                lista.mostrarLista();
            }
            case "listadeletarmeio" -> {
                lista.removerMeio(valor);
                lista.mostrarLista();
            }
            case "listadeletarfinal" -> {
                lista.removerFim();
                lista.mostrarLista();
            }
            default -> System.out.println("Comando incorreto. Tente novamente.");
        }
        
            
        
        
        
        
        
        
        
        
        
        
        
    }
}
