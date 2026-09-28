public class InsertionSort {

    public static void insertionSort(int[] array) {

        int n = array.length;
        int comparisons = 0;
        int shifts = 0;

        for (int i = 1; i < n; i++) {

            int temp = array[i];
            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    shifts++;
                    j = j - 1;
                } else {
                    break;
                }
            }

            array[j + 1] = temp;

            System.out.print("Pass " + i + ": ");
            displayArray(array);
        }

        System.out.println("Comparisons: " + comparisons);
        System.out.println("Shifts: " + shifts);
    }

    public static void displayArray(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] array = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        System.out.println("Original Array:");
        displayArray(array);

        System.out.println("\nInsertion Sort:");

        insertionSort(array);

        System.out.println("\nSorted Array:");
        displayArray(array);
    }
}