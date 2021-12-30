package 第三次课堂练习;

import java.util.Arrays;
import java.util.Scanner;

public class 区间第K最小 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T=Integer.parseInt(scn.nextLine());

        for(int x=0;x<T;x++) {
            int[] in= Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] fromTo=Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int K=Integer.parseInt(scn.nextLine());
            int[] sp=new int[fromTo[1]-fromTo[0]+1];
            System.arraycopy(in,fromTo[0]-1,sp,0,fromTo[1]-fromTo[0]+1);
            Arrays.sort(sp);
            System.out.println(sp[K-1]);
        }
    }
}
