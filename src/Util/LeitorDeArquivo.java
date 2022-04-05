package Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorDeArquivo{

    public static List<String> lerArquivo(String caminho) throws IOException {
        
        //InputStream entrada = LeitorDeArquivo.class.getResourceAsStream(caminho);
        //BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
       
        Scanner scanner = new Scanner(new FileReader(caminho)).useDelimiter("\\n");
        List<String> linhasArquivo = new ArrayList<>();
      
        
        while(scanner.hasNext()){
            linhasArquivo.add(scanner.next());
        }
        
        
       
        
        
     return linhasArquivo;
    }
}