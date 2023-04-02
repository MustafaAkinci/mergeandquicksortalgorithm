import java.util.*;

public class SortingClass {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("enter the size of the array(for example if you want 1000 then type 1000): ");
        int arraysize = sc1.nextInt();
        int[] arr = new int[arraysize];
        System.out.println("select the fill format of the array(for example type 2 for random integer type)");
        System.out.println("1-Equal integers");
        System.out.println("2-Random integers");
        System.out.println("3-Increasing integers");
        System.out.println("4-Decreasing integers");
        Scanner sc2 = new Scanner(System.in);
        int choose1 = sc2.nextInt();
        int number = 3;
        if (choose1 == 1) {
            System.out.println("1-Equal integers");
            for (int i = 0; i < arraysize; i++) {
                arr[i] = number;
            }
        } else if (choose1 == 2) {
            System.out.println("2-Random integers");
            Random rnd = new Random();
            for (int i = 0; i < arraysize; i++) {
                arr[i] = rnd.nextInt(arraysize);
            }
        } else if (choose1 == 3) {
            System.out.println("3-Increasing integers");
            int begin = 1;
            for (int i = 0; i < arraysize; i++) {
                arr[i] = begin + i;
            }
        } else if (choose1 == 4) {
            System.out.println("4-Decreasing integers");
            int end = arraysize;
            for (int i = 0; i < arraysize; i++) {
                arr[i] = end - i;
            }
        } else {
            System.out.println("Wrong select");
        }
        System.out.println("choose sorting algorithm(for example, type 3 for quicksort first element type)");
        System.out.println("1-Merge sort 2");
        System.out.println("2-Merge sort 3");
        System.out.println("3-Quick sort first element");
        System.out.println("4-Quick sort random element");
        System.out.println("5-Quick sort MidOfFirstMidLastElement");
        Scanner sc3 = new Scanner(System.in);
        int choose2 = sc3.nextInt();
        if (choose2 == 1) {
            System.out.println("1-Merge sort 2");
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort2(arr, 0, arr.length - 1);
            System.out.println("Merge sort 2: " + Arrays.toString(arr));
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sorting took " + estimatedTime + " milliseconds.");

        } else if (choose2 == 2) {
            System.out.println("2-Merge sort 3");
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort3(arr, 0, arr.length - 1);
            System.out.println("Merge sort 3: " + Arrays.toString(arr));
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sorting took " + estimatedTime + " milliseconds.");

        } else if (choose2 == 3) {
            System.out.println("3-Quick sort first element");
            long startTime = System.currentTimeMillis();
            QuickSort quickSortfirstelement = new QuickSort();
            quickSortfirstelement.sortfirstelement(arr, 0, arr.length - 1);
            System.out.println("Quick sort first element: " + Arrays.toString(arr));
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sorting took " + estimatedTime + " milliseconds.");

        } else if (choose2 == 4) {
            System.out.println("4-Quick sort random element");
            long startTime = System.currentTimeMillis();
            QuickSort quickSortrandomelement = new QuickSort();
            quickSortrandomelement.sortWithRandomPivot(arr, 0, arr.length - 1);
            System.out.println("Quick sort random element: " + Arrays.toString(arr));
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sorting took " + estimatedTime + " milliseconds.");
        } else if (choose2 == 5) {
            System.out.println("5-Quick sort MidOfFirstMidLastElement");
            long startTime = System.currentTimeMillis();
            QuickSort quickSortMidOfFirstMidLastElement = new QuickSort();
            quickSortMidOfFirstMidLastElement.sortWithMidOfFirstMidLastElementPivot(arr, 0, arr.length - 1);
            System.out.println("Quick sort MidOfFirstMidLastElement: " + Arrays.toString(arr));
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("Sorting took " + estimatedTime + " milliseconds.");
        } else {
            System.out.println("Wrong select");
        }

        sc1.close();
        sc2.close();
        sc3.close();

    }
}
