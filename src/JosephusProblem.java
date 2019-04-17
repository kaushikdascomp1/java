public class JosephusProblem {
    /**
     * Killing a n people and skipping k in a circle
     *
     * @param args
     */
    public static void main(String args[]) {
        System.out.println(josephus(7, 3));
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }
}
