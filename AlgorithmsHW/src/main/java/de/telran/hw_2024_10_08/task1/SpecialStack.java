package de.telran.hw_2024_10_08.task1;

public class SpecialStack {
    private final int[] a;
    private int top;
    private final int MAX;
    private int min;

    private void updateMin(){
        if (this.top < 0){
            System.out.println("Stack Underflow");
            this.min = -1;
        } else {
            this.min = this.a[this.top];
            for (int index = this.top; index > -1; index--) {
                if (this.a[index] <= this.min){
                    this.min = this.a[index];
                    //break;
                }
            }
        }
        System.out.println("New MIN value: " + this.min);
    }

    public int getMin(){
        if (this.top < 0) {
            System.out.println("Stack Underflow. MIN is undefined.");
        }
        return min;
    }

    public SpecialStack() {
        this.MAX = 10; // размер стэка
        this.top = -1; //индекс последнего добавленного элемента
        this.a = new int[this.MAX];
        this.min = -1;
    }

    // проверка на пустой stack
    public boolean isEmpty() {
        return (this.top < 0);
    }

    // добавление данных
    public boolean push(int x) {
        if (this.top >= (this.MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            if (this.min == -1 || x < this.min){
                this.min = x;
            }
            this.a[++this.top] = x; // вставка
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    // извлечение данных
    public int pop() {
        if (this.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int res = this.a[this.top]; //извлечение
            this.a[this.top] = 0;
            this.top--;
            if (res <= this.min) {
                updateMin();
            }
            return res;
        }
    }

    // просмотр значение для извлечения
    public int peek() {
        if (this.top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return this.a[this.top];
        }
    }

    // печать stack
    public void print() {
        for (int index = this.top; index > -1; index--) {
            System.out.print(" "+this.a[index]);
        }
        System.out.println();
    }

}
