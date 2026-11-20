import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogo jogo = new Jogo();

        System.out.println("Jogo de Damas");
        System.out.println("Digite: linhaOrigem colOrigem linhaDestino colDestino (ex: 5 0 4 1)");
        System.out.println("Ou use: salvar jogo.dat | carregar jogo.dat | sair");

        while (true) {
            jogo.getTabuleiro().mostrar();
            System.out.println("Vez de: " + (jogo.getVez().equals("B") ? "Brancas (B)" : "Pretas (P)"));
            System.out.print("> ");
            String cmd = sc.nextLine().trim();

            if (cmd.equalsIgnoreCase("sair")) break;

            if (cmd.startsWith("salvar ")) {
                String arq = cmd.substring(7).trim();
                try {
                    Salvamento.salvar(jogo, arq);
                    System.out.println("Salvo em " + arq);
                } catch (Exception e) {
                    System.out.println("Erro ao salvar: " + e.getMessage());
                }
                continue;
            }

            if (cmd.startsWith("carregar ")) {
                String arq = cmd.substring(9).trim();
                try {
                    jogo = Salvamento.carregar(arq);
                    System.out.println("Partida carregada!");
                } catch (Exception e) {
                    System.out.println("Erro ao carregar: " + e.getMessage());
                }
                continue;
            }

            String[] p = cmd.split("\\s+");
            if (p.length == 4) {
                try {
                    int l1 = Integer.parseInt(p[0]);
                    int c1 = Integer.parseInt(p[1]);
                    int l2 = Integer.parseInt(p[2]);
                    int c2 = Integer.parseInt(p[3]);
                    if (!jogo.mover(l1, c1, l2, c2)) {
                        System.out.println("Jogada invalida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas numeros.");
                }
            } else {
                System.out.println("Comando nao reconhecido.");
            }
        }
        sc.close();
    }
}
