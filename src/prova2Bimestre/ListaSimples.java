package prova2Bimestre;

public class ListaSimples<T> {
    private Node<T> head;
    private int size;

    public ListaSimples() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Adicionar elemento no início da lista
    public void addFirst(T dado) {
        head = new Node<>(dado, head);
        size++;
    }

    // Adicionar elemento no final da lista
    public void addLast(T dado) {
        if (isEmpty()) {
            addFirst(dado);
            return;
        }
        Node<T> current = head;
        while (current.getProx() != null) {
            current = current.getProx();
        }
        current.setProx(new Node<>(dado, null));
        size++;
    }

    // Remover o primeiro elemento
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
        T dado = head.getDado();
        head = head.getProx();
        size--;
        return dado;
    }

    // Remover o último elemento
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
        if (size == 1) {
            return removeFirst();
        }
        Node<T> current = head;
        while (current.getProx().getProx() != null) {
            current = current.getProx();
        }
        T dado = current.getProx().getDado();
        current.setProx(null);
        size--;
        return dado;
    }

    // Buscar elemento por índice
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getProx();
        }
        return current.getDado();
    }

    // Imprimir elementos da lista
    public void printList() {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getDado() + " -> ");
            current = current.getProx();
        }
        System.out.println("null");
    }

    public void inverte() {
        if (isEmpty() || head.getProx() == null)
        {
            System.out.println("A lista está vazia ou possui apenas um elemento, nada para inverter.");
            return;
        }

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;

        while (current != null) {
            next = current.getProx(); // Salva o próximo nó
            current.setProx(prev);    // Inverte o ponteiro do nó atual
            prev = current;           // Move o `prev` para o nó atual
            current = next;           // Avança para o próximo nó
        }

        head = prev; // Atualiza o head para o novo primeiro nó
    }

    public void concat(ListaSimples<T> lst2) {
        if (lst2 == null || lst2.isEmpty()) {
            System.out.println("A lista fornecida está vazia ou é nula.");
            return;
        }

        if (this.isEmpty()) {
            // Se a lista atual estiver vazia, apenas aponta o head para o head da outra lista
            this.head = lst2.head;
        } else {
            Node<T> current = this.head;
            while (current.getProx() != null) {
                current = current.getProx();
            }
            current.setProx(lst2.head);
        }

        this.size += lst2.size;
    }

    public void merge(ListaSimples<T> lst2) {
        if (lst2 == null || lst2.isEmpty()) {
            System.out.println("A lista fornecida está vazia ou é nula.");
            return;
        }

        if (this.isEmpty()) {
            this.head = lst2.head;
            this.size = lst2.size;
            return;
        }

        // Ponteiros para navegar nas duas listas
        Node<T> currentThis = this.head;
        Node<T> currentOther = lst2.head;

        // Armazena o próximo nó de cada lista
        Node<T> nextThis, nextOther;

        // Combina as duas listas alternando os elementos
        while (currentThis != null && currentOther != null) {
            // Salva os próximos nós
            nextThis = currentThis.getProx();
            nextOther = currentOther.getProx();

            // Insere o nó da outra lista na posição correta
            currentThis.setProx(currentOther); // Liga o nó da outra lista após o nó atual da lista original
            currentOther.setProx(nextThis);   // Liga o próximo da outra lista ao restante da lista original

            // Avança para os próximos nós
            currentThis = nextThis;
            currentOther = nextOther;
        }

        // Se a lista original terminar antes, conecta os nós restantes da outra lista
        if (currentThis == null && currentOther != null) {
            // Conecta os elementos restantes da outra lista
            Node<T> last = this.head;
            while (last.getProx() != null) {
                last = last.getProx();
            }
            last.setProx(currentOther);
        }

        // Atualiza o tamanho da lista original
        this.size += lst2.size;
    }
}
