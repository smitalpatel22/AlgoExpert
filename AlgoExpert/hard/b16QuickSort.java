package com.algoexpert.hard;


public class b16QuickSort {


    //Time :
    //Worst : n^2 ==> If your pivot swap, divides array in 2 parts where 1 sub-array is of length one. And this happens every time.
    //Then effectively you are making n^2 operations or a bit less than n^2 operations each time.
    //Best : log(n) ==> If your pivot swap, divides each time your array exactly in half each time. So you will apply same logic on
    //left half & right half ==> So log(n)
    //Average : n(log(n))

    //Space : log(n)
    //to limit space to log(n), we have to limit call stack to log(n). That is why we have to keep applying our logic to
    //smaller length sub-array. If you do it on bigger subarray, then you may end up having n space occupied as big subarray,
    //then diving it, then dividing it & then getting size 1 sub-array & this sub-array call stack may occupy n space.
    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
        return array;
    }

    public static void quickSortHelper(int[] array, int startIdx, int endIdx) {

        if(startIdx>=endIdx)
            return;

        int pivotIdx = startIdx;
        int leftIdx = startIdx+1;
        int rightIdx = endIdx;

        while(leftIdx<=rightIdx) {
            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {     //Both left & right element are in wrong position to pivot
                swap(leftIdx, rightIdx, array);                                             //So swap them
            } else if(array[leftIdx] <= array[pivotIdx]) {          //leftIdx element is already smaller than pivot
                leftIdx++;                                          //so ignore & move to next leftIdx element
            } else if(array[rightIdx] >= array[pivotIdx]) {          //rightIdx element is already smaller than pivot
                rightIdx--;                                          //so ignore & move to next(prev) rightIdx element
            }
        }
        swap(pivotIdx, rightIdx, array);                             //everything done. Move to next pivot by swapping pivot & right element

        //below check is done to apply above logic(call recursive) first on smaller subarray to reduce time&space complexity
        boolean isLeftSubArraySmaller = (rightIdx-1) - startIdx < endIdx - (rightIdx+1);    //right-1 == end of left array & startIdx = start of left array
                                                                                            //right+1 == start of right array & endIdx = end of right array

        if(isLeftSubArraySmaller) {
            quickSortHelper(array, startIdx, rightIdx-1);
            quickSortHelper(array, rightIdx+1, endIdx);
        } else {
            quickSortHelper(array, rightIdx+1, endIdx);
            quickSortHelper(array, startIdx, rightIdx-1);
        }
    }

    public static void swap(int idx1, int idx2, int[] array) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }


}
