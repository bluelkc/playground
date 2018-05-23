package sort;

import java.util.Comparator;

/**
 * Created by kecen on 10/5/18.
 */
public class MergeSorter implements Sorter {

    public void sort(Object[] list) {
        sort(list, null);
    }

    public void sort(Object[] list, Comparator c) {

        mergeSort(list, 0, list.length - 1, c);
    }

    private void mergeSort(Object[] list, int start, int end) {

    }

    private void mergeSort(Object[] list, int start, int end, Comparator c) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(list, start, mid, c);
        mergeSort(list, mid + 1, end, c);
        mergeHalves(list, start, end, c);
    }

    private void mergeHalves(Object[] list, int start, int end, Comparator c) {
        Object[] tmp = new Object[list.length];
        int mid = (start + end) / 2;
        int leftPos = start;
        int rightPos = mid + 1;
        int index = start;

        while (leftPos <= mid && rightPos <= end) {
            if (c.compare(list[leftPos], list[rightPos]) > 0) {
                tmp[index] = list[rightPos];
                rightPos ++;
            } else {
                tmp[index] = list[leftPos];
                leftPos ++;
            }
            index ++;
        }

        System.arraycopy(list, rightPos, tmp, index, end - rightPos + 1);
        System.arraycopy(list, leftPos, tmp, index, mid - leftPos + 1);
        System.arraycopy(tmp, start, list, start, end - start + 1);
    }
}
