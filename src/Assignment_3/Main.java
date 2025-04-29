package Assignment_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(100000);
            String name = "Name" + id;
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, "Student" + id);
        }

        table.printBucketSizes();
    }
}