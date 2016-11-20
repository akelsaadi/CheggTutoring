/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */
public class DoublyLinkedList {
    private Node first;
    private Node last;
    private int length;
    
    public void removeAtIndex(int index){
        if(index > this.length-1){
          System.out.println("Please select a smaller index");
          return;
        }
        Node n = this.first;
        if(n == null){
          System.out.println("This is an empty list.");
          return;
        }
        else{
          this.length--;
          for(int i=0; i<index; i++){
            n=n.getNext();
          }
          Node m = n.getPrev();
          m.setNext(n.getNext());
        }
    }
    
    public Node find(String value){
        Node n = this.first;
        while(n.getData() != value){
          n=n.getNext();
        }
        if(n.getData() == value){
          return n;
        }
        return null;
    }
     
    public String toStringReverse(){
        String result = "";
        for(int i=0; i<this.length; i++){
          Node n = this.first;
          for (int j=0; j<this.length-i-1; j++ ){
            n=n.getNext();
          }
          result = (result + n.getData() + " ");
        }
        return result;
    }
       
    public String toString(){
        String str = "";
        Node pointer = this.first;
        while ( pointer != null ) {
          str += pointer.getData();
          pointer = pointer.getNext();
        }        
        return str;
    }
        
    public void insertStart(String value){
    this.length++;
    Node n = new Node(value);
    Node m = this.first;
    if(m == null){
      this.first = n;
      this.last = n;
    }
    else{
      n.setNext(m);
      m.setPrev(n);
      this.first = n;
    }
  }
  
// insert a new node at the end of the list
    public void insertEnd(String value){
      this.length++;
      Node n = new Node(value);
      if (this.first == null){
        this.first = n;
        this.last = n;
      }
      else{
        this.last.setNext(n);
        n.setPrev(this.last);
        this.last = n;
      }
    }

    public void clear() {
    // drop access to all other nodes
        first = null;
        last = null;
        length =0;
    }

    public static void main (String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        String test1 = "abcd, this is test 1. ";
        String test2 = "efgh, this is test 2. ";
        
        list.insertEnd(test2);
        list.insertStart(test1);
        list.insertEnd("this is addition after test 2. ");
        System.out.println(list);
        
        Node n = list.find(test2);
        n.setData(n.getData() + " :Found node that matches string test2! ");
        System.out.println(list);
        
        list.removeAtIndex(1);
        System.out.println("Index 1 is deleted(test2):  " + list);
        
        System.out.println("Traversing Forward: " + list);
        System.out.println("Traversing Backward: " + list.toStringReverse());
        list.clear();
        System.out.println("Clearing List. ");
        System.out.println(list + "List is cleared");
        

    }
}