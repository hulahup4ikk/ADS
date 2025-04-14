package Assignment_2;

// Класс MyStack реализует структуру данных стек (LIFO — Last-In-First-Out)
public class MyStack<T> {
    private final MyLinkedList<T> list; // Внутренняя структура данных — двусвязный список

    public MyStack() {
        list = new MyLinkedList<>(); // Создаём пустой связный список
    }

    // Метод push — добавляет элемент в стек (в конец списка)
    public void push(T item) {
        list.addLast(item); // Добавление в "верх стека" — конец списка
    }

    // Метод pop — удаляет и возвращает верхний элемент стека
    public T pop() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty"); // Проверка на пустоту

        T item = list.getLast();   // Получаем последний (верхний) элемент
        list.removeLast();         // Удаляем его
        return item;               // Возвращаем удалённый элемент
    }

    // Метод peek — возвращает верхний элемент без удаления
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty"); // Проверка на пустоту
        return list.getLast(); // Просто возвращаем верхний элемент
    }

    // Метод возвращает текущий размер стека
    public int size() {
        return list.size();
    }

    // Метод проверяет, пуст ли стек
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Метод очищает стек
    public void clear() {
        list.clear(); // Полная очистка списка
    }
}
