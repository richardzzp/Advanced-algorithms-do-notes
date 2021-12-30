package 第一次课堂练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 二叉树 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int group = sr.nextInt();
        for (int g = 0; g < group; ++g) {
            int size = sr.nextInt();
            int level = 0;
            int curIndex = 0;
            List<Integer> tmp;
            while (curIndex < size) {
                tmp = new ArrayList<>();
                for (int i = 0; i < Math.pow(2, level) && curIndex < size; ++i) {
                    int t = sr.nextInt();
                    if (!tmp.contains(t)) {
                        tmp.add(t);
                    }
                    curIndex++;
                }
                Collections.sort(tmp);
                for (int i = 0; i < tmp.size(); ++i) {
                    if (i != tmp.size() - 1) {
                        System.out.print(tmp.get(i) + " ");
                    }
                    else {
                        System.out.println(tmp.get(i));
                    }
                }
                level++;
            }
        }
    }
}

