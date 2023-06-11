import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Katas {

    public static Boolean ArrayAddition(int[] arr) {
        Arrays.sort(arr);
        Integer largestNum = arr[arr.length-1];
        ArrayList<Integer> otherNumsList = Arrays
                .stream(Arrays.copyOfRange(arr, 0, arr.length-1))
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        Integer sum = 0;
        return recursionHelper(otherNumsList, largestNum, sum);
    }

    private static Boolean recursionHelper(ArrayList<Integer> otherNumsList, Integer largestNum, Integer sum) {
        if (otherNumsList.size() == 0) {
            return false;
        }
        for (int i = 0; i < otherNumsList.size(); i++) {
            ArrayList<Integer> otherNumsListLoop = otherNumsList.stream()
                            .collect(Collectors.toCollection(ArrayList<Integer>::new));
            Integer loopSum = sum + otherNumsListLoop.remove(i);
            if (loopSum == largestNum) {
                return true;
            }
            if (recursionHelper(otherNumsListLoop, largestNum, loopSum)) {
                return true;
            }
        }
        return false;
    }

    public static String ClosestEnemyII(String[] strArr) {

        int rowLength = strArr[0].length();
        int columnLength = strArr.length;

        int[] position1 = find1(strArr);
        ArrayList<int[]> position2 = find2(strArr);
        if (position2.size() == 0) {
            return "0";
        }
        ArrayList<Integer> distanceList = new ArrayList<Integer>();
        for (int i = 0; i < position2.size(); i++) {
            int[] currentPosition2 = position2.get(i);
            int rowDistanceNoWrap = Math.abs(currentPosition2[1]-position1[1]);
            int columnDistanceNoWrap = Math.abs(currentPosition2[0]-position1[0]);

            int position1DistanceFromLeft = position1[1];
            int position1DistanceFromRight = rowLength - position1[1] - 1;
            int position2DistanceFromLeft = currentPosition2[1];
            int position2DistanceFromRight = rowLength - currentPosition2[1] - 1;

            int rowDistanceWrap1 = position1DistanceFromLeft + position2DistanceFromRight + 1;
            int rowDistanceWrap2 = position1DistanceFromRight + position2DistanceFromLeft + 1;

            int rowDistanceWrap = rowDistanceWrap1 <= rowDistanceWrap2 ? rowDistanceWrap1 : rowDistanceWrap2;
            int rowDistance = rowDistanceNoWrap <= rowDistanceWrap ? rowDistanceNoWrap : rowDistanceWrap;


            int position1DistanceFromTop = position1[0];
            int position1DistanceFromBottom = columnLength - position1[0] - 1;
            int position2DistanceFromTop = currentPosition2[0];
            int position2DistanceFromBottom = columnLength - currentPosition2[0] - 1;

            int columnDistanceWrap1 = position1DistanceFromTop + position2DistanceFromBottom + 1;
            int columnDistanceWrap2 = position1DistanceFromBottom + position2DistanceFromTop + 1;

            int columnDistanceWrap = columnDistanceWrap1 <= columnDistanceWrap2 ? columnDistanceWrap1 : columnDistanceWrap2;
            int columnDistance = columnDistanceNoWrap <= columnDistanceWrap ? columnDistanceNoWrap : columnDistanceWrap;

            int totalDistance = rowDistance + columnDistance;
            distanceList.add(totalDistance);
        }
        int minDistance = Collections.min(distanceList);
        return String.valueOf(minDistance);
    }

    private static ArrayList<int[]> find2(String[] strArr) {
        ArrayList<int[]> positionOf2 = new ArrayList<int[]>();
        for (int i = 0; i < strArr.length; i++) {
            String row = strArr[i];
            for (int j = 0; j < row.length(); j++) {
                Integer integerValue = Character.getNumericValue(row.charAt(j));
                if (integerValue == 2) {
                    positionOf2.add(new int[]{i, j});
                }
            }
        }
        return positionOf2;
    }

    private static int[] find1(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String row = strArr[i];
            for (int j = 0; j < row.length(); j++) {
                Integer integerValue = Character.getNumericValue(row.charAt(j));
                if (integerValue == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static String NumberSearch(String str) {
        double sum = (double) Arrays.stream(str.split(""))
                .filter(stri -> stri.matches("[0-9]"))
                .map(Integer::valueOf)
                .reduce(0, (a, b) -> a + b);
        double numLetter = (double) Arrays.stream(str.split(""))
                .filter(stri -> stri.matches("(?i)[a-z]"))
                .count();
        return String.valueOf(Math.round(sum/numLetter));
    }
}
