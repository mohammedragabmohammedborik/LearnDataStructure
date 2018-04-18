import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getPrice(n));
//        System.out.println(getNum(n));

    }

    private static long getPrice(int price) {
        int[] prices = {1, 5, 10, 20, 50, 100};
        long[] res = new long[price + 1];
        res[0] = 1L;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= price; j++) {
                if (j >= prices[i]) {
                    res[j] += res[j - prices[i]];
                }
            }
        }
        return res[price];
    }

    private static int getNum(int num) {
        int count = 0;
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            for (int i = 1; i < num; i++) {
                count += getNum(i);
            }
            count += 1;
        }
        return count;
    }

}
