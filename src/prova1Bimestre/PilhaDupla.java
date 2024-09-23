package prova1Bimestre;

import java.util.Scanner;

public class PilhaDupla {
    public static void main(String[] args){
        Pilha pinteira = new Pilha(1000);

        int teste = 42 % 2;
        System.out.println(teste);

        while(true)
        {
            int valor;
            Scanner s = new Scanner(System.in);
            valor = s.nextInt();
            if(valor == 999){
                break;
            }else{
                pinteira.push(valor);
            }
        }

        Pilha par = new Pilha(500);
        Pilha impar = new Pilha(500);
        while (!pinteira.isEmpty()){
            int topo = pinteira.pop();
            if(topo % 2 == 0){
                par.push(topo);
            }else{
                impar.push(topo);
            }
        }

        System.out.println("Total de elementos na pilha original: " + (par.sizeElements() + impar.sizeElements()));
        System.out.println(par.sizeElements());
        System.out.println(impar.sizeElements());
    }
}
