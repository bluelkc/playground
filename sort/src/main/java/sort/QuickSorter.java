package sort;

import java.util.Comparator;

/**
 * Created by kecen on 3/5/18.
 */
public class QuickSorter implements Sorter {

    public void sort(Object[] list) {
        sort(list, null);
    }

    public void sort(Object[] list, Comparator c) {

        if (c == null)
            quickSort(list, 0, list.length - 1);
        else
            quickSort(list, 0, list.length - 1, c);
    }

    private static void quickSort(Object[] list, int start, int end, Comparator c) {

        if (end <= start) {
            return;
        }
        int pivot = (start + end) / 2;
        int index = partition(list, start, end, pivot, c);
        quickSort(list, start, index - 1, c);
        quickSort(list, index, end, c);
    }

    private static void quickSort(Object[] list, int start, int end) {

    }

    private static int partition(Object[] list, int start, int end, int pivot, Comparator c) {

        while (start <= end) {
            while (c.compare(list[start], list[pivot]) < 0) {
                start ++;
            }
            while (c.compare(list[end], list[pivot]) > 0) {
                end --;
            }
            if (start <= end) {
                swap(list, start, end);
                start ++;
                end --;
            }
        }

        return start;
    }

    private static int partition(Object[] list, int start, int end, int pivot) {

        return start;
    }

    private static void swap(Object[] list, int pos1, int pos2) {
        Object tmp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = tmp;
    }
}
