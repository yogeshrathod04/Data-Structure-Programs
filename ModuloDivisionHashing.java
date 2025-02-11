import java.util.Arrays;

public class ModuloDivisionHashing {
    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \\nRoll No: C24092");

        // Initialize hash table with -1 indicating empty slots
        int[] hashTable = new int[10];
        Arrays.fill(hashTable, -1);

        // Example keys to insert into hash table
        int[] keys = { 25, 43, 13, 88, 92 };
        int tableSize = hashTable.length;

        System.out.println("Key Mapping (Modulo Division):");

        for (int key : keys) {
            int index = key % tableSize;

            // Handling collisions using linear probing
            while (hashTable[index] != -1) {
                System.out.println("Collision occurred for key: " + key + " at index: " + index);
                index = (index + 1) % tableSize; // Move to the next index
            }

            hashTable[index] = key;
            System.out.println("Key: " + key + " -> Index: " + index);
        }

        System.out.println("\nFinal Hash Table: " + Arrays.toString(hashTable));
    }
}

