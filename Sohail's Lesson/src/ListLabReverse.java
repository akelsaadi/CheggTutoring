public class ListLabReverse
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         new ListNode("science",
         new ListNode("java",
         new ListNode("coffee", head))));
         
      System.out.print("original: \t\t\t");
      print(head);
      
      System.out.print("recur and print: \t\t");
      recurAndPrint(head);
   
      System.out.println();
      System.out.print("original: \t\t\t");
      print(head);
   
      System.out.print("reverse by building a new list: ");
      head = reverseBuildNew(head);
      print(head);      
   	
      System.out.print("iterate with 3 pointers:\t");
      head = iterateThreePointers(head);
      print(head);
   	
      System.out.print("recur with 2 pointers: \t\t");
      head = recurTwoPointers(null, head);
      print(head);
           
      System.out.print("recur with pointers and append: ");
      head = recurPointersAppend(head);
      print(head);
   	
      System.out.print("Mind Bender reverse:\t\t");
      head = mindBender(head);
      print(head);
   }
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
      }
      System.out.println("]");
   }
	/*********************************************
	1. This approach doesn't actually reverse the list.  It only prints
	the list in reverse order.  recurAndPrint() prints the square 
	brackets and calls helper().  helper() is recursive.
	********************************************************/
   public static void recurAndPrint(ListNode h)
   {
      if(h==null)
      {
         System.out.print("[]"); 
         return; 
      }
      System.out.print("["); 
      helper(h.getNext()); 
      System.out.print(h.getValue() + "]"); 
   }
   private static void helper(ListNode p)
   {
      if(p == null)
         return; 
      helper(p.getNext()); 
      System.out.print(p.getValue() + ", "); 
   }
   
   /*********************************************
	2. This iterative method (for or while) produces a copy of the 
	reversed list.	 For each node going forward, make a new node and 
	link it to the list.	The list will naturally be in reverse. 
	***********************************************************/
   public static ListNode reverseBuildNew(ListNode head)
   {
      if(head == null)
      {
         System.out.println("[]"); 
         return null; 
      }
      ListNode wih = new ListNode(head.getValue(), null); 
      for(ListNode x = head.getNext(); x != null; x = x.getNext())
      {
         wih = new ListNode(x.getValue(), wih);
      } 
   
      return wih;
   }

   /*******************************************
	3a. This iterative method (while) uses 3 pointers to reverse 
	the list in place.   The two local pointers are called
	prev and next.
   ********************************************************/
   public static ListNode iterateThreePointers(ListNode head)
   {
      if(head == null)
         return null; 
      ListNode prev = null, next = head.getNext();
      while(next != null)
      {
         head.setNext(prev); 
         prev = head; 
         head = next;
         next = head.getNext(); 
      } 
      head.setNext(prev); 
      return head;
   }
   	
	/**************************************************
	3b. This method uses two pointers as arguments to reverse 
	the list in place. It is recursive.
	*********************************************************/
   public static ListNode recurTwoPointers(ListNode prev, ListNode head)
   {
      if(head == null)
         return prev; 
      prev = new ListNode(head.getValue(), prev); 
      head = head.getNext(); 
      return recurTwoPointers(prev, head); 
   } 
	/**********************************************
	3c. On each recursive level, find pointerToLast() and 
	nextToLast(). Make a new last. On way back, append() 
	one level to the other. 
	********************************************************/
   public static ListNode recurPointersAppend(ListNode head)
   {
      int index = getIndex(head);
      if (index==0) 
         return head;
   
      ListNode pToLast = pointerToLast(head);
      
      ListNode nToLast = nextToLast(head);
      
      nToLast.setNext(null);
      
      ListNode reverse = recurPointersAppend(head);
      ListNode append = append(pToLast, reverse);
      
      return append;
   }
   private static ListNode pointerToLast(ListNode head)
   {
      if(head == null)
         return null; 
      ListNode p = head; 
      for(int i = 0; i < getIndex(head); i++)
      {
         p = p.getNext(); 
      }
      return p;
   }
   public static int getIndex(ListNode head)
   {
      if(head.getNext() == null)
         return 0; 
      return 1 + getIndex(head.getNext()); 
   }
   private static ListNode nextToLast(ListNode head)
   {
      int indexNegOne = getIndex(head);
      if(indexNegOne == 0)
         head = null; 
      for(int i = 0; i < indexNegOne-1; i++)
      {
         head = head.getNext(); 
      }
      return head; 
   }
   private static ListNode append(ListNode h1, ListNode h2)
   {
      pointerToLast(h1).setNext(h2);
      return h1; 
   }

   
   /**********************************************
   3d. This difficult method reverses the list in place, using one
   local pointer. Start with pointerToLast(). The helper method
   is recursive.
	********************************************************/
   public static ListNode mindBender(ListNode head)
   {
      ListNode temp = pointerToLast(head);
      mindBenderHelper(head);
      head.setNext(null);
      return temp;
   }
   public static void mindBenderHelper(ListNode head)
   {
      if(head == null)
         return; 
      if(head.getNext() == null)
         return;
      mindBenderHelper(head.getNext()); 
      head.getNext().setNext(head); 
      head.setNext(null); 
   
   }
}

//the College Board's standard ListNode class
class ListNode
{
   private Object value;
   private ListNode next;
   public ListNode(Object v, ListNode n)
   {
      value=v;
      next=n;
   }
   public Object getValue()
   {
      return value;
   }
   public ListNode getNext()
   {
      return next;
   }
   public void setValue(Object newv)
   {
      value=newv;
   }
   public void setNext(ListNode newn)
   {
      next=newn;
   }
}