/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (empty()){
            queue1.offer(x);
        }
        else if (!queue1.isEmpty()){
            queue1.offer(x);
        }
        else {
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty())  return -1;
        else if (!queue1.isEmpty()){
            int length = queue1.size();
            for (int i = 0; i < length-1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        else {
            int length = queue2.size();
            for (int i = 0; i < length-1; i++){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty())  return -1;
        else if (!queue1.isEmpty()){
            int length = queue1.size();
            for (int i = 0; i < length-1; i++) {
                queue2.offer(queue1.poll());
            }
            int peek = queue1.peek();
            queue2.offer(queue1.poll());
            return peek;
        }
        else {
            int length = queue2.size();
            for (int i = 0; i < length-1; i++){
                queue1.offer(queue2.poll());
            }
            int peek = queue2.peek();
            queue1.offer(queue2.poll());
            return peek;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (queue1.isEmpty() && queue2.isEmpty());
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.top();   // returns 2
//        stack.pop();   // returns 2
//        stack.empty(); // returns false
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */