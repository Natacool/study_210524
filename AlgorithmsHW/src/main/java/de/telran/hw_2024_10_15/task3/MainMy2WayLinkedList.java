package de.telran.hw_2024_10_15.task3;

public class MainMy2WayLinkedList {
    public static void main(String[] args) {
        My2WayLinkedList lists = new My2WayLinkedList();
        System.out.println(" - pushToHead - ");
        lists.pushToHead(5);
        lists.pushToHead(3);
        lists.pushToHead(6);
        lists.printForward();

        System.out.println(" - removeFirst - ");
        lists.removeFirst();
        lists.printForward();

        System.out.println(" - pushToTail - ");
        lists.pushToTail(7);
        lists.printForward();

        System.out.println(" - removeLast - ");
        lists.removeLast();
        lists.printForward();

        System.out.println(" - pushToIndex - ");
        lists.pushToIndex(1, 10);
        lists.printForward();

        System.out.println(" - remove via index - " + 1);
        lists.remove(1);
        lists.printForward();

        System.out.println("get(1) = "+lists.get(1));
        System.out.println("Size="+lists.size());

        System.out.println(" - removeLast - ");
        lists.removeLast();
        lists.printForward();

        System.out.println(" - removeFirst - ");
        lists.removeFirst();
        lists.printForward();

        System.out.println(" - pushToTail - ");
        lists.pushToTail(7);
        lists.printForward();

        System.out.println(" - pushToHead - ");
        lists.pushToHead(5);
        lists.pushToHead(3);
        lists.pushToHead(6);
        lists.printForward();

        System.out.println(" - remove via index - " + 3);
        lists.remove(3);
        lists.printForward();

        System.out.println(" - remove via index - " + 0);
        lists.remove(0);
        lists.printForward();

        System.out.println(" - remove via index - " + 4);
        lists.remove(4);
        lists.printForward();

        System.out.println(" - remove via index - " + 2);
        lists.remove(2);
        lists.printForward();


    }
}
