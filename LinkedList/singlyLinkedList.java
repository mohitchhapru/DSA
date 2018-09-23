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

            count += 1;
            return;
        }
        tail.next = new singlyNode();
        tail = tail.next;
        tail.value = num;
        tail.next = null;
        count += 1;
        return;
    }

    public void print(){
        singlyNode tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void reverse(){
        if(count<=1)  // for Linked list with 0 or 1 count.
            return;
        
        singlyNode tailOfReverse = head;
        singlyNode next = head.next;
        singlyNode futureNode = next.next;
     
        tailOfReverse.next = null;
        next.next = tailOfReverse;
        singlyNode headOfReverse = next;
        next = futureNode;
        futureNode = futureNode.next;

        while(futureNode!=null){
            next.next = headOfReverse;
            headOfReverse = next;
            next = futureNode;
            futureNode = futureNode.next;
        }

        next.next = headOfReverse;
        head = next; 
        tail = tailOfReverse;     
    }
}