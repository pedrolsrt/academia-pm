package pm_prova2;

import java.util.ArrayList;
import java.util.List;

public class Academia {

    private final List<Atividade> atividades = new ArrayList<>();
    private final List<Plano> planos = new ArrayList<>();

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }

    public List<Atividade> getAtividades() {
        return List.copyOf(atividades);
    }

    public List<Plano> getPlanos() {
        return List.copyOf(planos);
    }

    public List<Plano> getPlanosAtivos() {
        List<Plano> ativos = new ArrayList<>();
        for (Plano p : planos) {
            if (p.getStatus() == StatusPlano.ATIVO) {
                ativos.add(p);
            }
        }
        return ativos;
    }

    public List<Certificavel> getCertificaveis() {
        List<Certificavel> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof Certificavel c) {
                lista.add(c);
            }
        }
        return lista;
    }

    public List<ControladorPresenca> getAtividadesComPresenca() {
        List<ControladorPresenca> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a instanceof ControladorPresenca c) {
                lista.add(c);
            }
        }
        return lista;
    }

    public List<ControladorPresenca> getPlanosComControleAcesso() {
        List<ControladorPresenca> lista = new ArrayList<>();
        for (Plano p : planos) {
            if (p instanceof ControladorPresenca c) {
                lista.add(c);
            }
        }
        return lista;
    }

    // Remove as atividades inativas do sistema e dos planos
    public int removerAtividadesInativas() {
        List<Atividade> inativas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getStatus() == StatusAtividade.INATIVA) {
                inativas.add(a);
            }
        }
        for (Atividade a : inativas) {
            for (Plano p : planos) {
                p.removerAtividade(a);
            }
            atividades.remove(a);
        }
        return inativas.size();
    }
}
