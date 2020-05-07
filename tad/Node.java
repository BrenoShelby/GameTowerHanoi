package tad;


public class Node {
    //atributes
    int data;
    Node next; //auto reference
    
    public Node(int data){
        this.data = data;
        next = null; //reference null
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
