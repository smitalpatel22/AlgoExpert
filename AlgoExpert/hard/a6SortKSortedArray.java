package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a6SortKSortedArray {

    //Optimal approach:
    //Time : nlog(k) || Space : k
    //For 0th index, we will have to look till 0+3 or 0-3 indices for correct sorted element.
    //For 1st index, we look till 1-3 & 1+3 indices including 1st index. But we exclude the element which we already put in 0th index.
    //3, 2, 1, 5, 4|| 7, 6, 5
    //   |         |-> for i=1, look to the left of this partion as k=3 and also exlude element 1 as it was already used to place in 0th index
    //So for 1st index we will look for 4 postions (0th sorted element excluded)
    ///So for each element, we will have to look only k+1 element
    //for maintaining this k+1 elements & finding minimum from them, we can use min-heap.
    //So we can start with puting first k+1 elements.
    //Each time, we can get a minimum element from min-heap(1 time complexity), we can remove it and put it in the input array at index sortedIndex=0++
    //Next time we can add the new element in heap.
    //To add & remove element to & from heap, it is 2*log(k+1)~log(k) time.
    //Also initializing our heap = +k time ==> 2*log(k+1) + k ~~ log(k)+n ~~ log(k)+1 ~~ log(k)   ==> why we can remove +k is k<=n
    //And we have to iterate over our input array ==> n*2(log(k+1))+k ~~ n*log(k)
    //Space : k+1 ~~ k  in heap
    public static int[] sortKSortedArray(int[] array, int k) {

        List<Integer> heapValues = new ArrayList<>();
        for (int i = 0; i < Math.min(k+1, array.length); i++) {
            heapValues.add(array[i]);
        }
        MinHeap heap = new MinHeap(heapValues);

        int nextIndexToInsertElement = 0;
        for (int idx = k+1; idx < array.length; idx++) {
            int minElement = heap.remove();
            array[nextIndexToInsertElement++] = minElement;
            int currentElement = array[idx];
            heap.insert(currentElement);
        }

        while (!heap.isEmpty()) {
            array[nextIndexToInsertElement++] = heap.remove();
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;
        System.out.println(sortKSortedArray(array, k));
    }

    static class MinHeap {
        List<Integer> heap;

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int endIdx = array.size()-1;

            int firstParentIdx = getParent(endIdx);

            for(int currentIdx = firstParentIdx; currentIdx>=0; currentIdx--) {
                siftDown(currentIdx, endIdx, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int child1Idx = getChild1(currentIdx);


            while(child1Idx <=endIdx) {             //not to process if the current node is a leaf node coz we cannot sift it any more
                int child2Idx = getChild2(currentIdx)<=endIdx ? getChild2(currentIdx) : -1;
                int idxToSwap;
                if(child2Idx!=-1 && heap.get(child2Idx) < heap.get(child1Idx)) {
                    idxToSwap = child2Idx;
                } else {
                    idxToSwap = child1Idx;
                }
                if(heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(idxToSwap, currentIdx, heap);
                    currentIdx = idxToSwap;
                    child1Idx = getChild1(currentIdx);          //to keep the while loop updated
                } else {
                    break;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parent = getParent(currentIdx);

            while (currentIdx>0 && heap.get(parent) > heap.get(currentIdx)) {
                swap(parent, currentIdx, heap);
                currentIdx = parent;
                parent = getParent(currentIdx);
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size()-1, heap);
            int removedElement = heap.remove(heap.size() - 1);
            siftDown(0, heap.size()-1, heap);
            return removedElement;
        }

        public void insert(int value) {
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

        public void swap(int i, int j, List<Integer> heap) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

}
