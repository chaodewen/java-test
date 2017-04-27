package internship.baidu.online;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cc on 2017/4/27.
 */

class Point {
    double x, y, z;
    String c;

    public Point(String c, double x, double y, double z) {
        this.c = c;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Triangle {
    private static Point[] points;
    private static double ans;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            s.nextLine(); // 吃掉空行
            points = new Point[n];
            for (int i = 0; i < n; i++) {
                String[] linePart = s.nextLine().split(" ");
//                for(String str : linePart)
//                    System.out.println(str);
                points[i] = new Point(linePart[0], Integer.valueOf(linePart[1]), Integer.valueOf(linePart[2]), Integer.valueOf(linePart[3]));
            }
            ans = 0;
            solve(0, 0, 0, 0, new ArrayList<Point>());
            System.out.printf("%.5f\n", ans);
        }
        s.close();
    }

    private static void solve(int start, int r, int g, int b, ArrayList<Point> cur) {
        if(cur.size() == 3) {
            double curAns = calArea(cur);
            ans = ans < curAns ? curAns : ans;
        }
        if(start + 1 < points.length) {
            if(cur.size() == 2) {
                if(points[start].c.equals("R") && (r == 2 || g == 1 && b == 1)) {
                    cur.add(points[start]);
                    solve(start + 1, r + 1, g, b, cur);
                    cur.remove(cur.size() - 1);
                }
                else if(points[start].c.equals("G") && (g == 2 || r == 1 && b == 1)) {
                    cur.add(points[start]);
                    solve(start + 1, r, g + 1, b, cur);
                    cur.remove(cur.size() - 1);
                }
                else if(points[start].c.equals("B") && (b == 2 || r == 1 && g == 1)) {
                    cur.add(points[start]);
                    solve(start + 1, r, g, b + 1, cur);
                    cur.remove(cur.size() - 1);
                }
            }
            else if(cur.size() <= 1) {
                if(points[start].c.equals("R")) {
                    cur.add(points[start]);
                    solve(start + 1, r + 1, g, b, cur);
                    cur.remove(cur.size() - 1);
                }
                else if(points[start].c.equals("G")) {
                    cur.add(points[start]);
                    solve(start + 1, r, g + 1, b, cur);
                    cur.remove(cur.size() - 1);
                }
                else if(points[start].c.equals("B")) {
                    cur.add(points[start]);
                    solve(start + 1, r, g, b + 1, cur);
                    cur.remove(cur.size() - 1);
                }
            }
            solve(start + 1, r, g, b, cur);
        }
    }

    private static double calArea(ArrayList<Point> cur) {
        Point a = cur.get(0), b = cur.get(1), c = cur.get(2);
        double area = -1;

        double line1 = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
        double line2 = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2) + Math.pow(a.z - c.z, 2));
        double line3 = Math.sqrt(Math.pow(c.x - b.x, 2) + Math.pow(c.y - b.y, 2) + Math.pow(c.z - b.z, 2));

        // 不能构成三角形
        if (line1 + line2 <= line3 || line1 + line3 <= line2 || line2 + line3 <= line1)
            return area;

        // 利用海伦公式
        double p = (line1 + line2 + line3) / 2; // 半周长
        area = Math.sqrt(p * (p - line1) * (p - line2) * (p - line3));

        return area;
    }
}