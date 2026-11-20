import java.io.*;

public class Salvamento {
    public static void salvar(Jogo jogo, String arquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(jogo);
        }
    }

    public static Jogo carregar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Jogo) in.readObject();
        }
    }
}
