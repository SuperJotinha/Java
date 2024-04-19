// Bibliotecas
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe Principal
public class Pilha {

    // Atributos da classe
    private List<Object> items;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Construtor
    public Pilha() {
        items = new ArrayList<>();
    }

    // Metodos
    public void adicionar () throws IOException {
        System.out.println("Insira um número: ");
        while (true)
        {
            try {
                int number = Integer.parseInt(reader.readLine());
                items.add(number);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inserido não é um número");
            }
        }
    }

    public Object remover() {
        System.out.println("O item removido foi: " + items.remove(items.size() - 1));
        if (!items.isEmpty()) {
            return items.remove(items.size() - 1);
        }
        System.out.println("O item removido é sempre o primeiro da pilha!");
        return null;
    }

    public void mostrarItems() {
        for (Object item : items) {
            while(true) {
                System.out.println("Os itens contidos na lista são -> " + items);
                break;
            }
        }
    }

    public void quantidadeItems() {
        System.out.println("O número de itens na pilha é: " + items.size());
    }

    public void zerarPilha() {
        items.clear();
    }

}