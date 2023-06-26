package collections.concurrent;

import java.util.LinkedList;
import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> integers = getLinkedList();


        System.out.println("peekFirst: " + integers.peekFirst());
        System.out.println("peekLast: " + integers.peekLast());

        System.out.println("pollFirst: " + integers.pollFirst());
        System.out.println("pollLast: " + integers.pollLast());
        //reset
        integers = getLinkedList();
        System.out.println("removeFirst: " + integers.removeFirst());
        System.out.println("removeLast: " + integers.removeLast());
        //reset
        integers = getLinkedList();
        System.out.println("poll: " + integers.poll());
        System.out.println("Linked pop works in different order : " + integers.pop());
        integers.push(4);
        System.out.println("peekFirst after stack push : " + integers.peekFirst());

        Stack<Integer> integerStack = getStack();
        System.out.println("stack pop: " + integers.pop());
    }

    private static LinkedList<Integer> getLinkedList() {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        return integers;
    }
    private static Stack<Integer> getStack() {
        Stack<Integer> integerStack = new Stack<Integer>();
        integerStack.add(1);
        integerStack.add(2);
        integerStack.add(3);
        return integerStack;
    }
}
