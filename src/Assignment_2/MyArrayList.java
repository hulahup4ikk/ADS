package Assignment_2;

// Класс MyArrayList — собственная реализация списка на основе массива
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements; // Массив для хранения элементов списка
    private int length;        // Текущий размер (количество элементов)

    public MyArrayList() {
        elements = new Object[5]; // Инициализируем массив с начальной ёмкостью 5
        length = 0;               // Пока элементов нет
    }

    @Override
    public void add(T item) {
        ensureCapacity();             // Проверяем, достаточно ли места
        elements[length++] = item;    // Добавляем элемент в конец и увеличиваем размер
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);            // Проверяем корректность индекса
        elements[index] = item;       // Заменяем элемент по индексу
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) { // Индекс может быть от 0 до length включительно
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        }
        ensureCapacity(); // Убедимся, что есть место для вставки

        // Сдвигаем элементы вправо начиная с конца до позиции index
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item; // Вставляем новый элемент
        length++;               // Увеличиваем размер
    }

    @Override
    public void addFirst(T item) {
        add(0, item); // Вставка в начало — это add с индексом 0
    }

    @Override
    public void addLast(T item) {
        add(item); // Добавление в конец — просто add
    }

    @Override
    public T get(int index) {
        checkIndex(index);           // Проверка допустимости индекса
        return (T) elements[index];  // Возвращаем элемент с приведением типа
    }

    @Override
    public T getFirst() {
        if (length == 0) {
            throw new RuntimeException("List is empty"); // Проверка на пустоту
        }
        return (T) elements[0]; // Первый элемент
    }

    @Override
    public T getLast() {
        if (length == 0) {
            throw new RuntimeException("List is empty");
        }
        return (T) elements[length - 1]; // Последний элемент
    }

    @Override
    public void remove(int index) {
        checkIndex(index); // Проверка индекса

        // Сдвигаем элементы влево от index+1 до конца
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[length - 1] = null; // Удаляем последний элемент (теперь он дублируется)
        length--;                    // Уменьшаем размер
    }

    @Override
    public void removeFirst() {
        remove(0); // Удалить первый элемент
    }

    @Override
    public void removeLast() {
        if (length == 0) {
            throw new RuntimeException("List is empty");
        }
        remove(length - 1); // Удалить последний элемент
    }

    @Override
    public void sort() {
        // Простая пузырьковая сортировка. Элементы должны реализовывать интерфейс Comparable.
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Comparable current = (Comparable) elements[j];
                Comparable next = (Comparable) elements[j + 1];
                if (current.compareTo(next) > 0) {
                    // Меняем элементы местами
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexof(Object object) {
        // Ищем индекс первого вхождения объекта
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1; // Не найден
    }

    @Override
    public int lastindexof(Object object) {
        // Ищем индекс последнего вхождения объекта
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexof(object) != -1; // Существует ли элемент?
    }

    @Override
    public Object[] toArray() {
        // Копируем элементы в новый массив нужной длины
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public void clear() {
        // Обнуляем все ссылки и сбрасываем размер
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public int size() {
        return length; // Текущее количество элементов
    }

    // Проверка допустимости индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
    }

    // Удваиваем размер массива при необходимости
    private void ensureCapacity() {
        if (length == elements.length) {
            Object[] newElements = new Object[elements.length * 2]; // Создаём массив в 2 раза больше
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i]; // Копируем старые элементы
            }
            elements = newElements; // Обновляем ссылку
        }
    }

    // Вложенный класс: очередь на основе MyArrayList
    public class MyQueue<T> {
        private final MyArrayList<T> list;

        public MyQueue() {
            list = new MyArrayList<>();
        }

        public void enqueue(T item) {
            list.addLast(item); // Добавление в конец
        }

        public T dequeue() {
            if (list.size() == 0) throw new RuntimeException("Queue is empty");
            T item = list.getFirst();  // Сохраняем первый элемент
            list.removeFirst();        // Удаляем его
            return item;
        }

        public T peek() {
            if (list.size() == 0) throw new RuntimeException("Queue is empty");
            return list.getFirst(); // Просто получаем первый элемент
        }

        public boolean isEmpty() {
            return list.size() == 0; // Очередь пуста?
        }

        public int size() {
            return list.size(); // Размер очереди
        }

        public void clear() {
            list.clear(); // Очистка очереди
        }
    }
}
