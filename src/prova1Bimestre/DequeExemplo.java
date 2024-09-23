package prova1Bimestre;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExemplo {
    public static void main(String[] args) {
        // Criação de um deque com capacidade máxima de 6 elementos
        Deque<Integer> deque = new ArrayDeque<>(6);

        // Funções para adicionar e remover elementos, replicando o comportamento da imagem

        // enqueueRight(4)
        enqueueLeft(deque, 4);
        System.out.println(getLeft(deque));
        System.out.println(getRight(deque));
        printDeque(deque); // Estado após inserir 4 à direita

        // enqueueLeft(1)
        enqueueLeft(deque, 1);
        printDeque(deque); // Estado após inserir 1 à esquerda

        enqueueRight(deque, 2);
        printDeque(deque);

        // enqueueLeft(8)
        dequeueRight(deque);
        printDeque(deque); // Estado após inserir 8 à esquerda

        // enqueueLeft(6)
        enqueueLeft(deque, 6);
        printDeque(deque); // Estado após inserir 6 à esquerda

        // enqueueRight(5)
        enqueueLeft(deque, 5);
        printDeque(deque); // Estado após inserir 5 à direita

        // enqueueRight(3)
        enqueueRight(deque, 3);
        printDeque(deque); // Estado após inserir 3 à direita

        // dequeueLeft()
        dequeueRight(deque);
        printDeque(deque); // Estado após remover da esquerda

        // dequeueLeft()
        dequeueLeft(deque);
        printDeque(deque); // Estado após remover da esquerda
    }

    // Método para adicionar à direita
    public static void enqueueRight(Deque<Integer> deque, int value) {
        deque.addLast(value);
        System.out.println("Enqueued right: " + value);
    }

    // Método para adicionar à esquerda
    public static void enqueueLeft(Deque<Integer> deque, int value) {
        deque.addFirst(value);
        System.out.println("Enqueued left: " + value);
    }

    // Método para remover da esquerda
    public static void dequeueLeft(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            int removed = deque.removeFirst();
            System.out.println("Dequeued left: " + removed);
        } else {
            System.out.println("Deque está vazio.");
        }
    }

    public static  void dequeueRight(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            int removed = deque.removeLast();
            System.out.println("Dequeued right: " + removed);

        }else{
            System.out.println("Deque está vazio.");
        }
    }

    public static Integer getLeft(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            return deque.peekFirst();
        } else {
            System.out.println("Deque está vazio.");
            return null;
        }
    }

    // Método para obter o elemento à direita (último) sem remover
    public static Integer getRight(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            return deque.peekLast();
        } else {
            System.out.println("Deque está vazio.");
            return null;
        }
    }

    // Função para imprimir o estado atual do deque
    public static void printDeque(Deque<Integer> deque) {
        System.out.println("Deque: " + deque);
        System.out.println("qtde = " + deque.size());
        System.out.println();
    }
}
