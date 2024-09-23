package prova1Bimestre;

public class Pilha {
    private int[] elementos;
    private int topo;
    private int capacidade;

    // Construtor para inicializar a pilha com uma capacidade definida
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        topo = -1; // Pilha vazia, índice inicial é -1
    }

    // Adiciona um elemento no topo da pilha (push)
    public void push(int valor) {
        if (isFull()) {
            System.out.println("Pilha está cheia, não é possível adicionar o valor: " + valor);
            return;
        }
        elementos[++topo] = valor; // Incrementa o topo e adiciona o valor
    }

    // Remove e retorna o elemento no topo da pilha (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha está vazia, não é possível remover elementos.");
            return -1; // Retorna um valor inválido para indicar falha
        }
        int valorRemovido = elementos[topo--]; // Retorna o elemento e decrementa o topo
        return valorRemovido;
    }

    // Retorna o elemento no topo da pilha sem remover (peek)
    public int topo() {
        if (isEmpty()) {
            System.out.println("Pilha está vazia.");
            return -1;
        }
        return elementos[topo];
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    // Exibe os elementos da pilha
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Pilha está vazia.");
            return;
        }
        System.out.print("Elementos da Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    // Retorna o tamanho atual da pilha
    public int sizeElements() {
        return topo + 1;
    }
}
