package bignum;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Cc on 2017/3/16.
 */

public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            BigInteger bi1 = new BigInteger(s.next());
            BigInteger bi2 = new BigInteger(s.next());
            System.out.println(bi1.add(bi2));
        }
    }
}