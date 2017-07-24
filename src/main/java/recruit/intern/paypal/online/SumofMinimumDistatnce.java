package recruit.intern.paypal.online;

/**
 * Created by Cc on 2017/4/13.
 */

class Edge {
    int n1, n2;
    Edge(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
public class SumofMinimumDistatnce {
//    private static int n;        // 边的数量
//    private static Edge[] edges;    // 邻接矩阵
//    private static Set<Integer> nodes;
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        while(s.hasNext()) {
//            n = s.nextInt();
//            edges = new Edge[n];
//            nodes = new HashSet<>();
//            for(int i = 0; i < n; i ++) {
//                int u = s.nextInt(), v = s.nextInt();
//                nodes.add(u);
//                nodes.add(v);
//                edges[i] = new Edge(u, v);
//            }
//            int ans = 0, m = s.nextInt();
//            for(int i = 0; i < m; i ++)
//                ans += dijkstra(s.nextInt(), );
//
//            System.out.println(ans);
//        }
//        s.close();
//    }
//    public static int dijkstra(int vs) {
//        int[] dist = new int[nodes.size()], prev = new int[nodes.size()];
//        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
//        boolean[] flag = new boolean[nodes.size()];
//
//        // 初始化
//        for (int i = 0; i < nodes.size(); i++) {
//            flag[i] = false;          // 顶点i的最短路径还没获取到。
//            prev[i] = 0;              // 顶点i的前驱顶点为0。
//            dist[i] = mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
//        }
//
//        // 对"顶点vs"自身进行初始化
//        flag[vs] = true;
//        dist[vs] = 0;
//
//        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
//        int k=0;
//        for (int i = 1; i < nodes.size(); i++) {
//            // 寻找当前最小的路径；
//            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < nodes.size(); j++) {
//                if (flag[j]==false && dist[j]<min) {
//                    min = dist[j];
//                    k = j;
//                }
//            }
//            // 标记"顶点k"为已经获取到最短路径
//            flag[k] = true;
//
//            // 修正当前最短路径和前驱顶点
//            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
//            for (int j = 0; j < nodes.size(); j++) {
//                int tmp = (mMatrix[k][j]==Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + mMatrix[k][j]));
//                if (flag[j]==false && (tmp<dist[j]) ) {
//                    dist[j] = tmp;
//                    prev[j] = k;
//                }
//            }
//        }
//
//        int ans = 0;
//        for (int i=0; i < nodes.size(); i++)
//            ans += dist[i];
//
//        return ans;
//    }
}