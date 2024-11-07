package de.telran.hw_2024_10_08.task1;

public class MainSpecialStack {
    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();
        System.out.println("MIN value: " + stack.getMin());
        stack.push(50);
        System.out.println("MIN value: " + stack.getMin());
        stack.push(10);
        System.out.println("MIN value: " + stack.getMin());
        stack.push(20);
        System.out.println("MIN value: " + stack.getMin());
        stack.push(30);
        System.out.println("MIN value: " + stack.getMin());
        stack.push(10);
        System.out.println("MIN value: " + stack.getMin());
        stack.push(40);
        System.out.println("MIN value: " + stack.getMin());
        stack.print();

        System.out.println(stack.peek()+" - (peek) view data from top stack");
        System.out.println("MIN value: " + stack.getMin());
        stack.print();

        System.out.println();
        System.out.println("isEmpty = "+stack.isEmpty());
        System.out.println(stack.pop()+" - popped from stack");
        stack.print();
        System.out.println("MIN value: " + stack.getMin());
        System.out.println();

        System.out.println(stack.pop()+" - popped from stack");
        stack.print();
        System.out.println("MIN value: " + stack.getMin());
        System.out.println();
        System.out.println(stack.pop()+" - popped from stack");

        stack.print();
        System.out.println("MIN value: " + stack.getMin());
        System.out.println(stack.pop()+" - popped from stack");
        System.out.println("MIN value: " + stack.getMin());
        stack.print();
        System.out.println("MIN value: " + stack.getMin());
        System.out.println("isEmpty = "+stack.isEmpty());
    }
}
