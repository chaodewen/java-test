package recruit.intern.microsoft.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/31.
 */

public class B {
    private static int n, m, k;
    private static int[] numsOfLine, depth, leaf, parent;
    private static int[][] lines, path;
    private static boolean[] isLeaf;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            init(scanner);
            solve();
        }
        scanner.close();
    }
    private static void init(Scanner scanner) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        numsOfLine = new int[m];
        depth = new int[n + 1];
        lines = new int[m][];
        isLeaf = new boolean[n + 1];
        leaf = new int[k];
        path = new int[n + 1][n + 1];
        parent = new int[n + 1];

        for(int i = 0; i < m; i ++)
            numsOfLine[i] = scanner.nextInt();

        for(int i = 0; i < m; i ++) {
            lines[i] = new int[numsOfLine[i]];
            for(int j = 0; j < numsOfLine[i]; j ++) {
                lines[i][j] = scanner.nextInt();
                depth[lines[i][j]] = i;
            }
        }

        for(int i = 0; i < k; i ++) {
            leaf[i] = scanner.nextInt();
            isLeaf[leaf[i]] = true;
        }

        for (int i = 0; i < k; ++i)
            for (int j = 0; j < k; ++j)
                path[leaf[i]][leaf[j]] = scanner.nextInt();
    }
    private static void solve() {
        parent[1] = 0;
        for (int i = m - 1; i > 0; --i) {
            int o = 0, l = 0;
            for (; o < numsOfLine[i - 1] && isLeaf[lines[i - 1][o]]; ++o);
            parent[lines[i][0]] = lines[i - 1][o];
            for (int j = 1; j < numsOfLine[i]; ++j) {
                if (path[lines[i][j]][lines[i][l]] == 2) {
                    parent[lines[i][j]] = parent[lines[i][l]];
                } else {
                    for (o += 1; o < numsOfLine[i - 1] && isLeaf[lines[i - 1][o]]; ++o);
                    parent[lines[i][j]] = lines[i - 1][o];
                    l = j;
                }
            }
            for (int x = 0; x < numsOfLine[i]; ++x) {
                isLeaf[parent[lines[i][x]]] = true;
                for (int y = 0; y < numsOfLine[i]; ++y) {
                    path[parent[lines[i][y]]][parent[lines[i][x]]] = path[parent[lines[i][x]]][parent[lines[i][y]]] = path[lines[i][x]][lines[i][y]] - 2;
                }
                for (int y = 0; y < k; ++y) {
                    if (depth[leaf[y]] < i) {
                        path[leaf[y]][parent[lines[i][x]]] = path[parent[lines[i][x]]][leaf[y]] = path[lines[i][x]][leaf[y]] - 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; ++i) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}