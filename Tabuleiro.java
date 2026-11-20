import java.io.Serializable;

public class Tabuleiro implements Serializable {
    private Peca[][] casas = new Peca[8][8];

    public Tabuleiro() {
        iniciar();
    }

    public void iniciar() {
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                casas[l][c] = null;
                if ((l + c) % 2 != 0) {
                    if (l < 3) {
                        casas[l][c] = new Peca("P");
                    } else if (l > 4) {
                        casas[l][c] = new Peca("B");
                    }
                }
            }
        }
    }

    public Peca getPeca(int l, int c) {
        return casas[l][c];
    }

    public void setPeca(int l, int c, Peca p) {
        casas[l][c] = p;
    }

    public void mostrar() {
        System.out.println("\n  0  1  2  3  4  5  6  7");
        for (int l = 0; l < 8; l++) {
            System.out.print(l + " ");
            for (int c = 0; c < 8; c++) {
                Peca p = casas[l][c];
                if (p == null) {
                    System.out.print(((l + c) % 2 != 0 ? ".  " : "   "));
                } else {
                    System.out.print(p.simbolo() + (p.isDama() ? " " : "  "));
                }
            }
            System.out.println();
        }
        System.out.println("B/P = peca branca/preta | BB/PP = dama\n");
    }
}
