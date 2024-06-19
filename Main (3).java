import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String FILE_DOAC = "doacao.txt";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcao;
        do {
          System.out.println("\nBem-vindo ao sistema de doações para pessoas do RS\n");
          System.out.print("Escolha uma opção: ");
            System.out.println("\n1. Fazer doação");
            System.out.println("2. Ver todas as doações");
            System.out.println("3. Como funciona o sistema de doações");
            System.out.println("0. Sair");

            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1:
                    doacao(teclado);
                    break;
                case 2:
                    verDoacoes();
                    break;
                case 3:
                    comoFunciona();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 0);
        teclado.close();
    }

    public static void doacao(Scanner teclado) {
        try (FileWriter writer = new FileWriter(FILE_DOAC, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {

            System.out.println("\nInforme o seu nome");
            String nome = teclado.nextLine();
            System.out.println("\nInforme o seu telefone com DDD");
            String celular = teclado.nextLine();

            System.out.println("\nInforme o tipo da doação");
            System.out.println("Digite 1 para doação em dinheiro ou 2 para roupas");
            int tipo = teclado.nextInt();
            teclado.nextLine(); 

            String detalhesDoacao;
            if (tipo == 1) {
                System.out.println("\nInforme o valor da doação");
                double valor = teclado.nextDouble();
                teclado.nextLine();
                detalhesDoacao = "Dinheiro: R$ " + valor;
            } else if (tipo == 2) {
                System.out.println("\nInforme a quantidade de roupas");
                int quant = teclado.nextInt();
                teclado.nextLine();
                detalhesDoacao = "Roupas: " + quant + " peça(s)";
            } else {
                System.out.println("Tipo de doação inválido.");
                return;
            }

            String doacao = nome + ", " + celular + ", " + detalhesDoacao + ".";
            out.println(doacao);

            System.out.println("Doação adicionada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar a doação: " + e.getMessage());
        }
    }

    public static void verDoacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_DOAC))) {
            String line;
            System.out.println("\nVisualizar doações:");

            int doacaoNumero = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Doação " + doacaoNumero + ": " + line);
                doacaoNumero++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao visualizar doações: " + e.getMessage());
        }
    }

    public static void comoFunciona() {
        System.out.println("\nAs funcionalidades do sistema de doações são:");
        System.out.println("1. Fazer a doação informando o seu nome e telefone. Podendo escolher entre as opções de doação em dinheiro ou roupas.");
        System.out.println("2. Ver todas as doações que foram feitas."");
        System.out.println("3. Analise de funcionalidades.");

    }
}
