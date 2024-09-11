package aula03;


public class questao01 {
    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i < 50; ++i) {
            s.push(i);
            System.out.println(s);
        }
    }
}
