public class SllTest{
    public static void main(String[] args) {
        Sll testList = new Sll();

        testList.AddNode(11);
        testList.AddNode(4);
        testList.AddNode(15);
        testList.printList();
        testList.pop();
        System.out.println("-------~!Popping!~-------");
        testList.remove(4);
        testList.printList();
    }
}