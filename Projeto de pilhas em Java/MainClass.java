// Bibliotecas
import java.io.IOException;

// Classe principal
public class MainClass {
   
    // Metodos
    public static void main(String[] args) throws IOException {
        System.out.println("Programa de pilhas! (Estudos Java)");
        // Instanciando a classe
        
        // Objetos
        Pilha pilha = new Pilha();
        pilha.zerarPilha();
        
        // Chamando metodos
        System.out.println("A pilha foi zerada!");
        pilha.adicionar();
        pilha.adicionar();
        pilha.adicionar();
        pilha.mostrarItems();
        pilha.quantidadeItems();
        pilha.remover();
        pilha.mostrarItems();

    }
}