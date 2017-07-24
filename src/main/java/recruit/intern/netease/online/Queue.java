package recruit.intern.netease.online;

import java.util.Scanner;

/**
 * Created by Cc on 2017/3/25.
 */

public class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String queue = scanner.nextLine();
            System.out.println(cal(queue));
        }
    }
    private static int cal(String queue) {
        if(queue.isEmpty())
            return 0;

        if(queue.indexOf('B') == -1 || queue.indexOf('G') == -1)
            return 0;

        StringBuilder sb = new StringBuilder(queue);

        int bfirst = 0;
        while(sb.indexOf("B") - sb.lastIndexOf("G") != 1) {
            int lastG = sb.lastIndexOf("G");
            int lastBBefroreG = sb.substring(0, lastG).lastIndexOf('B');
            sb.deleteCharAt(lastBBefroreG);
            sb.insert(lastG, 'B');
            bfirst += lastG - lastBBefroreG;
        }

//        System.out.println(bfirst);

        sb = new StringBuilder(queue);

        int gfirst = 0;
        while(sb.indexOf("G") - sb.lastIndexOf("B") != 1) {
            int lastB = sb.lastIndexOf("B");
            int lastGBefroreB = sb.substring(0, lastB).lastIndexOf('G');
            sb.deleteCharAt(lastGBefroreB);
            sb.insert(lastB, 'G');
            gfirst += lastB - lastGBefroreB;
        }

//        System.out.println(gfirst);

        return bfirst > gfirst ? gfirst : bfirst;
    }
}