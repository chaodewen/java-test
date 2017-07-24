package recruit.intern.webank.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/4/25.
 */

class Line {
    int x1, y1, x2, y2;
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public boolean isLine() {
        if(x1 == x2 && y1 == y2)
            return false;
        return true;
    }
    public boolean equals(Line line) {
        if(x1 == 0 && line.x1 == 0 && x2 == 0 && line.x2 == 0)
            return true;
        if(y1 == 0 && line.y1 == 0 && y2 == 0 && line.y2 == 0)
            return true;
        double k1 = ((double) (y2 - y1)) / ((double) (x2 - x1));
        double k2 = ((double) (line.y2 - line.y1)) / ((double) (line.x2 - line.x1));
        double p1 = y2 - (x2 / ((double) (x1 - x2))) * (y1 - y2);
        double p2 = line.y2 - (line.x2 / ((double) (line.x1 - line.x2))) * (line.y1 - line.y2);
        if(Double.compare(k1, k2) == 0 && Double.compare(p1, p2) == 0)
            return true;
        return false;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Point p) {
        return x == p.x && y == p.y;
    }
}

public class Rect {
    private static Line[] lines;
    private static Point[] points;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            lines = new Line[4];
            points = new Point[4];
            boolean isRight = true;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                lines[i] = new Line(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
                if(isRight) {
                    if (!lines[i].isLine() || isDup(i))
                        isRight = false;
                    if(isNewPoint(lines[i].x1, lines[i].y1, cnt)) {
                        if(cnt == 4)
                            isRight = false;
                        else {
                            cnt ++;
                            points[cnt - 1] = new Point(lines[i].x1, lines[i].y1);
                        }
                    }
                    if(isNewPoint(lines[i].x2, lines[i].y2, cnt)) {
                        if(cnt == 4)
                            isRight = false;
                        else {
                            cnt ++;
                            points[cnt - 1] = new Point(lines[i].x2, lines[i].y2);
                        }
                    }
                }
            }

            if(isRight && cnt == 4)
                solve();
            else
                System.out.println("NO");
        }
        s.close();
    }
    private static boolean isDup(int i) {
        for(int j = 0; j < i; j ++)
            if(lines[j].equals(lines[i]))
                return true;
        return false;
    }
    private static void solve() {
        int cnt = 0;
        for(int i = 0; i < 4; i ++)
            for(int j = i + 1; j < 4; j ++)
                if(isVertical(lines[i], lines[j]))
                    cnt ++;
        System.out.println(cnt == 4 ? "YES" : "NO");
    }
    private static boolean isVertical(Line l1, Line l2) {
        if(l1.x1 == l1.x2 && l2.y1 == l2.y2
                || l1.y1 == l1.y2 && l2.x1 == l2.x2)
            return true;
        double k1 = ((double) (l1.y2 - l1.y1)) / ((double) (l1.x2 - l1.x1));
        double k2 = ((double) (l2.y2 - l2.y1)) / ((double) (l2.x2 - l2.x1));
        if(Double.compare(k1 * k2, -1) == 0)
            return true;
        return false;
    }
    private static boolean isNewPoint(int x, int y, int cnt) {
        for(int i = 0; i < cnt; i ++)
            if(new Point(x, y).equals(points[i]))
                return false;
        return true;
    }
}