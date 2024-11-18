package prova2Bimestre;

public class TestesLista {
    public static void main(String[] args) {

        System.out.println("Testes com uma lista encadeada simples\n");

        ListaSimples<Integer> list = new ListaSimples<>();
        ListaSimples<Integer> list2 = new ListaSimples<>();
        int values[] = { 1, 2, 3, 4, 5};
        int values2[] = {6, 7};

        for (int i = 0; i < values.length; i++) {
            list.addLast(values[i]);
        }

        for(int i = 0; i < values2.length; i++) {
            list2.addLast(values2[i]);
        }

        list.printList();
        list.merge(list2);
        list.printList();

        System.out.println("\nTestes com uma lista encadeada circular\n");

        ListaCircular<Integer> lstC = new ListaCircular<>();
        ListaCircular<Integer> lstC2 = new ListaCircular<>();
        for(int i = 0; i < values.length; i++) {
            lstC.addLast(values[i]);
        }

        for(int i = 0; i < values2.length; i++) {
            lstC2.addLast(values2[i]);
        }

        lstC.print();
        lstC.concat(lstC2);
        lstC.print();

    }
}
