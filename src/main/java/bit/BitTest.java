package bit;

public class BitTest {
	public static void main(String[] args) {
		System.out.println(-1 % 16);
		System.out.println(1 << 31);
		// 无符号右移，无论正负，高位均补零
		System.out.println(-1 >>> 28);
		// 带符号右移，正常移位，结束后再转换为对应补码（负数的补码与原码不同）
		System.out.println(-6 >> 1);
		System.out.println(-3 & 15);
	}
}