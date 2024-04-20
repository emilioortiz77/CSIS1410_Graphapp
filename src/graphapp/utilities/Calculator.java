package graphapp.utilities;

import graphapp.models.OrderedPair;
import graphapp.models.TimeFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public List<OrderedPair> convertListToOrderedPairs(List<String> list, TimeFrame timeFrame) {
        ArrayList<OrderedPair> orderedPairs = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<Integer>();

        Object[] distinctList = list.stream().distinct().toArray();

        for (int i = 0; i < distinctList.length; i++) {
            countList.add(instanceCount(list, timeFrame, (String) distinctList[i]));
        }

        for (int i = 0; i < distinctList.length; i++) {
            orderedPairs.add(new OrderedPair(i, countList.get(i), String.format("%s", distinctList[i])));
        }

        return orderedPairs;
    }

    private int instanceCount(List<String> list, TimeFrame timeFrame, String item) {
        int count = 0;

        switch (timeFrame) {
            case DAILY:
                // This looks for each hour
                String c = item.substring(0, 13);

                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).substring(0, 13));
                    if (list.get(i).substring(0, 13).equals(item.substring(0, 13))) {
                        count += 1;
                    }
                }

                break;
            case MONTH:
                // This looks for days in a month?
                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i).substring(0, 10));
                    if (list.get(i).substring(0, 10).equals(item.substring(0, 10))) {
                        count += 1;
                    }
                }
                break;

            case YEAR:
                // This looks months in a year
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).substring(0, 7).equals(item.substring(0, 7))) {
                        count += 1;
                    }
                }

                break;
            default:

                break;
        }


        return count;
    }
}
