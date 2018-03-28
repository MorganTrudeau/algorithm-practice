package com.example.morgantrudeau.algorithm;

/**
 * Created by morgantrudeau on 2018-03-27.
 */

public class MergeSort {

    public static void main(String[] args) {
        int[] array = constructRandomArray(10);
        mergeSort(array);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length -1);
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, temp, left, middle);
        mergeSort(array, temp, middle + 1, right);
        merge(array, temp, left, right);
    }

    private static void merge(int[] array, int[] temp, int left, int right) {
        int middle = (left + right) / 2;
        int leftPointer = left;
        int leftEnd = middle;
        int rightPointer = middle + 1;
        int rightEnd = right;
        int index = left;

        System.out.println("left half");
        printArray(array,left,middle);
        System.out.println("right half");
        printArray(array,middle+1,right);

        while(leftPointer <= leftEnd && rightPointer <= rightEnd) {

            if(array[leftPointer] <= array[rightPointer]) {
                temp[index] = array[leftPointer];
                leftPointer++;

                System.out.println("insert from left");
                printArray(temp,left,right);
            }
            else {
                temp[index] = array[rightPointer];
                rightPointer++;

                System.out.println("insert from right");
                printArray(temp,left,right);
            }
            index++;
        }

        copyRemaining(array, temp, leftPointer, leftEnd, index);
        copyRemaining(array, temp, rightPointer, rightEnd, index);
        copyRemaining(temp, array, left, right, left);

        System.out.println("after copy");
        printArray(array, left, right);
        System.out.println(" ");
    }

    private static void copyRemaining(int[] from, int[] to, int start, int end, int index) {
        for(int i=start; i<end+1; i++) {
            to[index] = from[i];
            index++;
        }
    }

    /** Helper Functions **/

    private static void printArray(int[] array, int start, int end) {
        String result = "";
        for(int i=0;i<array.length;i++) {
            if(i==start) {
                result += "| ";
            }
            result += array[i] + " ";
            if(i==end) {
                result += "| ";
            }
        }
        System.out.println(result);
    }

    private static int[] constructRandomArray(int length) {
        int[] array = new int[length];
        for(int i=0; i<length; i++) {
            array[i] = (int)(Math.random()*100);
        }
        return array;
    }
}
