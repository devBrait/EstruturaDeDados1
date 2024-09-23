package prova1Bimestre;

public class PilhaExemplo {
    public static void main(String[] args) {
        Pilha p = new Pilha(10);

        p.push(5);
        p.push(3);
        System.out.println(p.pop());
        p.push(7);
        System.out.println(p.pop() );
        System.out.println(p.topo() );
        System.out.println(p.pop() );
        System.out.println(p.pop() );
        System.out.println(p.topo() );
        System.out.println(p.isEmpty() );
        p.push(9);
        p.push(7);
        p.push(3);
        p.push(5);
        System.out.println( p.sizeElements());
        System.out.println( p.pop());
        p.push(8);
        System.out.println( p.pop());
        System.out.println( p.topo());
    }
}
