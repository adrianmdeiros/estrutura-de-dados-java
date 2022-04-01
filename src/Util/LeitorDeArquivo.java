package Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo{

    public static List<String> lerArquivo(String caminho) throws IOException {
        
        InputStream entrada = LeitorDeArquivo.class.getResourceAsStream(caminho);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
    
        List<String> linhasArquivo = new ArrayList<>();
        String linha;
        
        while((linha = buffer.readLine()) != null){
            linhasArquivo.add(linha);
        }
        buffer.close();
        
     return linhasArquivo;
    }
    
}