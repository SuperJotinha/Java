// Bibliotecas
import java.io.*;

// Classe principal
public class Keyboard {
    // Atributos
    private BufferedReader reader;

    // Construtor
    public Keyboard() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // Metodos
    public int getNumberInput() throws IOException {
        System.out.print("Insira um número: ");
        while (true) {
            try {
                int number = Integer.parseInt(reader.readLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Valor inserido não é um número");
            }
        }
    }
}