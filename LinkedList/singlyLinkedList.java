public class singlyLinkedList{
    int count;
    singlyNode head;
    singlyNode tail;

    public singlyLinkedList(){
        count = 0;
        head = null;
        tail = null;
    }
    public void add(int num){
        if(head == null){
            head = new singlyNode();
            head.value = num;
            head.next = null;
            tail = head;
            return;
        }
        tail.next = new singlyNode();
        tail = tail.next;
        tail.value = num;
        tail.next = null;
    }

    public void print(){
        singlyNode tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public singlyNode reverse(){
        
    }
}