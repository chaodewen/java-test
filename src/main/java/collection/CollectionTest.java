package collection;

import java.util.*;

@SuppressWarnings("unused")
public class CollectionTest {
	public static void main(String[] args) {
//		testQueue();
//		testSet();
//		testMap();
		testTreeMap();
	}
	private static void testSet() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		System.out.println(set);
		Integer[] arr = set.toArray(new Integer[set.size()]);
		for(int str : arr) {
			System.out.println(str);
		}
	}
	private static void testQueue() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.poll();
		queue.isEmpty();
		while(!queue.isEmpty()) {
			queue.poll();
		}
		List<Integer> list = new LinkedList<>();
		list.add(1);
		queue.addAll(list);
		Queue<Integer> q = new PriorityQueue<>();
	}
	private static void testMap() {
		IdentityHashMap<String, String> map = new IdentityHashMap<>();
		map.put(new String("column"), "last_price");
		map.put(new String("column"), "update_time");
		System.out.println(map);
	}
	private static void testList() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.toArray(new Integer[list.size()]);
		LinkedList<Integer> ll = new LinkedList<>();
	}
	private static void testStack() {
		Stack<Integer> stack = new Stack<>();
	}
	private static void testTreeMap() {
		TreeMap<Integer, String> tree = new TreeMap<>();
		tree.put(1, "1");
		tree.put(2, "2");
		tree.put(3, "3");
		System.out.println(tree.get(2));
		System.out.println(tree.lowerKey(2));
		System.out.println(tree.higherKey(2));
	}
	private static void testArrays() {
		int[] nums = new int[] { 3, 31, 4, 312 };
		Integer[] newNums = new Integer[nums.length];

		for(int i = 0; i < nums.length; i ++)
			newNums[i] = nums[i];

		Arrays.sort(newNums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = String.valueOf(o1), str2 = String.valueOf(o2);
				return (str1 + str2).compareTo(str2 + str1);
			}
        });

		StringBuilder ans = new StringBuilder();

		for(Integer i : newNums)
			ans.append(i);

		while(ans.length() > 0 && ans.charAt(0) == '0')
			ans.deleteCharAt(0);

		System.out.println(ans.toString());
	}
}