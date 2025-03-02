import java.util.Arrays;

public class LinearProbingHashing {
    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092\n");

        int[] hashTable = new int[10]; // Hash table of size 10
        Arrays.fill(hashTable, -1); // Initialize with -1 (empty)

        int[] keys = { 25, 35, 45, 55, 65 }; // Example keys
        int tableSize = hashTable.length;

        System.out.println("Key Mapping (Linear Probing):");
        for (int key : keys) {
            int index = key % tableSize; // Calculate hash index
            int originalIndex = index;

            // Linear probing: If the slot is occupied, move to the next slot
            while (hashTable[index] != -1) {
                index = (index + 1) % tableSize; // Move to next slot
            }
            hashTable[index] = key; // Place key in the found empty slot
            System.out.println("Key: " + key + " -> Original Index: " + originalIndex + " -> Final Index: " + index);
        }

        System.out.println("\nFinal Hash Table: " + Arrays.toString(hashTable));
    }
}
