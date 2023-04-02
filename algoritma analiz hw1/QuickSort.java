import java.util.Random;

public class QuickSort {
    public void sortfirstelement(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionfirstelement(arr, low, high);
            sortfirstelement(arr, low, pivotIndex - 1);
            sortfirstelement(arr, pivotIndex + 1, high);
        }
    }

    private int partitionfirstelement(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] > pivot) {
                j--;
            } else {
                swapfirstelement(arr, i, j);
            }
        }
        swapfirstelement(arr, low, j);
        return j;
    }

    private void swapfirstelement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private Random random = new Random();

    public void sortrandomelement(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionrandomelement(arr, low, high);
            sortrandomelement(arr, low, pivotIndex - 1);
            sortrandomelement(arr, pivotIndex + 1, high);
        }
    }

    public void sortWithRandomPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionWithRandomPivot(arr, low, high);
            sortrandomelement(arr, low, pivotIndex - 1);
            sortrandomelement(arr, pivotIndex + 1, high);
        }
    }

    private int partitionrandomelement(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] > pivot) {
                j--;
            } else {
                swaprandomelement(arr, i, j);
            }
        }
        swaprandomelement(arr, low, j);
        return j;
    }

    private int partitionWithRandomPivot(int[] arr, int low, int high) {
        int pivotIndex = random.nextInt(high - low + 1) + low;
        int pivot = arr[pivotIndex];
        swaprandomelement(arr, low, pivotIndex);
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] > pivot) {
                j--;
            } else {
                swaprandomelement(arr, i, j);
            }
        }
        swaprandomelement(arr, low, j);
        return j;
    }

    private void swaprandomelement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortWithMidOfFirstMidLastElementPivot(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionWithMidOfFirstMidLastElementPivot(arr, low, high);
            sortWithMidOfFirstMidLastElementPivot(arr, low, pivotIndex - 1);
            sortWithMidOfFirstMidLastElementPivot(arr, pivotIndex + 1, high);
        }
    }

    private int partitionWithMidOfFirstMidLastElementPivot(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int first = arr[low];
        int middle = arr[mid];
        int last = arr[high];

        int pivot;
        if ((first <= middle && middle <= last) || (last <= middle && middle <= first)) {
            pivot = middle;
            swap(arr, mid, low);
        } else if ((middle <= first && first <= last) || (last <= first && first <= middle)) {
            pivot = first;
        } else {
            pivot = last;
            swap(arr, high, low);
        }

        int i = low + 1;
        int j = high;
        while (i < j) {
            while (i < high && arr[i] <= pivot) {
                i++;
            }
            while (j > low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
