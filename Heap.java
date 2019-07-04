import com.sun.xml.internal.ws.api.message.HeaderList;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Heap<T extends Comparable<T>> implements Iterable<T> {

    private List<T> items;
    int countCalls = 0;

    protected int size(){
        return items.size();
    }

    public Heap(List<T> items) {
        this.items = new ArrayList<>(items);
        heapify();
    }

    protected Heap(List<T> items, boolean inplace) {
        if(inplace){
            this.items = items;
        }
        heapify();
    }

    protected void heapify(){
        for (int i = this.size() ; i >= 0; --i) {
            this.sink(i);
        }
    }

    public Heap(){
        this.items = new ArrayList<>();
    }
    //10,    9, 8,   ,7,6,5,4, 3,2, 1
    //0,     1, 2,    3,4,5,6, 7,8, 9
    public T parent(int index) {
        return items.get(parentIndex(index));
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public T leftChild(int index) {
        return items.get(leftChildIndex(index));
    }

    public int leftChildIndex(int index) {
        return 2 * index + 1;
    }


    public T rightChild(int index) {
        return items.get(rightChildIndex(index));
    }

    public int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public void swap(int x, int y) {
        T swap = items.get(x);
        items.set(x, items.get(y));
        items.set(y, swap);
    }

    public T get(int index) {
        return items.get(index);
    }

    public void sink(int index) {
        ++countCalls;
        int n = this.size();


        int r = rightChildIndex(index);
        int l = leftChildIndex(index);

        int largest = index;
        if (l < n && get(l).compareTo(get(index)) > 0) {
            swap(index, l);
            largest = l;
            sink(largest);
        }
        if (r < n && get(r).compareTo(get(index)) > 0) {
            swap(index, r);
            largest = r;
            sink(largest);
        }
    }

    public boolean checkHeapIsValid() {
        for (int i = this.size() - 1; i > 0; --i) {
            if (!(parent(i).compareTo(get(i)) >= 0)) {
                return false;
            }
        }
        return true;
    }

    private void Swim(T t) {


    }

    public void add(T t) {
        items.add(t);
        int index = this.size() - 1;
        while (index > 0 && get(index).compareTo(parent(index)) > 0) {
            swap(index, parentIndex(index));
            index = parentIndex(index);

        }
    }

    public T pull() {
        this.swap(0, this.size() - 1);
        T t = this.items.get(this.size() - 1);
        this.items.remove(this.size() - 1);
        this.sink(0);
        return t;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9999; ++i) {
            list.add(StdRandom.uniform(1000, 9999));
        }

        Heap h = new Heap(list);
        System.out.println(h.checkHeapIsValid());
     /*   for (int i = list.size() / 2; i >= 0; --i) {
            h.sink(i);
        }*/

        System.out.println(h.checkHeapIsValid());
        System.out.println("Count calls: " + h.countCalls);
        System.out.println("Count calls ratio: " + h.countCalls / (double) h.size());
        h.add(5555);
        System.out.println(h.checkHeapIsValid());



        Heap<Integer> pq = new Heap<>();
        pq.add(45);
        pq.add(145);
        pq.add(75);
        pq.add(12);

        System.out.println("Pull: " + pq.pull());
        System.out.println("Pull: " + pq.pull());
        pq.add(94);
        System.out.println("Pull: " + pq.pull());
        System.out.println("Pull: " + pq.pull());
        pq.add(14);
        System.out.println("Pull: " + pq.pull());
        System.out.println("Pull: " + pq.pull());
        /*while (h.size > 0) {
            System.out.println(h.get(0));
            h.swap(0, h.items.size() - 1);
            h.items.remove(h.items.size() - 1);
            h.sink(0);
        }*/

    }


    private class HeapIterator implements Iterator<T>{

        T current;


        @Override
        public boolean hasNext() {
            return Heap.this.size() > 0;
        }

        @Override
        public T next() {
            return Heap.this.pull();
        }
    }
    @Override
    public Iterator iterator() {
        return new HeapIterator();
    }
}
