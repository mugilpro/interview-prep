public class Search {

    public static void main(String[] args) {
        int arr[] = new int[] {2, 3, 3, 5, 5, 5, 5, 10, 11, 12};
        System.out.println(numberOfOccurrence(arr, 5));
    }

    static int numberOfOccurrence(int[] arr, int targetNumber) {
       int startIndex =  binarySearchforward(arr, targetNumber, 0, arr.length);
        int endIndex =  binarySearchBackward(arr, targetNumber, 0, arr.length);
        return endIndex -startIndex;
    }

   static int binarySearchforward(int[] arr, int targetNumber, int start, int end) {

        int m = start + (end - start) / 2;

        if (arr[m] == targetNumber && (m - 1) >= 0 && arr[m - 1] == targetNumber) {
            return binarySearchforward(arr, targetNumber, start, m);
        } else if (arr[m] == targetNumber && (m - 1) == 0) {
            return m;
        } else if (arr[m] == targetNumber && (m - 1) >= 0 && arr[m - 1] != targetNumber) {
            return m;
        } else if (arr[m] > targetNumber) {
            return binarySearchforward(arr, targetNumber, start, m-1);
        } else {
            return binarySearchforward(arr, targetNumber, m+1, end);
        }

    }

   static int binarySearchBackward(int[] arr, int targetNumber, int start, int end) {

        int m = start + (end - start) / 2;
        if (arr[m] == targetNumber && m + 1 <= arr.length && arr[m + 1] == targetNumber) {
            return binarySearchBackward(arr, targetNumber, m, end);
        } else if (arr[m] == targetNumber && m + 1 == arr.length) {
            return m;
        } else if (arr[m] == targetNumber && m + 1 <= arr.length && arr[m + 1] != targetNumber) {
            return m;
        } else if (arr[m] < targetNumber) {
            return binarySearchBackward(arr, targetNumber, m, end);
        } else {
            return binarySearchBackward(arr, targetNumber, start, m);
        }

    }
}
