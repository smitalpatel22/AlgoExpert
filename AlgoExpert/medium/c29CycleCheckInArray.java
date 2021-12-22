package com.algoexpert.medium;

public class c29CycleCheckInArray {

    public static boolean hasSingleCycle1(int[] array) {
        int visited = 0;
        int currentIdx = 0;

        while(visited < array.length) {
            if(visited>0 && currentIdx==0) {
                return false;
            }
            visited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int nextElement = array[currentIdx];
        int nextId = (currentIdx+nextElement)%array.length;
        return nextId>=0 ? nextId : array.length + nextId;
    }

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int counter = 0;
        int i=0;
        while(counter<array.length) {
            counter++;
            int temp=array[i];
            array[i]=0;
            int cc=0;
            if(temp>0) {
                while(cc<temp) {
                    cc += 1;
                    if(1+i<array.length) {
                        i = i + 1;
                    } else {
                        i=-1;
                        i = i + 1;
                    }
                }
            } else if(temp<0) {
                while(cc>temp) {
                    cc -= 1;
                    if(i-1>=0) {
                        i = i - 1;
                    } else {
                        i=array.length;
                        i = i - 1;
                    }
                }
            }

            if((array[i] == 0 && i!=0) || (i==0 && counter<array.length)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2}));
        System.out.println(hasSingleCycle1(new int[]{1,-1,1,-1}));
        System.out.println(hasSingleCycle1(new int[]{2, 3, 1, -1, -4, 2}));
        System.out.println(hasSingleCycle1(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
    }

}
