package alibaba.internship;

/**
 * Created by Cc on 2017/3/2.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
        if(A.length < 5)
            return false;

        int[] sum = new int[A.length];

        sum[0] = A[0];
        for(int i = 1; i < A.length; i ++)
            sum[i] = sum[i - 1] + A[i];

        int left = 0, right = A.length - 1;

        while(left < right) {
            int lsum = sum[left], rsum = sum[A.length - 1] - sum[right - 1];

            if(lsum < rsum)
                left ++;
            else if(lsum > rsum)
                right --;
            else {
                int midleft = left + 2, midright = right - 2, mlsum = 0, mrsum = 0;

                if(midleft < midright) {
                    while(midleft < midright) {
                        if(mlsum > mrsum)
                            mrsum += A[midright --];
                        else
                            mlsum += A[midleft ++];
                    }

                    if(mlsum == mrsum && mlsum == lsum)
                        return true;
                }

                left ++;
                right --;
            }
        }

        return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}