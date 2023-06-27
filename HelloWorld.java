import java.util.*;
class HelloWorld {
        public static List<List<Integer>> findPairs(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : array) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                List<Integer> pair = Arrays.asList(complement, num);
                result.add(pair);
            }
            map.put(num, num);
        }

        return result;
    }

    public static int[] mergeAndSort(List<List<Integer>> array) {
        List<Integer> mergedArray = new ArrayList<>();
        for (List<Integer> subArray : array) {
            mergedArray.addAll(subArray);
        }
        Collections.sort(mergedArray);

        int[] mergedAndSortedArray = new int[mergedArray.size()];
        for (int i = 0; i < mergedArray.size(); i++) {
            mergedAndSortedArray[i] = mergedArray.get(i);
        }

        return mergedAndSortedArray;
    }

    public static List<List<Integer>> findDoubleCombinations(int[] array, int target) {
        int doubledTarget = target * 2;
        List<List<Integer>> pairs = findPairs(array, doubledTarget);

        return pairs;
    }
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 2, 2, -4, -6, -2, 8};
        int targetValue = 4;

        // Find pairs that sum up to the target value
        List<List<Integer>> firstCombinations = findPairs(inputArray, targetValue);
        System.out.println("First Combination For " + targetValue + " : " + firstCombinations);

        // Merge and sort the array
        int[] mergedArray = mergeAndSort(firstCombinations);
        System.out.println("Merge Into a single Array : " + Arrays.toString(mergedArray));

        // Find combinations that sum up to the doubled target value
        List<List<Integer>> doubledCombinations = findDoubleCombinations(mergedArray, targetValue);
        System.out.println("Second Combination For " + (targetValue * 2) + " : " + doubledCombinations);
    }
}