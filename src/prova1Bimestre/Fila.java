package prova1Bimestre;

public class Fila {
        private int[] elementos;
        private int frente;
        private int tras;
        private int tamanho;

        public Fila(int capacidade) {
            elementos = new int[capacidade];
            frente = 0;
            tras = 0;
            tamanho = 0;
        }

        public boolean isFull() {
            return tamanho == elementos.length;
        }

        public boolean isEmpty() {
            return tamanho == 0;
        }

        public void enqueue(int valor) {
            if (isFull()) {
                System.out.println("Fila cheia. Não é possível enfileirar.");
                return;
            }
            elementos[tras] = valor;
            tras = (tras + 1) % elementos.length;
            tamanho++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Fila vazia. Não é possível desenfileirar.");
                return -1; // ou lançar uma exceção
            }
            int valor = elementos[frente];
            frente = (frente + 1) % elementos.length;
            tamanho--;
            return valor;
        }

        public int front() {
            if (isEmpty()) {
                System.out.println("Fila vazia.");
                return -1; // ou lançar uma exceção
            }
            return elementos[frente];
        }

        public int size() {
            return tamanho;
        }

    public void print() {
        if (isEmpty()) {
            System.out.println("Fila está vazia.");
            return;
        }

        System.out.print("Elementos da Fila: ");
        for (int i = 0; i < tamanho; i++) {
            // Calcular o índice real no array
            int index = (frente + i) % elementos.length;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }
}
