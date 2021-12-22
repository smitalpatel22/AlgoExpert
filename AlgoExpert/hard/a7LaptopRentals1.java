package com.algoexpert.hard;

import java.util.*;

public class a7LaptopRentals1 {

    public static int laptopRentals(ArrayList<ArrayList<Integer>> times) {

        if(times.size() == 0) {
            return 0;
        }

//        Collections.sort(times, (a,b) -> Integer.compare(a.get(0), b.get(0)));
        Collections.sort(times, Comparator.comparingInt(a -> a.get(0)));

        ArrayList<ArrayList<Integer>> timesWhenLaptopIsUsed = new ArrayList<>();
        timesWhenLaptopIsUsed.add(times.get(0));

        MinHeap heap = new MinHeap(timesWhenLaptopIsUsed);
        for (int i = 1; i < times.size(); i++) {
            ArrayList<Integer> currentInterval = times.get(i);

            if(heap.peek().get(1) <= times.get(i).get(0)) {
                heap.remove();
            }
            heap.insert(currentInterval);
        }
        return timesWhenLaptopIsUsed.size();
    }

    public static void main(String[] args) {
        int[][] times = new int[][] {{0, 2}, {1, 4}, {4, 6}, {0, 4}, {7, 8}, {9, 11}, {3, 10}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int[] time : times) {
            input.add(new ArrayList(Arrays.asList(time[0], time[1])));
        }
        System.out.println(laptopRentals(input));
    }

    static class MinHeap {
        ArrayList<ArrayList<Integer>> heap = new ArrayList<>();

        public MinHeap(ArrayList<ArrayList<Integer>> array) {
            heap = buildHeap(array);
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public ArrayList<ArrayList<Integer>> buildHeap(ArrayList<ArrayList<Integer>> array) {
            int endIdx = array.size()-1;

            int firstParentIdx = getParent(endIdx);

            for(int currentIdx = firstParentIdx; currentIdx>=0; currentIdx--) {
                siftDown(currentIdx, endIdx, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, ArrayList<ArrayList<Integer>> heap) {
            int child1Idx = getChild1(currentIdx);


            while(child1Idx <=endIdx) {             //not to process if the current node is a leaf node coz we cannot sift it any more
                int child2Idx = getChild2(currentIdx)<=endIdx ? getChild2(currentIdx) : -1;
                int idxToSwap;
                if(child2Idx!=-1 && heap.get(child2Idx).get(1) < heap.get(child1Idx).get(1)) {
                    idxToSwap = child2Idx;
                } else {
                    idxToSwap = child1Idx;
                }
                if(heap.get(idxToSwap).get(1) < heap.get(currentIdx).get(1)) {
                    swap(idxToSwap, currentIdx, heap);
                    currentIdx = idxToSwap;
                    child1Idx = getChild1(currentIdx);          //to keep the while loop updated
                } else {
                    break;
                }
            }
        }

        public void siftUp(int currentIdx, ArrayList<ArrayList<Integer>> heap) {
            int parentIdx = getParent(currentIdx);

            while (currentIdx>0 && heap.get(parentIdx).get(1) > heap.get(currentIdx).get(1)) {
                swap(parentIdx, currentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = getParent(currentIdx);
            }
        }

        public ArrayList<Integer> peek() {
            return heap.get(0);
        }

        public ArrayList<Integer> remove() {
            swap(0, heap.size()-1, heap);
            ArrayList<Integer> removedElement = heap.remove(heap.size() - 1);
            siftDown(0, heap.size()-1, heap);
            return removedElement;
        }

        public void insert(ArrayList<Integer> value) {
            heap.add(value);
            siftUp(heap.size()-1, heap);
        }

        public int getChild1(int i) {
            return 2*i+1;
        }

        public int getChild2(int i) {
            return 2*i+2;
        }

        public int getParent(int i) {
            return (i-1)/2;
        }

        public void swap(int i, int j,  ArrayList<ArrayList<Integer>> heap) {
            ArrayList<Integer> temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

}
