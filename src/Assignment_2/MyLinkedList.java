package Assignment_2;

// Реализация двусвязного списка, реализующего интерфейс MyList
public class MyLinkedList<T> implements MyList<T> {

    // Внутренний класс, представляющий узел связного списка
    private class MyNode<T> {
        T data;           // Данные, хранимые в узле
        MyNode<T> next;   // Ссылка на следующий узел
        MyNode<T> prev;   // Ссылка на предыдущий узел

        public MyNode(T data) {
            this.data = data; // Инициализация значением
        }
    }

    private MyNode<T> head;  // Указатель на первый узел списка
    private MyNode<T> tail;  // Указатель на последний узел
    private int length;      // Количество элементов в списке

    public MyLinkedList() {
        head = null; // Изначально список пуст
        tail = null;
        length = 0;
    }

    @Override
    public void add(T element) {
        addLast(element); // Добавление по умолчанию — в конец списка
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item); // Создаём новый узел

        if (head == null) {
            head = tail = newNode; // Если список пуст, head и tail указывают на один узел
        } else {
            newNode.next = head;   // Новый узел указывает на текущий head
            head.prev = newNode;   // Текущий head указывает назад на новый узел
            head = newNode;        // Обновляем head
        }

        length++; // Увеличиваем размер списка
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (tail == null) {
            head = tail = newNode; // Если список пуст
        } else {
            tail.next = newNode;   // Последний элемент указывает на новый
            newNode.prev = tail;   // Новый узел ссылается на старый tail
            tail = newNode;        // Новый tail
        }

        length++;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == length) {
            addLast(item);
            return;
        }
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> current = getNode(index);      // Находим узел по индексу
        MyNode<T> newNode = new MyNode<>(item);  // Создаём новый узел

        MyNode<T> prev = current.prev;           // Узел перед вставкой
        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = current;
        current.prev = newNode;

        length++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == length - 1) {
            removeLast();
            return;
        }

        MyNode<T> toRemove = getNode(index); // Находим узел
        toRemove.prev.next = toRemove.next;  // Переподключаем предыдущий к следующему
        toRemove.next.prev = toRemove.prev;
        length--;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;

        head = head.next; // Перемещаем head на следующий
        if (head != null) {
            head.prev = null; // Обнуляем обратную ссылку
        } else {
            tail = null; // Если список стал пуст, tail тоже обнуляется
        }

        length--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;

        tail = tail.prev; // Перемещаем tail на предыдущий узел
        if (tail != null) {
            tail.next = null; // Обнуляем next
        } else {
            head = null; // Список пуст
        }

        length--;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data; // Возвращаем значение по индексу
    }

    // Возвращает узел по индексу
    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current;

        // Если индекс ближе к началу — начинаем с head
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.prev;
        }

        return current;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item; // Устанавливаем новое значение
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public boolean exists(Object object) {
        return indexof(object) != -1;
    }

    @Override
    public int indexof(Object object) {
        MyNode<T> current = head;

        for (int i = 0; current != null; i++) {
            if (current.data.equals(object)) return i;
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastindexof(Object object) {
        MyNode<T> current = tail;

        for (int i = length - 1; current != null; i--) {
            if (current.data.equals(object)) return i;
            current = current.prev;
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;

        for (int i = 0; i < length; i++) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }

    @Override
    public void sort() {
        // Метод не реализован. Можно выбросить исключение:
        // throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int size() {
        return length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
    }

    // Вложенный класс — очередь, использующая MyLinkedList как основу
    public class MyQueue<T> {
        private final MyLinkedList<T> list;

        public MyQueue() {
            list = new MyLinkedList<>();
        }

        public void enqueue(T item) {
            list.addLast(item); // Добавление в конец
        }

        public T dequeue() {
            if (list.size() == 0) throw new RuntimeException("Queue is empty");
            T item = list.getFirst();  // Получаем первый элемент
            list.removeFirst();        // Удаляем его
            return item;
        }

        public T peek() {
            if (list.size() == 0) throw new RuntimeException("Queue is empty");
            return list.getFirst(); // Возвращаем первый без удаления
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public int size() {
            return list.size();
        }

        public void clear() {
            list.clear();
        }
    }
}
