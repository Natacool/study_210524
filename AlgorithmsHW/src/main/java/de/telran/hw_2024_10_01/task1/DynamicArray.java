package de.telran.hw_2024_10_01.task1;
/*
 1 уровень сложности: 1. Завершить реализацию Динамического массива (если не завершили в классе)
DynamicArray() - по умолчанию size = 10
DynamicArray(capacity) - size = capacity

Реализуйте методы:
set(index, data) - изменяет элемент
clean() - удаляет все элементы
contains(data) - проверяет существует ли элемент
isEmpty() - вернет false, если в структуре есть элемент

*/
public class DynamicArray {

    int[] array; // variable array[] is an array
    int count; // количесвто элементов в списке
    private int size; // размер массива
    private int k; // коэфициент увеличения массива



    public DynamicArray() {
        array = new int[10];
        count = 0;
        size = 10;
        k = 2;
    }

    public DynamicArray(int capacity) {
        array = new int[capacity];
        count = 0;
        size = capacity;
        k = 2;
    }

    // добавляем элементы в конец 
    public void add (int data) {
        if(this.count == this.size) {
            growSize();
        }

        this.array[this.count] = data;
        this.count++;       
    }

    // расширяем внутренний массив
    private void growSize() {
        int[] temp = new int[this.size * this.k];
        for(int i=0; i<this.size; i++) {
            temp[i] = this.array[i];
        }
        this.array = temp; 
        this.size = this.size * this.k;
    }

      // добавление по индексу
      public void addAt(int index, int data) {
        //расширяем массив
        if (this.count == this.size) { 
            this.growSize();
        }

        // смещаем на единицу вправо, освобождая место по index
        for (int i = this.count - 1; i >= index; i--) {
            this.array[i + 1] = this.array[i]; 
        }
        //вставляем элемент
        this.array[index] = data; 
        this.count++;
    }

    
    //удаляем последний элемент    
    public void remove() {
        if (this.count > 0) {
            this.array[this.count - 1] = 0;
            this.count--;
        }
    }

    //удаление по индексу
    public void removeAt(int index) {
        if (this.count > 0) {
            for (int i = index; i < this.count - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[this.count - 1] = 0;
            this.count--;
        }
    }

    // home work
    //- изменяет элемент
    public void set(int index, int data){
        if (index < this.count)
            this.array[index] = data;
    }

    //- удаляет все элементы
    public void clean(){
        for (int i = 0; i < this.count; i++) {
            this.array[i] = 0;
        }
        this.count = 0;

    }

    //- проверяет существует ли элемент
    public boolean contains(int data){
        boolean res = false;
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == data){
                res = true;
                break;
            }
        }
        return res;
    }


    // вернет false, если в структуре есть элемент
    public boolean isEmpty(){
        boolean res = false;
        if (this.count == 0) res = true;
        return res;
    }


}
