import edu.princeton.cs.algs4.StdRandom;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable> {

    private void merge(List<T> arr, int start, int end, int k) {
        if (end - start <= 0) {
            return;
        }
        List<T> aux = new ArrayList<>();
        int a = start;
        int b = k;
        while (a < k || b <= end) {
            if (a == k) {
                aux.add(arr.get(b++));
            } else if (b > end) {
                aux.add(arr.get(a++));
            } else if (arr.get(b).compareTo(arr.get(a)) > 0) {
                aux.add(arr.get(a++));
            } else {
                aux.add(arr.get(b++));
            }
        }
        for (int i = 0; i < aux.size(); ++i) {
            arr.set(start + i, aux.get(i));
        }
    }

    private void mergeSort(List<T> arr, int start, int end) {
        int k = end - (end - start) / 2;
        if (end - start > 0) {
            mergeSort(arr, start, k - 1);
            mergeSort(arr, k, end);
        }
        merge(arr, start, end, k);
    }

    private void nonRecursiveMergeSort(List<T> arr, int start, int end) {
        int k = 1;
        while (k < end) {
            for (int i = 0; i <= end; i = i + 2 * k) {
                int newEnd = i + 2 * k - 1;
                int newK = k;
                if (newEnd > end) {
                    newEnd = end;
                }
                if( i + newK > newEnd){
                    continue;
                }
                merge(arr, i, newEnd, i + newK);
            }
            k *= 2;
        }
    }

    public void verifySort(List<T> list) {
        T prev = null;
        int index = 0;
        for (T item : list) {
            if (prev != null && prev.compareTo(item) > 0) {
                throw new InvalidStateException("Sorting not correct at index: " + index);
            }
            System.out.println(item);
            prev = item;
            ++index;
        }
    }

    public void doit(List<T> arr, boolean recursive) {
        if (recursive) {
            mergeSort(arr, 0, arr.size() - 1);
        } else {
            nonRecursiveMergeSort(arr, 0, arr.size() - 1);
        }
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 19721; ++i) {
            list.add(StdRandom.uniform(1, 10000000));
        }
        MergeSort<Integer> m = new MergeSort<>();
        m.doit(list, false);
        m.verifySort(list);
    }
}
