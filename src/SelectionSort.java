public class SelectionSort {
    public static void selectionSort(int[] array) {

        int n = array.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                comparisons++;

                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;

                swaps++;
            }

            System.out.print("Pass " + (i + 1) + ": ");
            displayArray(array);
        }

        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
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

        System.out.println("\nSelection Sort:");

        selectionSort(array);

        System.out.println("\nSorted Array:");
        displayArray(array);
    }
}