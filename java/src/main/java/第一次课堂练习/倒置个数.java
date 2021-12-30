package 第一次课堂练习;

import java.util.Arrays;
import java.util.Scanner;

public class 倒置个数 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T=Integer.parseInt(scn.nextLine());

        for(int x=0;x<T;x++) {
            int N = Integer.parseInt(scn.nextLine());
            if(N==0) {
                scn.nextLine();
                System.out.println(0);
                continue;
            }
            int[] arr= Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int inversionCount = mergeSort(arr, 0, arr.length);

            System.out.println(inversionCount);
        }

    }

    public static int mergeSort(int[] arr, int start, int end) {
        int inversionCount = 0;
        int length = end - start;
        if (length > 1) { // 长度大于1才需要排序
            int mid = (start + end) / 2;
            inversionCount += mergeSort(arr, start, mid); // sort left
            inversionCount += mergeSort(arr, mid, end); // sort right
            inversionCount += merge(arr, start, mid, end);
        }
        return inversionCount;
    }

    public static int merge(int[] arr, int start, int mid, int end) {
        // check input
        if (arr == null || start < 0 || end > arr.length) {
            return 0;
        }
        int[] temp = new int[end - start];
        int inversionCount = 0;
        int i = start; // 左半部分索引
        int j = mid; // 右半部分索引
        int k = 0; // temp数组索引
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // 一旦 arr[i] > arr[j]，就会有 (mid - i) 个逆序对产生
                inversionCount += mid - i;
            }
        }
        if (i != mid) {
            System.arraycopy(arr, i, temp, k, mid - i);
        }
        if (j != end){
            System.arraycopy(arr, j, temp, k, end - j);
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
        return inversionCount;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}