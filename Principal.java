package ParaGithub.SistemaDeControleDeProdutos;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    Produto p = new Produto();

                    System.out.print("Nome: ");
                    p.setNome(scanner.nextLine());

                    System.out.print("Preço: ");
                    p.setPreco(scanner.nextDouble());

                    System.out.print("Quantidade: ");
                    p.setQuantidade(scanner.nextInt());
                    scanner.nextLine();

                    estoque.adicionarProduto(p);
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    estoque.listarProdutos();
                    System.out.println("Total do estoque: " + estoque.calcularValorTotalEstoque());
                    break;

                case 3:
                    System.out.print("Digite o nome do produto: ");
                    String nomeBusca = scanner.nextLine();

                    Produto encontrado = estoque.buscarProduto(nomeBusca);

                    if (encontrado != null) {
                        encontrado.exibirProduto();
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Nome do produto para remover: ");
                    String nomeRemover = scanner.nextLine();

                    estoque.removerProduto(nomeRemover);
                    System.out.println("Produto removido (se existia).");
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}