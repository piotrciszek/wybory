package wybory;

import java.util.*;

public class dHondt {
    public static void main(String[] args) {
        int chairs = 20;
        int votes1 = 480;
        int votes2 = 360;
        int votes3 = 160;
        int parties = 3;
        String name1 = "A";
        String name2 = "B";
        String name3 = "C";
        String[] partiesName = new String[]{name1, name2, name3};
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        List<Integer> listVotes1 = new ArrayList<Integer>();
        List<Integer> listVotes2 = new ArrayList<Integer>();
        List<Integer> listVotes3 = new ArrayList<Integer>();
        for (int i = 1; i <= chairs; i++) {
            listVotes1.add(votes1/i);
            listVotes2.add(votes2/i);
            listVotes3.add(votes3/i);
        }
        for (Integer z : listVotes1) {
            System.out.println(z);
        }
        map.put(name1, listVotes1);
        map.put(name2, listVotes2);
        map.put(name3, listVotes3);

        System.out.println(map.get(name1));
        System.out.println(map.get(name2));
        System.out.println(map.get(name3));




    }
}
