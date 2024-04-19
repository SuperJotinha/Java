import java.util.Arrays;

public class Pilha<T> implements Comparable<Pilha<T>>, Cloneable {
    private T[] elementos;
    private int ultimo;
    private int capacidadeMaxima;

    // Questão 3: Construtor da classe Pilha
    public Pilha(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.elementos = (T[]) new Object[capacidadeMaxima];
        this.ultimo = -1;   
    }

    // Questão 4: Método para armazenar um item na pilha
    public void guardeItem(T valor) throws Exception {
        if (isCheia()) {
            redimensioneSe(capacidadeMaxima * 2);
        }
        ultimo++;
        elementos[ultimo] = valor;
    }

    // Questão 5: Método para obter o item no topo da pilha
    public T getItem() throws Exception {
        if (isVazia()) {
            throw new Exception("A pilha está vazia. Não é possível obter item.");
        }
        return elementos[ultimo];
    }

    // Questão 6: Método para remover o item do topo da pilha
    public void removeItem() throws Exception {
        if (isVazia()) {
            throw new Exception("A pilha está vazia. Não é possível remover item.");
        }
        elementos[ultimo] = null;
        ultimo--;

        if (ultimo < capacidadeMaxima / 4) {
            redimensioneSe(capacidadeMaxima / 2);
        }
    }

    // Questão 7: Método para obter a quantidade de itens na pilha
    public int getQuantidade() {
        return ultimo + 1;
    }

    // Questão 8: Método para verificar se a pilha está vazia
    public boolean isVazia() {
        return ultimo == -1;
    }

    // Questão 9: Método para verificar se a pilha está cheia
    public boolean isCheia() {
        return ultimo == capacidadeMaxima - 1;
    }

    // Questão 10: Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= ultimo; i++) {
            sb.append(elementos[i]);
            if (i < ultimo) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Questão 10: Método hashCode
    @Override
    public int hashCode() {
        return Arrays.hashCode(elementos);
    }

    // Questão 10: Método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pilha)) {
            return false;
        }
        Pilha<?> outraPilha = (Pilha<?>) obj;
        return Arrays.equals(elementos, outraPilha.elementos) && ultimo == outraPilha.ultimo;
    }

    // Questão 10: Método compareTo
    @Override
    public int compareTo(Pilha<T> outraPilha) {
        // Você precisa decidir como comparar duas pilhas. Por exemplo, pode ser
        // com base na quantidade de elementos ou em algum critério específico.
        // Este é um exemplo simples com base na quantidade de elementos.
        return Integer.compare(getQuantidade(), outraPilha.getQuantidade());
    }

    // Questão 10: Método clone
    @Override
    public Pilha<T> clone() throws CloneNotSupportedException {
        Pilha<T> novaPilha = new Pilha<>(capacidadeMaxima);
        novaPilha.elementos = Arrays.copyOf(elementos, elementos.length);
        novaPilha.ultimo = ultimo;
        return novaPilha;
    }

    // Método privado para redimensionar o vetor interno
    private void redimensioneSe(int novaCapacidade) throws Exception {
        if (novaCapacidade < 1) {
            throw new Exception("Tamanho de capacidade inválido.");
        }

        T[] novoArray = (T[]) new Object[novaCapacidade];
        for (int i = 0; i <= ultimo; i++) {
            novoArray[i] = elementos[i];
        }

        elementos = novoArray;
        capacidadeMaxima = novaCapacidade;
    }
}