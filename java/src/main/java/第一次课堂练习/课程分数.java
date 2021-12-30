package 第一次课堂练习;

import java.util.*;

public class 课程分数 {

    public static class marks implements Comparable<marks>{
        int phy;
        int chem;
        int math;

        marks() {

        }

        marks(int phy,int chem,int math) {
            this.phy=phy;
            this.chem=chem;
            this.math=math;
        }

        public int compareTo(marks o) {
            if(this.phy != o.phy) {
                return this.phy - o.phy;
            }
            else if(this.chem != o.chem) {
                return o.chem - this.chem;
            }
            else {
                return this.math - o.math;
            }
        }
    }

    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        int N = phy.length;
        marks[]arr = new marks[N];

        for(int i=0; i < N;i++) {
            arr[i] = new marks(phy[i],chem[i],math[i]);
        }

        Arrays.sort(arr);

        for(int i=0; i < N;i++) {
            phy[i] = arr[i].phy;
            chem[i] = arr[i].chem;
            math[i] = arr[i].math;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int T=Integer.parseInt(scn.nextLine());

        for(int x=0;x<T;x++){
            int N=Integer.parseInt(scn.nextLine());

            int[]phy = new int[N];
            int[]chem = new int[N];
            int[]math = new int[N];

            for(int i=0;i<N;i++){
                int[] in=Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                phy[i]=in[0];
                chem[i]=in[1];
                math[i]=in[2];
            }
            customSort(phy,chem,math);

            //output
            for(int i=0; i < N;i++) {
                System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
            }

        }
    }
}
                        
                        
                        
                                