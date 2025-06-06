package Assignment_2;

// Класс MyNode — представляет собой узел односвязного списка
public class MyNode<T> {
    T data;         // Поле для хранения данных узла (обобщённого типа T)
    MyNode<T> next; // Ссылка на следующий узел в списке

    // Конструктор узла, принимает данные и инициализирует поле next как null
    public MyNode(T data){
        this.data = data; // Присваиваем переданное значение полю data
        this.next = null; // По умолчанию следующий узел отсутствует
    }
}
