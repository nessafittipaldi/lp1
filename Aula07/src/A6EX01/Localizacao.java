package A6EX01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Localizacao {
    private Map<String, String> textos;

    public Localizacao() {
        textos = new HashMap<>();
    }

    public void selecionarIdioma(String idioma) {
        try {
            String arquivo = "./src/A6EX01/localizacao-" + idioma + ".txt";
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();
                    textos.put(chave, valor);
                }
            }
            
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de localização.");
        }
    }

    public String getTexto(String chave) {
        return textos.getOrDefault(chave, "Texto não encontrado");
    }
}


    