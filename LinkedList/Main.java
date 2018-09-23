public class Main{
    public static void main(String[] args) {
        singlyLinkedList linkedList = new singlyLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.print();
        System.out.println();

        linkedList.reverse();             
        linkedList.print();

        linkedList.add(5);
        linkedList.add(6);
        System.out.println();
        linkedList.print();

    }
}