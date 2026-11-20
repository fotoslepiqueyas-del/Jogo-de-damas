import java.io.Serializable;

public class Jogo implements Serializable {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private String vez = "B";

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public String getVez() {
        return vez;
    }

    public boolean mover(int l1, int c1, int l2, int c2) {
        if (!dentro(l1, c1) || !dentro(l2, c2)) return false;

        Peca p = tabuleiro.getPeca(l1, c1);
        if (p == null || !p.getCor().equals(vez)) return false;
        if (tabuleiro.getPeca(l2, c2) != null) return false;

        int dl = l2 - l1;
        int dc = c2 - c1;

        if (Math.abs(dl) != Math.abs(dc) || dl == 0) return false;

        if (Math.abs(dl) == 1) {
            if (!p.isDama()) {
                if (vez.equals("B") && dl != -1) return false;
                if (vez.equals("P") && dl != 1) return false;
            }
            tabuleiro.setPeca(l2, c2, p);
            tabuleiro.setPeca(l1, c1, null);
            promoverSePreciso(l2, p);
            trocarVez();
            return true;
        }

        if (Math.abs(dl) == 2) {
            int meioL = (l1 + l2) / 2;
            int meioC = (c1 + c2) / 2;
            Peca meio = tabuleiro.getPeca(meioL, meioC);

            if (meio == null || meio.getCor().equals(vez)) return false;
            if (!p.isDama()) {
                if (vez.equals("B") && dl != -2) return false;
                if (vez.equals("P") && dl != 2) return false;
            }

            tabuleiro.setPeca(l2, c2, p);
            tabuleiro.setPeca(l1, c1, null);
            tabuleiro.setPeca(meioL, meioC, null);
            promoverSePreciso(l2, p);
            trocarVez();
            return true;
        }

        return false;
    }

    private void promoverSePreciso(int linha, Peca p) {
        if (p.getCor().equals("B") && linha == 0) {
            p.virarDama();
        } else if (p.getCor().equals("P") && linha == 7) {
            p.virarDama();
        }
    }

    private void trocarVez() {
        vez = vez.equals("B") ? "P" : "B";
    }

    private boolean dentro(int l, int c) {
        return l >= 0 && l < 8 && c >= 0 && c < 8;
    }
}
