public class SortingExperiment {

    public static void main(String[] args) {

        int[] sizes = {20, 50, 100, 500};

        for (int size : sizes) {

            System.out.println("Array Size: " + size);

            int[] array = new int[size];

            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * 1000);
            }

            System.out.println("Original array generated.");

            // Selection Sort
            int[] selectionArray = copyArray(array);

            long startTime = System.nanoTime();
            int selectionComparisons = selectionSort(selectionArray);
            long endTime = System.nanoTime();

            long selectionTime = endTime - startTime;

            System.out.println("Selection Sort:");
            System.out.println("Comparisons: " + selectionComparisons);
            System.out.println("Time: " + selectionTime + " ns");


            // Merge Sort
            int[] mergeArray = copyArray(array);

            startTime = System.nanoTime();
            int mergeComparisons = mergeSort(
                    mergeArray,
                    0,
                    mergeArray.length - 1
            );
            endTime = System.nanoTime();

            long mergeTime = endTime - startTime;

            System.out.println("Merge Sort:");
            System.out.println("Comparisons: " + mergeComparisons);
            System.out.println("Time: " + mergeTime + " ns");


            // Insertion Sort
            int[] insertionArray = copyArray(array);

            startTime = System.nanoTime();
            int insertionComparisons = insertionSort(insertionArray);
            endTime = System.nanoTime();

            long insertionTime = endTime - startTime;

            System.out.println("Insertion Sort:");
            System.out.println("Comparisons: " + insertionComparisons);
            System.out.println("Time: " + insertionTime + " ns");


            // Quick Sort
            int[] quickArray = copyArray(array);

            startTime = System.nanoTime();
            int quickComparisons = quickSort(
                    quickArray,
                    0,
                    quickArray.length - 1
            );
            endTime = System.nanoTime();

            long quickTime = endTime - startTime;

            System.out.println("Quick Sort:");
            System.out.println("Comparisons: " + quickComparisons);
            System.out.println("Time: " + quickTime + " ns");

            System.out.println();
        }


        // ==========================================
        // ALMOST-SORTED 100-ELEMENT TEST
        // ==========================================

        System.out.println("Almost-Sorted 100-Element Test:");

        int[] almostSorted = new int[100];

        for (int i = 0; i < almostSorted.length; i++) {
            almostSorted[i] = (int) (Math.random() * 1000);
        }

        // First sort the array into ascending order
        selectionSort(almostSorted);

        // Swap five neighboring pairs

        int temp;

        temp = almostSorted[0];
        almostSorted[0] = almostSorted[1];
        almostSorted[1] = temp;

        temp = almostSorted[2];
        almostSorted[2] = almostSorted[3];
        almostSorted[3] = temp;

        temp = almostSorted[4];
        almostSorted[4] = almostSorted[5];
        almostSorted[5] = temp;

        temp = almostSorted[6];
        almostSorted[6] = almostSorted[7];
        almostSorted[7] = temp;

        temp = almostSorted[8];
        almostSorted[8] = almostSorted[9];
        almostSorted[9] = temp;

        System.out.println("Almost-sorted array created.");


        // ------------------------------------------
        // Almost-Sorted Selection Sort
        // ------------------------------------------

        int[] almostSelection = copyArray(almostSorted);

        long almostStartTime = System.nanoTime();

        int almostSelectionComparisons =
                selectionSort(almostSelection);

        long almostEndTime = System.nanoTime();

        long almostSelectionTime =
                almostEndTime - almostStartTime;

        System.out.println("Selection Sort:");
        System.out.println("Comparisons: " + almostSelectionComparisons);
        System.out.println("Time: " + almostSelectionTime + " ns");


        // ------------------------------------------
        // Almost-Sorted Insertion Sort
        // ------------------------------------------

        int[] almostInsertion = copyArray(almostSorted);

        almostStartTime = System.nanoTime();

        int almostInsertionComparisons =
                insertionSort(almostInsertion);

        almostEndTime = System.nanoTime();

        long almostInsertionTime =
                almostEndTime - almostStartTime;

        System.out.println("Insertion Sort:");
        System.out.println("Comparisons: " + almostInsertionComparisons);
        System.out.println("Time: " + almostInsertionTime + " ns");


        // ------------------------------------------
        // Almost-Sorted Merge Sort
        // ------------------------------------------

        int[] almostMerge = copyArray(almostSorted);

        almostStartTime = System.nanoTime();

        int almostMergeComparisons =
                mergeSort(
                        almostMerge,
                        0,
                        almostMerge.length - 1
                );

        almostEndTime = System.nanoTime();

        long almostMergeTime =
                almostEndTime - almostStartTime;

        System.out.println("Merge Sort:");
        System.out.println("Comparisons: " + almostMergeComparisons);
        System.out.println("Time: " + almostMergeTime + " ns");


        // ------------------------------------------
        // Almost-Sorted Quick Sort
        // ------------------------------------------

        int[] almostQuick = copyArray(almostSorted);

        almostStartTime = System.nanoTime();

        int almostQuickComparisons =
                quickSort(
                        almostQuick,
                        0,
                        almostQuick.length - 1
                );

        almostEndTime = System.nanoTime();

        long almostQuickTime =
                almostEndTime - almostStartTime;

        System.out.println("Quick Sort:");
        System.out.println("Comparisons: " + almostQuickComparisons);
        System.out.println("Time: " + almostQuickTime + " ns");
    }


    // ==========================================
    // COPY ARRAY
    // ==========================================

    public static int[] copyArray(int[] array) {

        int[] copy = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        return copy;
    }


    // ==========================================
    // SELECTION SORT
    // ==========================================

    public static int selectionSort(int[] array) {

        int n = array.length;
        int comparisons = 0;

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                comparisons++;

                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        return comparisons;
    }


    // ==========================================
    // INSERTION SORT
    // ==========================================

    public static int insertionSort(int[] array) {

        int n = array.length;
        int comparisons = 0;

        for (int i = 1; i < n; i++) {

            int temp = array[i];
            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (array[j] > temp) {

                    array[j + 1] = array[j];
                    j = j - 1;

                } else {

                    break;
                }
            }

            array[j + 1] = temp;
        }

        return comparisons;
    }


    // ==========================================
    // MERGE SORT
    // ==========================================

    public static int mergeSort(
            int[] array,
            int lb,
            int ub) {

        if (lb < ub) {

            int mid = (lb + ub) / 2;

            int comparisons = 0;

            comparisons += mergeSort(array, lb, mid);

            comparisons += mergeSort(
                    array,
                    mid + 1,
                    ub
            );

            comparisons += merge(
                    array,
                    lb,
                    mid,
                    ub
            );

            return comparisons;
        }

        return 0;
    }


    public static int merge(
            int[] array,
            int lb,
            int mid,
            int ub) {

        int[] newArray = new int[array.length];

        int i = lb;
        int j = mid + 1;
        int k = lb;

        int comparisons = 0;

        while (i <= mid && j <= ub) {

            comparisons++;

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

        return comparisons;
    }


    // ==========================================
    // QUICK SORT
    // ==========================================

    public static int quickSort(
            int[] array,
            int start,
            int end) {

        int comparisons = 0;

        if (start < end) {

            int pivot = start;

            int i = start;
            int j = end;


            while (i < j) {

                while (i < end) {

                    comparisons++;

                    if (array[i] <= array[pivot]) {

                        i = i + 1;

                    } else {

                        break;
                    }
                }


                while (array[j] > array[pivot]) {

                    comparisons++;

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


            comparisons += quickSort(
                    array,
                    start,
                    j - 1
            );

            comparisons += quickSort(
                    array,
                    j + 1,
                    end
            );
        }

        return comparisons;
    }
}