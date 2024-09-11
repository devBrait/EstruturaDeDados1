package aula01;

import java.util.Scanner;

public class questao2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        char letra = s.next().toUpperCase().charAt(0);

        char[] vogais = {'A', 'E', 'I', 'O', 'U'};

        // Array de consoantes
        char[] consoantes = {
                'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
        };

        for(char c: vogais){
            if(c == letra){
                System.out.println("É uma vogal");
                return;
            }
        }

        for(char c: consoantes){
            if(c == letra){
                System.out.println("É uma consoante");
                return;
            }
        }
    }
}
