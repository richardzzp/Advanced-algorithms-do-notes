package 第一次课堂练习;

import java.util.*;

public class 按照数值个数排序 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T=Integer.parseInt(scn.nextLine());

        for(int x=0;x<T;x++) {
            int N = Integer.parseInt(scn.nextLine());
            if(N==0) {
                scn.nextLine();
                System.out.println("");
                continue;
            }
            String in=scn.nextLine().replace(" ","");
            String res=frequencySort(in);
            for(int i=0;i<res.length()-1;i++){
                System.out.print(res.charAt(i)+" ");
            }
            System.out.println(res.charAt(res.length()-1));
        }
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
