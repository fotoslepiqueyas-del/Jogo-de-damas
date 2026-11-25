# Jogo de Damas em Java

Jogo de damas para dois jogadores locais, desenvolvido em Java no Eclipse IDE e executado pelo terminal (console). O projeto foi criado para a disciplina de Programação Orientada a Objetos e aplica classes, encapsulamento, validação de regras de jogo e persistência de dados em arquivo.

**Autora:** Yasmim Lepique

## Funcionalidades implementadas

- Tabuleiro 8 × 8 com 12 peças brancas (`B`) e 12 peças pretas (`P`) nas casas escuras.
- Alternância automática de turnos (as brancas começam).
- Movimento diagonal simples de 1 casa.
- Captura de peça adversária por salto de 2 casas na diagonal, com remoção da peça capturada.
- Promoção automática a dama (`BB` ou `PP`) ao chegar à extremidade oposta do tabuleiro.
- Damas movem e capturam nas duas direções da diagonal.
- Validação de jogadas: fora do tabuleiro, movimento em linha reta, peça que não é da vez, destino ocupado e movimento para trás de pedras comuns são recusados.
- Salvamento e carregamento de partidas em arquivo binário, pelo próprio console.

## Como compilar e executar

### No Eclipse IDE (recomendado)

1. Abra o Eclipse.
2. Vá em **File > Import > General > Existing Projects into Workspace**.
3. Em *Select root directory*, escolha a pasta `jogo-de-damas` e clique em **Finish**.
4. Clique com o botão direito em `src/Main.java` e escolha **Run As > Java Application**.
5. Jogue pela aba **Console** do Eclipse.

### Pelo terminal (JDK instalado)

Na pasta raiz do projeto:

```bash
javac -d bin src/*.java
java -cp bin Main
```

## Como jogar

O programa mostra o tabuleiro e pede um comando. As linhas e colunas vão de 0 a 7 (linha 0 no topo).

| Comando | O que faz |
|---|---|
| `5 0 4 1` | Move a peça da linha 5, coluna 0 para a linha 4, coluna 1 (`linhaOrigem colOrigem linhaDestino colDestino`) |
| `salvar jogo.dat` | Salva a partida atual no arquivo informado |
| `carregar jogo.dat` | Carrega uma partida salva |
| `sair` | Encerra o programa |

Legenda do tabuleiro: `B` e `P` são pedras brancas e pretas; `BB` e `PP` são damas; `.` é casa escura vazia.

As brancas começam nas linhas 5 a 7 e avançam para cima (a linha diminui). As pretas começam nas linhas 0 a 2 e avançam para baixo (a linha aumenta).

### Exemplo de captura

```
5 2 4 3   (brancas)
2 5 3 4   (pretas)
4 3 2 5   (brancas capturam a peça preta em 3,4)
```

## Estrutura do projeto

```
jogo-de-damas/
├── .project
├── .classpath
├── README.md
└── src/
    ├── Main.java         -> loop principal e leitura dos comandos
    ├── Jogo.java         -> turnos e validação das jogadas
    ├── Tabuleiro.java    -> matriz 8x8 de peças e impressão no console
    ├── Peca.java         -> cor da peça e estado de dama
    └── Salvamento.java   -> gravação e leitura do jogo em arquivo
```

## Persistência

A classe `Salvamento` usa serialização de objetos do Java (`ObjectOutputStream` e `ObjectInputStream`) para gravar e ler o objeto `Jogo` inteiro, incluindo o tabuleiro e o turno atual. O arquivo é criado na pasta de trabalho da execução (no Eclipse, a raiz do projeto).

## Limitações

- Funciona somente em modo texto, para dois jogadores no mesmo computador.
- Não há captura obrigatória nem captura múltipla na mesma jogada.
- A dama anda 1 casa ou salta 2 (não percorre várias casas).
- Não há detecção automática de fim de jogo; a partida termina com o comando `sair`.
- Não possui interface gráfica nem modo contra o computador.
