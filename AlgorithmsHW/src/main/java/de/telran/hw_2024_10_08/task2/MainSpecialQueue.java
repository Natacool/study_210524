package de.telran.hw_2024_10_08.task2;

public class MainSpecialQueue {
    public static void main(String[] args) {
        SpecialQueue queue = new SpecialQueue(8);
        System.out.println("isEmpty = " + queue.isEmpty());  // Output: true
        System.out.println("MAX: " + queue.getMax());

        queue.push(10);
        System.out.println("MAX: " + queue.getMax());
        queue.push(40);
        System.out.println("MAX: " + queue.getMax());
        queue.push(20);
        System.out.println("MAX: " + queue.getMax());
        queue.push(30);
        System.out.println("MAX: " + queue.getMax());
        queue.push(40);
        System.out.println("MAX: " + queue.getMax());
        queue.print();
        System.out.println("MAX: " + queue.getMax());

        System.out.println("Size = "+queue.getSize());
        System.out.println("isEmpty = "+queue.isEmpty());
        System.out.println("MAX: " + queue.getMax());

        System.out.println(queue.pop() + " - popped element from the queue");
        System.out.println("MAX: " + queue.getMax());
        queue.print();

        System.out.println(queue.peek() + " - peeked element in the queue");
        System.out.println("MAX: " + queue.getMax());
        queue.print();

        System.out.println(queue.pop() + " - popped element from the queue");
        System.out.println("MAX: " + queue.getMax());
        queue.print();
    }
}
