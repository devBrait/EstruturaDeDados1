package prova2Bimestre;

public class ListaCircular<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListaCircular() {
        head = tail = null;
        size = 0;
    }

    // getHead(): retorna o "Node" cabeça de lista
    public Node<T> getHead() {
        return head;
    }
    // getTail(): retorna o "Node" final da lista
    public Node<T> getTail() {
        return tail;
    }

    // isEmpty(): verifica se a lista está vazia, retornando "true" se vazia
    // "false" se não vazia.
    public boolean isEmpty() {
        return head == null;
    }

    // isFull(): verifica se a lista está cheia, retornando "true" se cheia
    // "false" se não cheia.
    public boolean isFull() {
        Node<T> aux = new Node<T>(null, null);
        return aux == null;
    }

    // getSize(): retorna o tamanho da lista (total de elementos armazenados).
    public int getSize() {
        return size;
    }

    // get(int pos): retorna o "Node" que se encontra na posição "pos" da lista.
    public Node<T> get(int pos) {
        if (isEmpty()) return null;
        if (pos <= 0 || pos > size) return null;
        int cont = 1;
        Node<T> pAnda = head;
        while (cont != pos){
            pAnda = pAnda.getProx();
            cont++;
        }
        return pAnda;
    }

    // insertTail(T data): insere o "data" passado como parâmetro no final da Lista
    public boolean insertTail(T data){
        Node<T> aux;
        if (!isFull()){ // Não há espaço de memória
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Lista está vazia insere no cabeça
                aux.setProx(head);
                head = tail = aux;
            }else { // Insere no final e atualiza os ponteiros
                tail.setProx(aux);
                aux.setProx(head);
                tail = aux;
            }
            size++;
            return true;
        }
        else return false;
    };

    // addFirst(T data): insere o "data" passado como parâmetro no começo da
    public boolean addFirst(T data){
        Node<T> aux;
        if (!isFull()){
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Lista está vazia
                head = tail = aux;
                aux.setProx(head);
            }else { // Insere no começo e atualiza os ponteiros
                aux.setProx(head);
                head = aux;
                tail.setProx(head);
            }
            size++;
            return true;
        }
        else return false;
    };

    // addLast(T data): adiciona o "data" passado como parâmetro no final da
    public boolean addLast(T data){
        Node<T> aux;
        if (!isFull()){ // Não há espaço de memória
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Lista está vazia insere no cabeça
                aux.setProx(head);
                head = tail = aux;
            }else { // Insere no final e atualiza os ponteiros
                tail.setProx(aux);
                aux.setProx(head);
                tail = aux;
            }
            size++;
            return true;
        }
        else return false;
    };

    // insert(T data, int pos): insere o elemento "data" na posição "pos" passada como parâmetro
    public boolean insert(T data, int pos) {
        Node<T> aux; // Ponteiro auxiliar para o novo nó a ser inserido
        Node<T> pAnda; // Ponteiro que anda na lista ligada
        Node<T> pAnt = null;  // Ponteiro anterior ao que anda
        if (pos <= 0) return false; // Se posição inválida, não insere e retorna
        if (!isFull()){ // se há memória disponível
            aux = new Node<T>(data, null);
            if (isEmpty()){ // Insere no começo da lista
                head = tail = aux;
                // Caso a posição a iserir seja a última ou superior, insere no final
            } else if (pos >= size+1) {
                insertTail(data);
            } else {// a posição a inserir é no meio da lista
                // Procura a posição de inserção
                int cont = 1;
                pAnda = head;  // Ponteiro que anda até a posição de inserção
                // Procura a posição de inserção
                while (cont != pos){
                    pAnt = pAnda;
                    pAnda = pAnda.getProx();
                    cont++;
                }
                aux.setProx(pAnda);
                if (cont == 1) { // insere no cabeça de lista
                    head = aux;
                    tail.setProx(head);
                } else { // insere no meio
                    pAnt.setProx(aux);
                }
            }
            size++;
            return true; // inserção realizada com sucesso
        }
        else return false;
    };

    // search(T data): procura o elemento "data" dentro da lista
    public Node<T> search(T data){
        Node<T> pAnda;

        if (isEmpty()) {
            return null; // Lista vazia
        }else{
            pAnda = head;
            // procura a posição do elemento na lista
            while ((pAnda.getProx() != head) && (pAnda.getDado().equals(data) != true))
                pAnda = pAnda.getProx();
            if (pAnda.getDado().equals(data))
                return pAnda; // Retorna a referência para o No
            return null; // elemento não encontrado
        }
    }

    // print(): percorre a lista e imprime todo o seu conteúdo
    public void print(){
        Node<T> current;
        if (!isEmpty()) {
            current = head;
            while (current.getProx() != head) {
                System.out.print(current.getDado()+" -> ");
                current = current.getProx();
            }
            System.out.println(current.getDado()+" -> volta para o primeiro: "+ head.getDado());
        }
    }

    // clear(): limpa a lista ligada original, deixando-a vazia
    public void clear(){
        Node<T> pAnt, pAnda = head;

        while(pAnda.getProx() != head){
            pAnt = pAnda;  // Libera o nó
            pAnda = pAnda.getProx();
            pAnt.setProx(null);
            pAnt = null;
        }
        size = 0;
        tail = head = null;
    }

    // remove(T data): remove a primeira ocorrência do "data" na lista
    public boolean remove(T data){
        Node<T> pAnda; // Ponteiro que anda na lista ligada
        Node<T> pAnt = null; // Ponteiro anterior ao que anda na lista
        if (isEmpty()) return false; // Se lista vazia, não é possível remover
        else{  // caso haja elementos na lista
            pAnda = head;
            // procura a posição do elemento na lista
            int contador = 1;
            while ((contador != size) && (pAnda.getDado().equals(data) != true)){
                pAnt = pAnda;
                pAnda = pAnda.getProx();
                contador++;
            }
            if ((contador == size) && (pAnda.getDado().equals(data) != true))
                return false; // Se não encontrou o elemento
            else { // Se elemento foi encontrado
                // se tem somente um elemento na lista
                if (size == 1) {
                    head = tail = null;
                    // Verifica se está como cabeça da lista e remove
                    // e tem mais de um elemento
                } else if ((head == pAnda)) {
                    head = pAnda.getProx();
                    tail.setProx(head);
                } else { // remove elemento do meio/fim da lista
                    // Se o elemento estiver no fim
                    if (pAnda == tail)
                        tail = pAnt; // Atualiza o fim
                    pAnt.setProx(pAnda.getProx());
                }
                pAnda.setProx(null);
                pAnda = pAnt = null;
                size--;
                return true;    // remoção realizado como sucesso
            }
        }
    }

    // pollFirst(): remove e retorna o primeiro elemento da lista
    public T pollFirst(){
        if (isEmpty()) return null; // Se lista vazia, não é possível remover
        else{  // Remove primeiro elemento da lista e retorna o dado
            Node<T> pAux = head;
            if (size == 1) { // caso haja somente um elemento na lista
                head = tail = null;
            } else { // há mais de um elemento na lista
                head = head.getProx();
                tail.setProx(head);
            }
            size--;
            return pAux.getDado();
        }
    }

    // pollLast(): remove e retorna o último elemento da lista
    public T pollLast(){
        if (isEmpty()) return null; // Se lista vazia, não é possível remover
        else{
            Node<T> pAnda = head, pAnt = null;
            // procura o elemento final da lista
            int contador = 1;
            while ((contador != size)){
                pAnt = pAnda;
                pAnda = pAnda.getProx();
                contador++;
            }  // Remove o elemento e retorna o dado
            if (size == 1) {
                head = tail = null;
            } else {
                tail = pAnt;
                pAnt.setProx(pAnda.getProx());
            }
            size--;
            return pAnda.getDado();
        }
    }

    public void inverte() {
        if (isEmpty() || head.getProx() == tail) {
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next = null;
        int count = 0;
        int listSize = getSize(); // Assumindo que você tem um metodo size()

        while (count < listSize) {
            next = current.getProx(); // Salva o próximo nó
            current.setProx(prev); // Inverte o ponteiro do nó atual para o nó anterior
            prev = current; // Move o 'prev' para o nó atual
            current = next; // Move o 'current' para o próximo nó
            count++;
        }

        Node<T> temp = head;
        head = tail;
        tail = temp;

        // Update the circular reference
        tail.setProx(head);
    }

    public void concat(ListaCircular<T> lst2)
    {
        if (lst2 == null || lst2.isEmpty()) {
            return;
        }

        if (this.isEmpty()) {
            // Se a lista atual estiver vazia, apenas aponta o head para o head da outra lista
            this.head = lst2.head;
            this.tail = lst2.tail;
            this.tail.setProx(this.head);
        } else {
            // Conecta o último nó da lista atual ao primeiro nó da segunda lista
            this.tail.setProx(lst2.head);

            // Atualiza o tail para ser o tail da segunda lista
            this.tail = lst2.tail;

            // Garante que o novo tail aponte para o head da lista
            this.tail.setProx(this.head);
        }

        this.size += lst2.size;
    }
}
