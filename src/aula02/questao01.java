package aula02;

import java.util.Scanner;

public class questao01 {
    static int min(int n1, int n2) {
        if (n1 < n2)
            return n1;
        else
            return n2;
    }

    static int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String v1;
        int valor1 = 0;
        for (;;) { // "forever"
            System.out.print("Digite valor1: ");
            v1 = input.nextLine();

            try {
                valor1 = Integer.parseInt(v1);
                break; // sai do loop.
            } catch(NumberFormatException e) {
                System.out.println("Não foi possível converter '" + v1 + "' para int.");
            }

        }

        System.out.println("valor1: " + valor1);

        System.out.print("Digite valor2: ");
        int valor2 = input.nextInt();
        System.out.println("valor2: " + valor2);

        int temp = valor1;
        valor1 = valor2;
        valor2 = temp;

        System.out.println();
        System.out.println("valor1: " + valor1);
        System.out.println("valor2: " + valor2);
        System.out.println("min: " + min(valor1, valor2));
        System.out.println("max: " + max(valor1, valor2));
    }
}
