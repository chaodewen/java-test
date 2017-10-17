package chaoyang;

import java.io.File;

/**
 * Created by Cc on 2017/10/17.
 */
public class TestDataGenerator {
    private static void gen(int start, int end, String resPath, String desPath) {
        File des = new File(desPath);
        if (!des.exists()) {
            des.mkdir();
        }

        for (int i = start; i <= end; i++) {
            File cur = new File(resPath + i + ".jpg");
            try {
                LayoutTransformer.copy(cur, new File(desPath + cur.getName()));
            } catch (Exception e) {
                System.out.println("Failure : " + desPath + cur.getName());
                continue;
            }
            System.out.println(desPath + cur.getName());
        }
    }
    public static void main(String[] args) {
//        gen(0, 1304, "/Users/Cc/Desktop/VOC_Chaoyang/labeled_data/JPEGImages/", "/Users/Cc/Desktop/xray_raw_data_test/61/");
//        gen(2611, 2753, "/Users/Cc/Desktop/VOC_Chaoyang/labeled_data/JPEGImages/", "/Users/Cc/Desktop/xray_raw_data_test/63/");
//        gen(2898, 3005, "/Users/Cc/Desktop/VOC_Chaoyang/labeled_data/JPEGImages/", "/Users/Cc/Desktop/xray_raw_data_test/64/");
//        gen(3115, 3130, "/Users/Cc/Desktop/VOC_Chaoyang/labeled_data/JPEGImages/", "/Users/Cc/Desktop/xray_raw_data_test/67/");

        gen(0, 1304, "/home/titan/chaodewen/data/whole/VOC_Chaoyang/labeled_data/JPEGImages/", "/home/titan/chaodewen/data/whole/xray_raw_data_test/61/");
        gen(2611, 2753, "/home/titan/chaodewen/data/whole/VOC_Chaoyang/labeled_data/JPEGImages/", "/home/titan/chaodewen/data/whole/xray_raw_data_test/63/");
        gen(2898, 3005, "/home/titan/chaodewen/data/whole/VOC_Chaoyang/labeled_data/JPEGImages/", "/home/titan/chaodewen/data/whole/xray_raw_data_test/64/");
        gen(3115, 3130, "/home/titan/chaodewen/data/whole/VOC_Chaoyang/labeled_data/JPEGImages/", "/home/titan/chaodewen/data/whole/xray_raw_data_test/67/");
    }
}
