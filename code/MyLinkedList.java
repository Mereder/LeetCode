/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class MyLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    private int size;
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.size) return -1;
        Node p = this.head;
        while(index != 0 ){
            p = p.next;
            index--;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node pre = this.head;
        this.head = new Node(val);
        this.head.next = pre ;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        this.size++;
        Node p = this.head;
        if(this.head == null){
            head = node;
            return;
        }
        while(p.next != null){
            p = p.next;
        }
        p.next = node;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node p = this.head;
        while(index-1 != 0 ){
            p = p.next;
            index--;
        }
        node.next = p.next;
        p.next = node;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index <0 || index >= size) return;
        Node p = this.head;
        while(index != 0){
            p = p.next;
            index--;
        }
        if (p.next == null) {
            p = p.next;
        }
        else {
            p.val = p.next.val;
            p.next = p.next.next;
        }
        this.size--;
    }
    public static void main(String[] args) {
//["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
//[[],[0],[1,2],[0],[1],[0,1],[0],[1]]
//        ["MyLinkedList","addAtIndex","get","deleteAtIndex"]
//[[],[-1,0],[0],[-1]]
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(-1,2);
        linkedList.get(0);
        linkedList.deleteAtIndex(-1);

    }
}


