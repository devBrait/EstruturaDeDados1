package prova1Bimestre;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InvertePalavras {
    public static void main(String[] args) {
        // Leitura da frase
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String frase = scanner.nextLine();

        // Quebrar a frase em palavras
        String[] palavras = frase.split(" ");

        // Deque para armazenar os caracteres de cada palavra
        Deque<Character> deque = new ArrayDeque<>();

        // Para cada palavra, inverter os caracteres usando Deque
        for (String palavra : palavras) {
            // Inserir os caracteres da palavra no deque (enqueueRight)
            for (char c : palavra.toCharArray()) {
                deque.addLast(c); // Enqueue Right (inserir pela direita)
            }

            // Remover os caracteres na ordem inversa (dequeueRight)
            while (!deque.isEmpty()) {
                System.out.print(deque.pollLast()); // Dequeue pela direita (invertido)
            }

            // Adicionar um espaço entre as palavras
            System.out.print(" ");
        }

        scanner.close();
    }
}