package pm_prova2;

public class PlanoPremium extends Plano {

    public PlanoPremium(String nome, double valorMensal, int maxAtividades, StatusPlano status) {
        super(nome, valorMensal, maxAtividades, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[Premium] " + dadosBasicos() + " | Qualquer atividade | Acesso ilimitado");
    }

    @Override
    public boolean permiteAtividadeColetiva() {
        return true;
    }
}
