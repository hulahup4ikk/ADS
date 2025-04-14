package Assignment_2;

// Класс MyMinHeap — минимальная куча, параметризованная типом T, который должен быть Comparable
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap; // Внутреннее хранилище кучи — список

    public MyMinHeap() {
        heap = new MyArrayList<>(); // Инициализация пустой кучи
    }

    // Вставка нового элемента в кучу
    public void insert(T item) {
        heap.addLast(item);              // Добавляем элемент в конец
        heapifyUp(heap.size() - 1);      // Восстанавливаем свойство кучи вверх
    }

    // Извлечение минимального элемента (корня кучи)
    public T extractMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty"); // Проверка на пустоту

        T min = heap.getFirst();                // Сохраняем минимальный элемент (корень)
        T last = heap.get(heap.size() - 1);     // Последний элемент в куче

        heap.set(0, last);                      // Перемещаем последний элемент в корень
        heap.removeLast();                      // Удаляем его с конца

        heapifyDown(0);                         // Восстанавливаем кучу вниз от корня

        return min;                             // Возвращаем минимальный элемент
    }

    // Просмотр минимального элемента без удаления
    public T peek() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty"); // Проверка на пустоту
        return heap.getFirst(); // Корень кучи
    }

    // Получение размера кучи
    public int size() {
        return heap.size();
    }

    // Проверка, пуста ли куча
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Метод "просеивания вверх" — восстанавливает свойство min-heap при вставке
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Вычисляем индекс родителя
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) {
                break; // Если родитель меньше или равен — всё ок
            }
            swap(index, parentIndex); // Меняем местами с родителем
            index = parentIndex;      // Поднимаемся вверх
        }
    }

    // Метод "просеивания вниз" — восстанавливает min-heap при удалении корня
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;   // Индекс левого ребёнка
        int rightChild = 2 * index + 2;  // Индекс правого ребёнка
        int smallest = index;           // Изначально минимальный — сам элемент

        // Если левый ребёнок существует и меньше текущего — обновляем smallest
        if (leftChild < heap.size() &&
                heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        // То же для правого ребёнка
        if (rightChild < heap.size() &&
                heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        // Если минимальный элемент — не текущий, меняем местами и продолжаем
        if (smallest != index) {
            swap(index, smallest);     // Меняем местами текущий и минимального ребёнка
            heapifyDown(smallest);     // Рекурсивно восстанавливаем дальше вниз
        }
    }

    // Обмен двух элементов в массиве по индексам
    private void swap(int i, int j) {
        T temp = heap.get(i);         // Сохраняем временно элемент i
        heap.set(i, heap.get(j));     // Заменяем i на j
        heap.set(j, temp);            // Заменяем j на сохранённый i
    }
}
