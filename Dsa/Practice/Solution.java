package Practice;

class Node{
    int num;
    Node next;

    Node(int num, Node next){
        this.num = num;
        this.next = next;
    }

    Node(int num){
        this.num = num;
        this.next = null;
    }
}

public class Solution {

    
    // conver Array to LinkedList
    // req arr[]

    public static Node convertArrtoLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static int searchEle(Node head, int el){
        Node temp = head;
        while (temp != null) {
            if (temp.num == el) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static Node DeleteHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public static Node lastDelete(Node head){
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node anyvalue(Node head, int key){
        Node temp = head;

        while (temp != null) {
            if (temp == null || temp.next == null) return head;
            if (temp.num == key) {
                head = head.next;
                return head;
            }
            if (temp.next.num == key){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node conver(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node anyPosition(Node head, int k){

        if (head == null) return head;

        Node temp = head;
        Node prev = null;
        
        int cnt = 0;

        while (temp != null) {
            cnt ++;
            if (k == 1 && cnt == 1) {
                head = head.next;
                return head;
            }
            if (cnt == k) {
             prev.next = prev.next.next;   
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //------------------------------------------------------------------------

    // Insertion


    //insert in head
    public static Node insertHead(Node head, int val){
        if (head == null)  return head;

        return new Node(val, head);
    }
    
    // insert in tail


    public static Node insertTail(Node head, int val){
        if (head == null) return null;

        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        Node newnode = new Node(val);
        temp.next = newnode;

        return head;
    }

    // Insert at position

    public static Node insertatany(Node head, int val, int k) {
        if (head == null) {
            return new Node(val);
        }

        if (k == 1) {
            return new Node(val, head);
        }

        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt++;
            if (cnt == k-1) {
                Node x = new Node(val, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    //-------------------------------------------------------------------


    public static void main(String[] args) {
        
        int[] arr = {3,5,1,7,2};

        Node head = conver(arr);
        head = insertatany(head, 0, 4);
        // head = anyvalue(head, 5);
        Node temp = head;

        while (temp != null) {
            System.out.println("--> " + temp.num);
            temp = temp.next;
        }
    }
}