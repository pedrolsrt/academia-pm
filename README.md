# Academia — Atividades e Planos

Atividade Avaliativa Prática 2 — Laboratório de Programação Modular (PUC Minas).

## Estrutura (pacote `pm_prova2`)
- `Atividade` (abstrata): `Musculacao`, `Natacao`, `Spinning`
- `Plano` (abstrata): `PlanoBasico`, `PlanoPremium`
- Interfaces: `Certificavel` (Natação) e `ControladorPresenca` (Natação, Spinning e Plano Básico)
- `Academia`: armazena atividades e planos e implementa as funcionalidades
- `Menu`: interação com o usuário
- `PM_Prova2`: classe principal, cria 3 atividades e 2 planos ao iniciar

## Como executar
```
javac -encoding UTF-8 -d out src/pm_prova2/*.java
java -cp out pm_prova2.PM_Prova2
```
