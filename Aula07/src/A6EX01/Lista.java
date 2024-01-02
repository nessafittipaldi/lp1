package A6EX01;

import java.util.ArrayList;
import java.util.List;


public class Lista {
	
    private Localizacao localizacao;
    
    public Lista(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    
    List<String> produtos = new ArrayList<>();

    public String inserirProduto(String nome) {
        produtos.add(nome);
        return localizacao.getTexto("mensagemProdutoInserido");
    }

    public String inserirProdutoPosicao(int posicao, String nome) {
        try {
            produtos.add(posicao, nome);
            return localizacao.getTexto("mensagemProdutoInseridoPosicao");
        } catch (IndexOutOfBoundsException e) {
            return localizacao.getTexto("mensagemPosicaoInvalidaSubstituir");
        }
    }

    public String consultarProdutoPeloNome(String nome) {
        if (produtos.contains(nome))
            return localizacao.getTexto("mensagemProdutoExiste");
        else
            return localizacao.getTexto("mensagemProdutoNaoExiste");
    }

    public String consultarProdutoPelaPosicao(int posicao) {
        try {
            return localizacao.getTexto("mensagemProdutoNaPosicao") + produtos.get(posicao);
        } catch (IndexOutOfBoundsException e) {
            return localizacao.getTexto("mensagemPosicaoInvalidaSubstituir");
        }
    }

    public String substituirProduto(int posicao, String nome) {
        try {
            produtos.set(posicao, nome);
            return localizacao.getTexto("mensagemProdutoSubstituido");
        } catch (IndexOutOfBoundsException e) {
            return localizacao.getTexto("mensagemPosicaoInvalidaSubstituir");
        }
    }

    public String removerProdutoPeloNome(String nome) {
        produtos.remove(nome);
        return localizacao.getTexto("mensagemProdutoRemovido");
    }

    public String removerProdutoPelaPosicao(int posicao) {
        try {
            produtos.remove(posicao);
            return localizacao.getTexto("mensagemProdutoRemovido");
        } catch (IndexOutOfBoundsException e) {
            return localizacao.getTexto("mensagemPosicaoInvalidaRemover");
        }
    }
}
