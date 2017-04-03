package internship.microsoft.online;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Cc on 2017/3/31.
 */

class Node {
    double lastp, path;
    int level, l;
    boolean reset;
    public Node(double lastp, double path, int level, int l, boolean reset) {
        this.lastp = lastp;
        this.path = path;
        this.level = level;
        this.l = l;
        this.reset = reset;
    }
}

public class A2 {
    private static int p, q, n;
    private static void solve() {
        if(n == 0) {
            System.out.println(0.00);
            return;
        }

        double ans = 0;
        Queue<Node> nodes = new LinkedList<Node>();

        nodes.offer(new Node(p / 100d, 0, 0, 1, true));
        nodes.offer(new Node((100 - p) / 100d, 0, 0, 0, false));

        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            if(node.lastp != 0) {
                if(node.l == n)
                    ans += node.path * (node.level + 1);
                else {
                    if(node.reset) {
                        double newp = ((double) (p / (int) Math.pow(2, node.l))) / 100d;
                        double newpath = (node.path == 0 ? node.lastp * newp : node.path * newp);
                        double newpath2 = (node.path == 0 ? node.lastp * (1 - newp) : node.path * (1 - newp));
                        nodes.add(new Node(newp, newpath, node.level + 1, node.l + 1, true));
                        nodes.add(new Node(1 - newp, newpath2, node.level + 1, node.l, false));
                    }
                    else {
                        double newp = (node.lastp + q / 100d) > 1 ? 1 : (node.lastp + q / 100d);
                        double newpath = (node.path == 0 ? node.lastp * newp : node.path * newp);
                        double newpath2 = (node.path == 0 ? node.lastp * (1 - newp) : node.path * (1 - newp));
                        nodes.add(new Node(newp, newpath, node.level + 1, node.l + 1, true));
                        nodes.add(new Node(1 - newp, newpath2, node.level + 1, node.l, false));
                    }
                }
            }
        }

        System.out.printf("%.2f", ans);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            p = scanner.nextInt();
            q = scanner.nextInt();
            n = scanner.nextInt();

            solve();
        }
        scanner.close();
    }
}