package Assignment_2;

public class Main { // Главный класс программы

    public static void main(String[] args) { // Точка входа в программу. Метод main вызывается при запуске.
        testArrayList(); // Тестируем реализацию MyArrayList
        System.out.println("================================================="); // Разделитель в выводе
        testLinkedList(); // Тестируем реализацию MyLinkedList
        System.out.println("=================================================");
        testStack(); // Тестируем реализацию стека MyStack
        System.out.println("=================================================");
        testQueueLinkedList(); // Тестируем очередь на основе связного списка
        System.out.println("=================================================");
        testQueueArrayList(); // Тестируем очередь на основе массива
        System.out.println("=================================================");
        testMinHeap(); // Тестируем минимальную кучу
        System.out.println("=================================================");
    }

    public static void testArrayList() { // Метод для проверки функциональности MyArrayList
        System.out.println("Testing MyArrayList...");
        MyArrayList<Integer> list = new MyArrayList<>(); // Создаём список

        // Добавление элементов
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("After adding 6 elements: ");
        print(list); // Ожидаемый вывод: 1 2 3 4 5 6

        list.set(1, 25); // Устанавливаем новое значение на индекс 1
        System.out.println("After set(1, 25):");
        print(list); // Ожидаемый вывод: 1 25 3 4 5 6

        list.remove(0); // Удаление элемента с начала
        System.out.println("After remove(0): ");
        print(list); // Ожидаемый вывод: 25 3 4 5 6

        System.out.println("Get element at index 1: " + list.get(1)); // Получение элемента по индексу
        System.out.println("Size: " + list.size()); // Размер списка после операций

        list.clear(); // Очистка списка
        System.out.println("After clear:");
        print(list); // Ожидается пустой вывод

        // Добавляем снова элементы
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 10); // Меняем второй элемент на 10
        System.out.println("After set(1, 10):");
        print(list); // Ожидаемый вывод: 1 10 3

        list.remove(2); // Удаление элемента по индексу
        System.out.println("After remove(2):");
        print(list); // Ожидаемый вывод: 1 10

        System.out.println("First element: " + list.getFirst()); // Получаем первый элемент
        System.out.println("Last element: " + list.getLast());   // Получаем последний элемент
    }

    public static void testLinkedList() { // Тестирование MyLinkedList
        System.out.println("Testing MyLinkedList...");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(); // Создаём связный список

        // Добавление элементов
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Initial list:");
        print(linkedList); // Ожидаемый вывод: 1 2 3

        linkedList.set(1, 20); // Устанавливаем значение 20 по индексу 1
        System.out.println("After set(1, 20):");
        print(linkedList); // Ожидаемый вывод: 1 20 3

        linkedList.remove(2); // Удаление элемента по индексу 2
        System.out.println("After remove(2):");
        print(linkedList); // Ожидаемый вывод: 1 20

        System.out.println("First element: " + linkedList.getFirst()); // Первый элемент
        System.out.println("Last element: " + linkedList.getLast());   // Последний элемент
    }

    public static void testStack() { // Тестирование MyStack
        System.out.println("Testing MyStack...");
        MyStack<Integer> stack = new MyStack<>(); // Создаём стек

        stack.push(2); // Добавляем элементы
        stack.push(5);
        stack.push(4);

        System.out.println("After pushing 2, 5, 4:");
        System.out.println("Size: " + stack.size()); // Размер стека
        System.out.println("Peek: " + stack.peek()); // Просмотр верхнего элемента
        System.out.println("Pop: " + stack.pop());   // Извлечение верхнего элемента
        System.out.println("After pop:");
        System.out.println("Peek: " + stack.peek()); // Новый верхний элемент после pop
    }

    public static void print(MyList<Integer> list) { // Универсальный метод для печати списка
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // Печать каждого элемента
        }
        System.out.println();
    }

    public static void testQueueLinkedList() { // Тестирование очереди на связном списке
        System.out.println("Testing MyQueue with MyLinkedList...");
        MyQueue<Integer> queue = new MyQueue<>(); // Очередь

        // Добавление элементов (enqueue)
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("After enqueuing 10, 20, 30:");
        printQueue(queue); // Ожидаемый вывод: 10 20 30

        // Получение первого элемента
        System.out.println("Peek: " + queue.peek()); // Первый элемент

        // Размер очереди
        System.out.println("Size: " + queue.size());

        // Удаление первого элемента
        System.out.println("Dequeue: " + queue.dequeue()); // Ожидается 10
        System.out.println("After dequeue:");
        printQueue(queue); // Ожидаемый вывод: 20 30

        // Очистка очереди
        queue.clear();
        System.out.println("After clearing the queue:");
        printQueue(queue); // Ожидается пусто
    }

    public static void testQueueArrayList() { // Тестирование очереди на массиве
        System.out.println("Testing MyQueue with MyArrayList...");
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("After enqueuing 1, 2, 3:");
        printQueue(queue); // Ожидаемый вывод: 1 2 3

        System.out.println("Peek: " + queue.peek()); // Первый элемент
        System.out.println("Size: " + queue.size()); // Размер

        System.out.println("Dequeue: " + queue.dequeue()); // Удаляем 1
        System.out.println("After dequeue:");
        printQueue(queue); // Ожидаемый вывод: 2 3

        queue.clear();
        System.out.println("After clearing the queue:");
        printQueue(queue); // Ожидаемый вывод: Пусто
    }

    public static void printQueue(MyQueue<Integer> queue) { // Метод для печати очереди
        MyQueue<Integer> tempQueue = new MyQueue<>(); // Временная очередь для восстановления порядка

        while (!queue.isEmpty()) { // Пока очередь не пуста
            int item = queue.dequeue(); // Извлекаем элемент
            System.out.print(item + " "); // Печатаем
            tempQueue.enqueue(item); // Сохраняем элемент
        }

        while (!tempQueue.isEmpty()) { // Восстанавливаем очередь
            queue.enqueue(tempQueue.dequeue());
        }
        System.out.println(); // Перенос строки
    }

    public static void testMinHeap() { // Тестирование минимальной кучи
        System.out.println("Testing MyMinHeap...");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();

        // Добавление элементов
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);
        minHeap.insert(1);
        minHeap.insert(25);

        // Проверка минимального элемента
        System.out.println("Минимальный элемент (peek): " + minHeap.peek()); // 1

        // Размер кучи
        System.out.println("Размер кучи: " + minHeap.size()); // 7

        // Извлечение минимума
        System.out.println("Извлекаем минимальный элемент (extractMin): " + minHeap.extractMin()); // 1
        System.out.println("Размер кучи после извлечения минимального элемента: " + minHeap.size()); // 6
        System.out.println("Новый минимальный элемент после извлечения: " + minHeap.peek()); // 5

        // Извлечение ещё нескольких элементов
        System.out.println("Извлекаем минимальный элемент (extractMin): " + minHeap.extractMin()); // 5
        System.out.println("Извлекаем минимальный элемент (extractMin): " + minHeap.extractMin()); // 10
        System.out.println("Размер кучи после извлечений: " + minHeap.size()); // 4

        // Проверка на пустоту
        System.out.println("Пуста ли куча? " + minHeap.isEmpty()); // false

        // Полная очистка кучи
        minHeap.extractMin();
        minHeap.extractMin();
        minHeap.extractMin();
        minHeap.extractMin();

        System.out.println("Пуста ли куча после удаления всех элементов? " + minHeap.isEmpty()); // true
    }
}
