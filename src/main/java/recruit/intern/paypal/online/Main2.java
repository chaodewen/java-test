package recruit.intern.paypal.online;

/**
 * Created by Cc on 2017/4/13.
 */

import java.util.*;

public class Main2 {
    private static final int MIN = Integer.MIN_VALUE;
    private static int n, num;
    private static List<Integer> list;
    private static Set<Integer> set;
    private static void input(Scanner s) {
        n = s.nextInt();
        list = new ArrayList<>();
        set = new HashSet<>();
        num = MIN;
        s.nextLine();
        for(int temp; n > 0; n --) {
            temp = s.nextInt();
            if (num < temp) {
                num = temp;
            }
            list.add(temp);
            temp = s.nextInt();
            if (num < temp) {
                num = temp;
            }
            list.add(temp);
            s.nextLine();
            n--;
        }
    }
    private static void test(int[][] data) {
        for (int i = 0; i < data.length; ++i) {
            Arrays.fill(data[i], 0);
        }
        int x, y;
        for (int i = 0; i < list.size(); i += 2) {
            x = list.get(i) - 1;
            y = list.get(i + 1) - 1;
            data[x][y] = 1;
            data[y][x] = 1;
        }
        list.clear();
        set.clear();
    }
    private static void finish(int[][] data, Scanner scanner) {
        if (n == 0) {
            n = -1 * data.length;
            System.out.println(n);
            return;
        }
        while (n > 0) {
            set.add(scanner.nextInt()-1);
            scanner.nextLine();
            n--;
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input(scanner);
        int[][] data = new int[num][num];
        test(data);

        n = scanner.nextInt();
        scanner.nextLine();

        finish(data, scanner);

        solve(data);
    }
    private static void solve(int[][] data) {
        Floyd test = new Floyd();
        test.run(data);
        int sum = 0, ss;
        for (int i = 0; i < data.length; ++i) {
            if (!set.contains(i)) {
                ss = Integer.MAX_VALUE;
                for (int seti : set) {
                    if (test.distance[i][seti] < ss) {
                        ss = test.distance[i][seti];
                    }
                }
                if (ss == Integer.MAX_VALUE) {
                    ss = -1;
                }
                sum += ss;
            }
        }
        System.out.println(sum);
    }

    static class Floyd {
        int[][] distance = null;
        int[][][] path = null;

        private void abc(int[][] data) {
            // pre process paths
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (i == j) {
                        // self to self
                        distance[i][j] = 0;
                    } else if (data[i][j] == 0) {
                        // 0 means two points are unreachable
                        distance[i][j] = Integer.MAX_VALUE;
                    } else {
                        distance[i][j] = data[i][j];
                    }
                }
            }
        }
        public void run(int[][] data) {
            distance = new int[data.length][data.length];
            path = new int[data.length][data.length][];
            abc(data);
            def(data);
        }
        private void def(int[][] data) {
            for (int i = 0; i < data.length; ++i) {
                for (int j = 0; j < data.length; ++j) {
                    for (int k = 0; k < data.length; ++k) {
                        int tmp = (distance[j][i]==Integer.MAX_VALUE || distance[i][k]==Integer.MAX_VALUE) ? Integer.MAX_VALUE : (distance[j][i] + distance[i][k]);
                        if (distance[j][k] > tmp) {
                            distance[j][k] = distance[j][i] + distance[i][k];
                        }
                    }
                }
            }
        }
    }
}