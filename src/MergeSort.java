public class MergeSort {

    public static void mergeSort(int[] array, int lb, int ub) {

        if (lb < ub) {

            int mid = (lb + ub) / 2;

            mergeSort(array, lb, mid);
            mergeSort(array, mid + 1, ub);

            merge(array, lb, mid, ub);
        }
    }

    public static void merge(int[] array, int lb, int mid, int ub) {

        int[] newArray = new int[array.length];

        int i = lb;
        int j = mid + 1;
        int k = lb;

        while (i <= mid && j <= ub) {

            if (array[i] <= array[j]) {
                newArray[k] = array[i];
                i = i + 1;
            } else {
                newArray[k] = array[j];
                j = j + 1;
            }

            k = k + 1;
        }

        if (i > mid) {

            while (j <= ub) {
                newArray[k] = array[j];
                j = j + 1;
                k = k + 1;
            }

        } else {

            while (i <= mid) {
                newArray[k] = array[i];
                i = i + 1;
                k = k + 1;
            }
        }

        for (k = lb; k <= ub; k++) {
            array[k] = newArray[k];
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

        System.out.println("\nMerge Sort:");

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        displayArray(array);
    }
}
