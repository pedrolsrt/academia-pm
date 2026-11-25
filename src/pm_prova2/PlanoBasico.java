package pm_prova2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PlanoBasico extends Plano implements ControladorPresenca {

    private final Map<String, LocalDate> ultimoAcesso = new HashMap<>();

    public PlanoBasico(String nome, double valorMensal, int maxAtividades, StatusPlano status) {
        super(nome, valorMensal, maxAtividades, status);
    }

    // Registra o acesso do cliente à academia: apenas 1 por dia
    @Override
    public void registrarPresenca(String nomeCliente) {
        if (getStatus() != StatusPlano.ATIVO) {
            throw new IllegalStateException("O plano " + getNome() + " não está ativo.");
        }
        if (LocalDate.now().equals(ultimoAcesso.get(nomeCliente))) {
            throw new IllegalStateException(nomeCliente + " já utilizou o acesso de hoje.");
        }
        ultimoAcesso.put(nomeCliente, LocalDate.now());
        System.out.println("Acesso de " + nomeCliente + " registrado.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Básico] " + dadosBasicos() + " | Só individuais | 1 acesso/dia");
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return false;
    }
}
