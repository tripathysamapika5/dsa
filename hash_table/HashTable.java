import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args){
        Hashtable<Integer, String> hashTable= new Hashtable<Integer, String>();
        hashTable.put(1, "one");
        hashTable.put(2, "two");
        hashTable.put(3, "three");

        hashTable.put(4, "four");
        hashTable.put(5, "five");
        hashTable.put(6, "six");
        System.out.println(hashTable);
        hashTable.remove(4);
        System.out.println(hashTable);

    }
}
