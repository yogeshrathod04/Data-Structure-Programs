import java.util.Arrays;

public class DigitExtractionHashing {
    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092\n");

        int[] hashTable = new int[10]; // Hash table of size 10
        Arrays.fill(hashTable, -1); // Initialize with -1 (empty)

        int[] keys = { 12345, 67890, 23456, 78901, 34567 }; // Example keys
        int tableSize = hashTable.length;

        System.out.println("Key Mapping (Digit Extraction):");
        for (int key : keys) {
            int extractedDigit = extractDigits(key); // Extract relevant digits
            int index = extractedDigit % tableSize;
            hashTable[index] = key;
            System.out.println("Key: " + key + " -> Extracted Digits: " + extractedDigit + " -> Index: " + index);
        }

        System.out.println("\nFinal Hash Table: " + Arrays.toString(hashTable));
    }

    public static int extractDigits(int key) {
        // Convert key to a string to extract digits
        String keyStr = Integer.toString(key);
        int length = keyStr.length();

        // Extract middle 2 digits (or handle edge cases)
        if (length < 2) {
            return key; // If key has fewer than 2 digits, return the key itself
        } else {
            // Extract middle 2 digits
            return Integer.parseInt(keyStr.substring(length / 2 - 1, length / 2 + 1));
        }
    }
}
