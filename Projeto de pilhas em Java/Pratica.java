import java.io.*; // Importando Biblioteca
import java.util.Arrays;

public class Pratica { // Classe Principal
    
    private BufferedReader reader = new BufferedReader (new InputStreamReader (System.in)); //Declarando Atributos
    private NP[] elementos;
    private int capacidadeMaxima;
    private int ultimo;

    public void Pilha (int capacidadeMaxima) throws IOException {
        this.capacidadeMaxima = capacidadeMaxima;
        this.elementos = (NP[]) new Object [capacidadeMaxima];
        this.ultimo = -1; 
    }
}
