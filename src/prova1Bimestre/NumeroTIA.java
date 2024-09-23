package prova1Bimestre;

public class NumeroTIA {
    public static void main(String[] args) {
        Fila f = new Fila(10);
        Pilha p = new Pilha(10);
        int cont = 6;


        // Corrigido para adicionar elementos na pilha
        while (!p.isFull()) {
            if(cont == 0){
                p.push((6 + 1) * cont);
            }else{
                p.push((6 + 1) * cont--);
            }
        }

        while (!p.isEmpty()) {
            f.enqueue(p.pop() % 2);
        }

        f.print();

        p.push(f.dequeue());
        f.print();
        p.push(f.dequeue());
        f.print();
        p.printStack();


        f.enqueue(p.pop() % 2);

        while (!f.isEmpty()) {
            System.out.println(f.dequeue());
        }

    }
}
