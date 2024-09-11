package aula03;

public class Stack {
    private int[] data;
    private int count;

    public Stack() {
        System.out.println("Método construtor da classe Stack.");
        data = new int[18];
        count = 0;
    }

    public void push(int value) {
        if (isFull())
            return;

        data[count] = value;
        ++count;
    }

    public boolean isFull() {
        return count == data.length;
    }

    @Override
    public String toString() {
        // StringBuilder é melhor quando for concatenar
        // strings várias vezes (ex. dentro de um loop).
        StringBuilder sb = new StringBuilder();
        for (var x : data) {
            sb.append(x + ", ");
        }
        return sb.toString();

        // O código abaixo funciona, mas não é eficiente,
        // porque cria uma String temporária a cada concatenação
        // (String é imutável em Java).
//		String str = "";
//		for (int i = 0; i < data.length; ++i) {
//			str += data[i] + ", ";
//		}
//		return str;
    }
}
