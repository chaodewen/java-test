package internship.netease.online;

/**
 * Created by Cc on 2017/3/25.
 */

import java.util.Scanner;

public class Circle {
    private static void change(int[] circle, int k){
        int temp = circle[0];
        for(int i = 0; i < circle.length - 1; i++)
            circle[i] = (circle[i] + circle[i + 1]) % 100;

        circle[circle.length - 1] = (circle[circle.length - 1] + temp) % 100;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt(), k = scanner.nextInt();
            int[] circle = new int[n];

            for(int i = 0; i < n; i++)
                circle[i] = scanner.nextInt();

            for(; k > 0; k --)
                change(circle, k);

            for(int i = 0; i < n; i++) {
                if(i == n - 1)
                    System.out.print(circle[i]);
                else
                    System.out.print(circle[i] + " ");
            }
        }
    }
}