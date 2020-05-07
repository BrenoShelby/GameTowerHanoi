package tad;

public class Stack {

    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node novoNo = new Node(data); //creates a node
        novoNo.next = top; //creates the next from the new node pointing to the top
        top = novoNo; //creates the top to pointing to the new node 
    }

    public int pop() {
        if (!isEmpty()) {
            Node temp = top; //retrieves the top element 
            top = top.next; //displaces the top to down
            return temp.data; //return the top element
        } else {
            throw new RuntimeException("==> Pilha Vazia!");
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            throw new RuntimeException("==> Pilha Vazia!");
        }
    }

    public int size() {
        Node current = top; //current starts with top
        int quantity = 0;
        while (current != null) { //while current don't be null
            quantity++; //quantity + 1
            current = current.next; //advance to the next node
        }
        return quantity;
    }

    @Override
    public String toString() {
        Node current = top; //current starts with the top
        StringBuilder saida = new StringBuilder();
        while (current != null) { //while current don't be null
            saida.append(current).append("\n");
            current = current.next; //advance to the next node
        }
        
        //if the stack isn't empty returns 0 as String
        if(isEmpty())
            return "0\n";
        
        return saida.toString();
    }
}
