package pm_prova2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Natacao extends Atividade implements Certificavel, ControladorPresenca {

    private final double profundidadePiscina;
    private final List<String> presencas = new ArrayList<>();

    public Natacao(String nome, String horario, int duracaoAula, int maxParticipantes,
                   double valorMensal, StatusAtividade status, double profundidadePiscina) {
        super(nome, horario, duracaoAula, maxParticipantes, valorMensal, status);
        this.profundidadePiscina = profundidadePiscina;
    }

    @Override
    public void registrarPresenca(String nomeParticipante) {
        if (getStatus() == StatusAtividade.INATIVA) {
            throw new IllegalStateException("A atividade " + getNome() + " está inativa.");
        }
        presencas.add(nomeParticipante);
        System.out.println("Presença de " + nomeParticipante + " registrada em " + getNome() + ".");
    }

    @Override
    public void emitirCertificado(String nomeParticipante) {
        int total = Collections.frequency(presencas, nomeParticipante);
        if (total == 0) {
            throw new IllegalStateException(nomeParticipante + " não possui presença em " + getNome() + ".");
        }
        System.out.println("===== CERTIFICADO =====");
        System.out.println("Certificamos que " + nomeParticipante + " participou da turma de "
                + getNome() + " com " + total + " presença(s).");
        System.out.println("=======================");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Natação] " + dadosBasicos() + " | Profundidade: " + profundidadePiscina
                + " m | Presenças: " + presencas.size());
    }

    @Override
    public boolean atividadeColetiva() {
        return true;
    }
}
