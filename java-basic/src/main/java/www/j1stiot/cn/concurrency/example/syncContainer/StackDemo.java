package www.j1stiot.cn.concurrency.example.syncContainer;

import java.util.Stack;

/**
 * stack demo
 */
public class StackDemo {


    public static void main(String[] args){
        Stack<Integer> stack=new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }



}
