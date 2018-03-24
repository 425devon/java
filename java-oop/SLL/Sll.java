public class Sll{
    private Node head;
    private int size;

    public Sll(){
        this.head = null;
        this.size = 0;
    }

    public void AddNode(int value){
        Node newNode = new Node(value);
        Node current = this.head;
        if(this.head == null){
            this.head = newNode;
            this.size += 1;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void pop(){
        if(this.head == null){
            return;
        }
        Node previous = null;
        Node current = this.head;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        this.size -= 1;
    }
    public void printList(){
        if(this.head == null){
            return;
        }
        Node current = this.head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }
    public void remove(int value){
        if(this.head.value == value){
            this.head = this.head.next;
            return;
        }
        Node previous = null;
        Node current = this.head;
        while(current.value != value){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
    }
}