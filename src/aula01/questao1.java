package aula01;

import java.util.Scanner;

public class questao1 {
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);

       int x = s.nextInt();
       int y = s.nextInt();

       int temp = x;

       x = y;
       y = temp;

       System.out.println("Os valores ficaram como x = " + x + " e y = " + y);
    }
}
