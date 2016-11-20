/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Ali
 */
public class Stack {
    
    int top = -1;
    int max_size = 101;
    int[] my_array = new int [max_size];
    

    public int pop ()
    {
        return my_array[top];
    }
    public void push (int x) {
           
        top ++;
        my_array[top] = x;
        
    }
    public void print ()
    {
        for (int i=0; i<=top; i++)
        {
            System.out.println(my_array[i]);
        }
    }
    public static void main(String[] args) {
       Stack a = new Stack ();
       a.push(3);
       a.print();
       a.push(5);
       a.print();
       a.push(10);
       a.print();
       a.pop();
       a.print();
       a.push(12);
    }
    
}
