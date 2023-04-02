import java.util.*;

public class MergeSort {
    public static void merge(int[] arr, int left, int middle, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, middle + 1);
        int[] rightArr = Arrays.copyOfRange(arr, middle + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void mergeSort2(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort2(arr, left, middle);
            mergeSort2(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void mergeSort3(int[] arr, int start, int end) {
        if (end - start < 3) {
            if (end - start == 2) {
                if (arr[start] > arr[start + 1]) {
                    int temp = arr[start];
                    arr[start] = arr[start + 1];
                    arr[start + 1] = temp;
                }
            }
            return;
        }

        int mid1 = start + (end - start) / 3;
        int mid2 = start + 2 * (end - start) / 3;

        mergeSort3(arr, start, mid1);
        mergeSort3(arr, mid1, mid2);
        mergeSort3(arr, mid2, end);

        int[] temp = new int[end - start];
        int i = start, j = mid1, k = mid2, p = 0;

        while (i < mid1 && j < mid2 && k < end) {
            if (arr[i] < arr[j]) {
                if (arr[i] < arr[k]) {
                    temp[p++] = arr[i++];
                } else {
                    temp[p++] = arr[k++];
                }
            } else {
                if (arr[j] < arr[k]) {
                    temp[p++] = arr[j++];
                } else {
                    temp[p++] = arr[k++];
                }
            }
        }

        while (i < mid1 && j < mid2) {
            if (arr[i] < arr[j]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[j++];
            }
        }

        while (j < mid2 && k < end) {
            if (arr[j] < arr[k]) {
                temp[p++] = arr[j++];
            } else {
                temp[p++] = arr[k++];
            }
        }

        while (i < mid1 && k < end) {
            if (arr[i] < arr[k]) {
                temp[p++] = arr[i++];
            } else {
                temp[p++] = arr[k++];
            }
        }

        while (i < mid1) {
            temp[p++] = arr[i++];
        }

        while (j < mid2) {
            temp[p++] = arr[j++];
        }

        while (k < end) {
            temp[p++] = arr[k++];
        }

        System.arraycopy(temp, 0, arr, start, end - start);
    }

}