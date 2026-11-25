package pm_prova2;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Academia academia;
    private final Scanner scanner;

    public Menu(Academia academia, Scanner scanner) {
        this.academia = academia;
        this.scanner = scanner;
    }

    public void executar() {
        int opcao;
        do {
            System.out.println("\n===== ACADEMIA =====");
            System.out.println("1 - Associar atividade a um plano");
            System.out.println("2 - Exibir atividades");
            System.out.println("3 - Exibir planos");
            System.out.println("4 - Exibir planos ativos");
            System.out.println("5 - Emitir certificado");
            System.out.println("6 - Registrar presença em atividade");
            System.out.println("7 - Remover atividades inativas");
            System.out.println("8 - Registrar acesso de cliente (plano básico)");
            System.out.println("9 - Alterar status de atividade");
            System.out.println("10 - Alterar status de plano");
            System.out.println("0 - Sair");
            opcao = lerInteiro("Opção: ");
            try {
                executarOpcao(opcao);
            } catch (IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> {
                Plano plano = escolher(academia.getPlanos());
                Atividade atividade = escolher(academia.getAtividades());
                plano.associarAtividade(atividade);
                System.out.println("Atividade associada com sucesso!");
            }
            case 2 -> academia.getAtividades().forEach(Atividade::exibirDetalhes);
            case 3 -> academia.getPlanos().forEach(Plano::exibirDetalhes);
            case 4 -> academia.getPlanosAtivos().forEach(Plano::exibirDetalhes);
            case 5 -> escolher(academia.getCertificaveis()).emitirCertificado(lerTexto("Nome do participante: "));
            case 6 -> escolher(academia.getAtividadesComPresenca()).registrarPresenca(lerTexto("Nome do participante: "));
            case 7 -> System.out.println(academia.removerAtividadesInativas() + " atividade(s) removida(s).");
            case 8 -> escolher(academia.getPlanosComControleAcesso()).registrarPresenca(lerTexto("Nome do cliente: "));
            case 9 -> {
                escolher(academia.getAtividades()).setStatus(escolher(List.of(StatusAtividade.values())));
                System.out.println("Status alterado.");
            }
            case 10 -> {
                escolher(academia.getPlanos()).setStatus(escolher(List.of(StatusPlano.values())));
                System.out.println("Status alterado.");
            }
            case 0 -> System.out.println("Até logo!");
            default -> System.out.println("Opção inválida.");
        }
    }

    // Lista os itens numerados e retorna o escolhido
    private <T> T escolher(List<T> itens) {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Nenhum item disponível.");
        }
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + descrever(itens.get(i)));
        }
        int opcao;
        do {
            opcao = lerInteiro("Escolha: ");
        } while (opcao < 1 || opcao > itens.size());
        return itens.get(opcao - 1);
    }

    private String descrever(Object item) {
        if (item instanceof Atividade a) {
            return a.getNome() + " (" + a.getStatus() + ")";
        }
        if (item instanceof Plano p) {
            return p.getNome() + " (" + p.getStatus() + ")";
        }
        return item.toString();
    }

    private String lerTexto(String mensagem) {
        String texto;
        do {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
