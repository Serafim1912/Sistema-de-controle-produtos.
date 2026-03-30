package ParaGithub.SistemaDeControleDeProdutos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            p.exibirProduto();
        }
    }

    public double calcularValorTotalEstoque() {
        double total = 0;

        for (Produto p : produtos) {
            total += p.calcularTotal();
        }

        return total;
    }

    public void removerProduto(String nome) {
        produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public int totalProdutos() {
        return produtos.size();
    }
}