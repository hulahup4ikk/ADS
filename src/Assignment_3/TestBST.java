package Assignment_3;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "five");
        tree.put(2, "two");
        tree.put(8, "eight");
        tree.put(1, "one");
        tree.put(3, "three");

        System.out.println("Size after inserts: " + tree.size()); // Ожидаем 5

        System.out.println("Get key 2: " + tree.get(2)); // Ожидаем "two"
        System.out.println("Get key 8: " + tree.get(8)); // Ожидаем "eight"
        System.out.println("Get key 10: " + tree.get(10)); // Ожидаем null

        System.out.println("\nIterating over tree:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(2);
        System.out.println("\nAfter deleting key 2:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
        System.out.println("Size after deletion: " + tree.size()); // Ожидаем 4
    }
}

