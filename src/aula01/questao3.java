package aula01;

import java.util.Arrays;
import java.util.Scanner;

public class questao3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int[] valores = new int[10];

        for(int i=0; i<10; i++){
            int valor = s.nextInt();
            valores[i] = valor;
        }

        int fim = valores.length - 1;
        for(int i=0; i<5; i++){
            int temp = valores[i];
            valores[i] = valores[fim];
            valores[fim] = temp;

            fim--;
        }

        System.out.println("Array invertido: " + Arrays.toString(valores));
    }
}
