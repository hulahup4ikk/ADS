package Assignment_2;

// Класс MyQueue реализует очередь (FIFO) с использованием связного списка
public class MyQueue<T> {
    private final MyLinkedList<T> list; // Внутренняя структура данных — связный список

    public MyQueue() {
        list = new MyLinkedList<>(); // Инициализируем новый пустой список
    }

    // Метод добавляет элемент в конец очереди
    public void enqueue(T item) {
        list.addLast(item); // Элемент добавляется в конец списка
    }

    // Метод удаляет и возвращает первый элемент очереди
    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty"); // Проверка на пустоту
        T item = list.getFirst();  // Получаем первый элемент
        list.removeFirst();        // Удаляем первый элемент
        return item;               // Возвращаем его
    }

    // Метод возвращает первый элемент очереди без удаления
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty"); // Проверка на пустоту
        return list.getFirst(); // Возвращаем первый элемент
    }

    // Метод возвращает размер очереди
    public int size() {
        return list.size(); // Просто вызываем size() у списка
    }

    // Метод проверяет, пуста ли очередь
    public boolean isEmpty() {
        return list.size() == 0; // Проверка по размеру
    }

    // Метод очищает очередь
    public void clear() {
        list.clear(); // Вызываем метод очистки списка
    }
}
