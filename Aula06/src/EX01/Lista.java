package EX01;

import java.util.ArrayList;
import java.util.List;


public class Lista {
	List<String> produtos = new ArrayList<>();
	

    public String inserirProduto(String nome) {
        produtos.add(nome);
        return "Produto inserido.\n";
        
    }

    public String inserirProdutoPosicao(int posicao, String nome) {
        produtos.add(posicao, nome);
        return "Produto inserido na posição.\n";
    }

    public String consultarProdutoPeloNome(String nome) {
        if (produtos.contains(nome))
        	return "Esse produto existe";
        else
        	return "Esse produto não existe";
    }

    public String consultarProdutoPelaPosicao(int posicao) {
        return "O produto que está nesse posição é: " + produtos.get(posicao);
    }

    public String substituirProduto(int posicao, String nome) {
        if (posicao >= 0 && posicao < produtos.size()) {
            produtos.set(posicao, nome);
        	return "Produto substituído\n";
        } else {
            return "Psoição inválida. Não foi possível substituir o produto.\n";
        }
    }

    public String removerProdutoPeloNome(String nome) {
        produtos.remove(nome);
        return "Produto removido.\n";
    }

    public String removerProdutoPelaPosicao(int posicao) {
        if (posicao >= 0 && posicao < produtos.size()) {
            produtos.remove(posicao);
            return "Produto Removido.\n";
        } else {
            return "Posição inválida. Não foi possivel remover o produto\n";
        }
    }

}
