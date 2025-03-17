public class Assignment14Score {
    public static int findMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;
        int maxLeft = findMax(arr, left, mid);
        int maxRight = findMax(arr, mid + 1, right);

        return Math.max(maxLeft, maxRight);
    }

    public static int findMin(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;
        int minLeft = findMin(arr, left, mid);
        int minRight = findMin(arr, mid + 1, right);

        return Math.min(minLeft, minRight);
    }

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    public static void main(String[] args) {
        int[] midtermScores = {78, 85, 90, 76, 92, 88, 80, 82};
        int[] finalScores = {82, 88, 87, 79, 95, 85, 83, 84};

        int maxScore = findMax(midtermScores, 0, midtermScores.length - 1);
        int minScore = findMin(midtermScores, 0, midtermScores.length - 1);
        double averageFinalScore = calculateAverage(finalScores);

        System.out.println("Highest UTS Score: " + maxScore);
        System.out.println("Lowest UTS Score: " + minScore);
        System.out.println("Average Final Score: " + averageFinalScore);
    }
}
