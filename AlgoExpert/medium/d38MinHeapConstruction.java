package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d38MinHeapConstruction {
    List<Integer> heap;

    public d38MinHeapConstruction(List<Integer> array) {
        heap = buildHeap(array);
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

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(
                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));

        d38MinHeapConstruction heapImplementation = new d38MinHeapConstruction(array);
        System.out.println(array);

        List<Integer> array2 = new ArrayList<>(
                Arrays.asList(2,3,1));

        d38MinHeapConstruction heapImplementation2 = new d38MinHeapConstruction(array2);
        System.out.println(array2);
    }
}
