public class QuickSort {

    public static void quickSort(int[] array, int start, int end) {

        if (start < end) {

            int pivot = start;
            int i = start;
            int j = end;

            while (i < j) {

                while (array[i] <= array[pivot] && i < end) {
                    i = i + 1;
                }

                while (array[j] > array[pivot]) {
                    j = j - 1;
                }

                if (i < j) {

                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[pivot];
            array[pivot] = array[j];
            array[j] = temp;

            quickSort(array, start, j - 1);
            quickSort(array, j + 1, end);
        }
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

        System.out.println("\nQuick Sort:");

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        displayArray(array);
    }
}
