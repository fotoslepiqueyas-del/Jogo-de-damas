public class Peca {
    private String cor;
    private boolean dama;

    public Peca(String cor) {
        this.cor = cor;
        this.dama = false;
    }

    public String getCor() {
        return cor;
    }

    public boolean isDama() {
        return dama;
    }

    public void virarDama() {
        this.dama = true;
    }

    public String simbolo() {
        if (dama) {
            return cor.equals("B") ? "BB" : "PP";
        }
        return cor;
    }
}
