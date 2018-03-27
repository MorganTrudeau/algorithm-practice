package com.example.morgantrudeau.algorithm;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = constructRandomArray(10);
        quickSort(array);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left + right)/2];
        int partition = partition(array, left, right, pivot);
        quickSort(array, left, partition - 1);
        quickSort(array, partition, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        /** Following two ints used only for visualization in console */
        int leftWall = left;
        int rightWall = right;

        while(left <= right) {

            while(array[left] < pivot) {
                left++;
            }

            while(array[right] > pivot) {
                right--;
            }

            if(left <= right) {
                printArray(array, left, right, leftWall, rightWall, pivot);
                swap(array, left, right);
                printArray(array, left, right, leftWall, rightWall, pivot);
                left++;
                right--;
            }
        }
        return left;
    }

    /** Helper Functions **/

    private static int[] swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

    private static void printArray(int[] array, int less, int great, int left, int right, int pivot) {
        String result = "privot of " + pivot + " : ";
        for(int i=0;i<array.length;i++) {
            if(i == left) {
                result += "|| ";
            }
            if(i == less || i == great) {
                result += "(" + array[i] + ") ";
            } else {
                result += array[i] + " ";
            }
            if(i == right) {
                result += "|| ";
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
