package de.telran.hw_2024_10_15.task3;

public class My2WayLinkedList {
    protected Node2Way head; //ccылка на первый элемент
    protected Node2Way tail; //reference to the last element

    public Node2Way getHead() {
        return head;
    }

    public Node2Way getTail() {
        return tail;
    }

    // First element
    public void pushToHead(int data) {
        Node2Way newNode = new Node2Way(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        head.setPrev(newNode);
        newNode.setNext(head);
        head = newNode;
    }

    public boolean removeFirst() {
        if (this.head == null) {
            return false;
        }

        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
            return true;
        }

        this.head.getNext().setPrev(null);
        this.head = this.head.getNext();
        // this.head.setPrev(null);
        return true;
    }

    // Last element
    public void pushToTail(int data) {
        Node2Way newNode = new Node2Way(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
    }


    public void removeLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (tail.getPrev() == null) {
            head = null;
            tail = null;
            return;
        }

        tail = tail.getPrev();
        tail.setNext(null);

    }

    // --- Index ---

    public void pushToIndex(int index, int data) {
        Node2Way newNode = new Node2Way(data);
        Node2Way current = head;
        int jump;

        if (index < 0) {
            System.out.println("index out of bounds '-'");
        } else if (index == 0) {
            this.pushToHead(data);
        } else {
            jump = 0;
            while (jump < index - 1 && current != null) {
                current = current.getNext();
                jump++;
            }
            if (current == null){
                System.out.println("index out of bounds '+'");
            } else if (current.getNext() == null){
                this.pushToTail(data);
            } else {
                current.getNext().setPrev(newNode);
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                newNode.setPrev(current);
            }

        }
    }

    public void remove(int index) {
        Node2Way current = head;
        int jump;
        if (index < 0) {
            System.out.println("index out of bounds '-'");
        } else if (index == 0) {
            removeFirst();
        } else {
            jump = 0;
            while (jump < index - 1 && current != null) {
                current = current.getNext();
                jump++;
            }

            if (current == null){
                System.out.println("index out of bounds '+'");
            } else if (current.getNext() == null){
                System.out.println("index out of bounds '+'");
            } else if (current.getNext().getNext() == null) {
                removeLast();
            } else {
                current.getNext().getNext().setPrev(current);
                current.setNext(current.getNext().getNext());
                //current.getNext().setPrev(current); // same but after current.next update
            }
        }
    }

    public int get(int index) {
        int count = -1;
        if (head == null) {
            return -1;
        }
        if (index < 0 || index > size()) {
            return -1;
        }

        Node2Way node = head;
        while (node != null) {
            count++;
            if (count == index) {
                return node.getData();
            }
            node = node.getNext();
        }
        return -1;
    }

    public int size() {
        Node2Way node;
        int count = 0;
        for (node = head; node != null; node = node.getNext()) {
            count++;
        }
        return count;
    }

    public void printForward() {
        Node2Way node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public void printBackward() {
        Node2Way node = tail;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getPrev();
        }
        System.out.println();
    }
}
