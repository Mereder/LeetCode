/*
 * Date :  2019.
 * Author : Mereder
 */

package code;


import java.util.Stack;

class P232_MyQueue {
    Stack<Integer> stack_in;
    Stack<Integer> stack_out;
    /** Initialize your data structure here. */
    public P232_MyQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack_in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack_in.isEmpty() && stack_out.isEmpty()) return -1;
        else if (! stack_out.isEmpty()){
            return stack_out.pop();
        }
        else if(stack_out.isEmpty()) {
            while (!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack_out.isEmpty() && stack_in.isEmpty()) return -1;
        else if (stack_out.isEmpty()){
            while(stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack_in.isEmpty() && stack_out.isEmpty();
    }

    public static void main(String[] args) {
        P232_MyQueue obj = new P232_MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.printf("%d    %d\n",param_2,param_3);
        System.out.println(param_4);

    }
}

