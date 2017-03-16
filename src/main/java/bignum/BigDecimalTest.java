package bignum;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Cc on 2017/3/16.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            BigDecimal bd1 = new BigDecimal(s.next());
            BigDecimal bd2 = new BigDecimal(s.next());
            System.out.println(bd1.add(bd2));
        }
    }
}