package prova1Bimestre;

import java.util.Scanner;

public class MultiploTres {
    public static void main(String[] args) {
        Pilha p = new Pilha(30);
        int n, cont = 0;
        char resp;
        Scanner s = new Scanner(System.in);
        do {// leitura dos números
            System.out.print("Deseja fornecer um nro (S/N): ");
            resp = s.next().toUpperCase().charAt(0);
            if (resp == 'S') {
                System.out.print("Forneça o " + ++cont + "o nro: ");
                n = s.nextInt();
                p.push(n);
            }
        } while (resp == 'S');

        Pilha p2 = new Pilha(100);
        while (!p.isEmpty()) {
            int topo = p.pop();
            if(topo % 3 != 0){
                p2.push(topo);
            }
        }

        while (!p2.isEmpty()) {
            p.push(p2.pop());
        }

        System.out.println("Elementos da pilha (sem os múltiplos de 3):");
        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }


    }
}
