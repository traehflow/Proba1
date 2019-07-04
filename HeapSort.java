import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends Comparable<T>> extends Heap<T> {

    private int size;

    @Override
    protected int size(){
        return size;
    }

    public HeapSort(List<T> items){
        super(items, true);
        this.size = items.size();
        heapify();

        while(this.size > 0){
            this.swap(0, this.size() - 1);
            this.size--;
            this.sink(0);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9999; ++i) {
            list.add(StdRandom.uniform(100000, 999999));
        }

        HeapSort h = new HeapSort(list);
        System.out.println("============== START =================");
        for (Object in : list) {
            System.out.println(in);
        }
        System.out.println("======================================");

    }
}
